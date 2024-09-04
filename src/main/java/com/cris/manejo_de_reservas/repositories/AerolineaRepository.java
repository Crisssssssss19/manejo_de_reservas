package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
}
