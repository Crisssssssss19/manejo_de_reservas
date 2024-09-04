package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
