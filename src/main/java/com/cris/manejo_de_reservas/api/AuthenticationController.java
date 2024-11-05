package com.cris.manejo_de_reservas.api;


import com.cris.manejo_de_reservas.dto.JwtResponse;
import com.cris.manejo_de_reservas.dto.LoginRequest;
import com.cris.manejo_de_reservas.dto.SignupRequest;
import com.cris.manejo_de_reservas.entities.Usuario;
import com.cris.manejo_de_reservas.repositories.UserRepository;
import com.cris.manejo_de_reservas.security.jwt.JwtUtil;
import com.cris.manejo_de_reservas.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(),
                        loginRequest.password())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken= jwtUtil.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(role -> role.getAuthority()).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwtToken, "Bearer", userDetails.getUsername(), roles));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest sRequest){
        Usuario user = new Usuario(null,
                sRequest.username(),
                passwordEncoder.encode(sRequest.password()),
                sRequest.email(),
                new HashSet<>());
        Set<String> roles = sRequest.roles();
        Usuario newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser);
    }
}