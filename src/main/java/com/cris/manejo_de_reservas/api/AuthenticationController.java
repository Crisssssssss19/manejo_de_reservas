package com.cris.manejo_de_reservas.api;


import com.cris.manejo_de_reservas.dto.JwtResponse;
import com.cris.manejo_de_reservas.dto.LoginRequest;
import com.cris.manejo_de_reservas.dto.SignupRequest;
import com.cris.manejo_de_reservas.entities.Erole;
import com.cris.manejo_de_reservas.entities.Role;
import com.cris.manejo_de_reservas.entities.Usuario;
import com.cris.manejo_de_reservas.repositories.RoleRepository;
import com.cris.manejo_de_reservas.repositories.UserRepository;
import com.cris.manejo_de_reservas.security.jwt.JwtUtil;
import com.cris.manejo_de_reservas.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthenticationController {
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

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
        return ResponseEntity.ok(new JwtResponse(jwtToken, "Bearer", userDetails.getId() ,userDetails.getUsername(), roles));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest sRequest){
        Set<Role> roles = new HashSet<>();
        for (String roleName : sRequest.roles()) {
            Role rol = roleRepository.findByName (Erole.valueOf(roleName))
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            roles.add(rol);
        }
        Usuario user = new Usuario(null,
                sRequest.nombre(),
                sRequest.apellido(),
                sRequest.direccion(),
                sRequest.telefono(),
                sRequest.fechaNacimiento(),
                sRequest.username(),
                passwordEncoder.encode(sRequest.password()),
                sRequest.email(),
                null,
                roles);
        Usuario newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser);
    }

    // Endpoint para verificar si el email, username o phone ya están registrados
    @PostMapping("/check")
    public ResponseEntity<Map<String, Boolean>> checkIfExists(@RequestBody Map<String, String> data) {
        String email = data.get("email");
        String username = data.get("username");

        boolean emailExists = userRepository.existsByEmail(email);
        boolean usernameExists = userRepository.existsByUsername(username);

        Map<String, Boolean> response = new HashMap<>();
        response.put("emailExists", emailExists);
        response.put("usernameExists", usernameExists);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/check-username/{username}")
    public ResponseEntity<?> checkUsername(@PathVariable String username) {
        boolean exists = userRepository.existsByUsername(username); // Lógica para verificar si el usuario existe
        if (!exists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Devuelve 404 si no existe

        }
        return ResponseEntity.ok().build();

    }

}