package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
}
