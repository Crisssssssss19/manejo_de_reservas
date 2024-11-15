package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Erole;
import com.cris.manejo_de_reservas.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Erole rol);
}
