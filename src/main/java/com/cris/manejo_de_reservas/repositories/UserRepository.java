package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUsername(String userName);
    Optional<Usuario> findByEmail(String userEmail);
    Boolean existsByUsername(String userName);
    Boolean existsByEmail(String email);
}
