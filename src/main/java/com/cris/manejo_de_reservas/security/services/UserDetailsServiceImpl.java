package com.cris.manejo_de_reservas.security.services;

import com.cris.manejo_de_reservas.entities.Usuario;
import com.cris.manejo_de_reservas.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceLmpl implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("NotFoundUser"));
        return UserDetailsImpl.build(usuario);
    }
}