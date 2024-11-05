package com.cris.manejo_de_reservas.security.services;

import com.cris.manejo_de_reservas.entities.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDetailsLmpl implements UserDetails {
    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioDetailsLmpl(Long id, String userName, String email, String passwor, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = userName;
        this.email = email;
        this.password = passwor;
        this.authorities = authorities;
    }
    public static UsuarioDetailsLmpl build(Usuario usuario){
        List<GrantedAuthority> grantedAuthorities = usuario.getRole()
                .stream().map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new UsuarioDetailsLmpl(usuario.getId(),usuario.getUsername(),usuario.getEmail(),usuario.getPassword(), grantedAuthorities);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
