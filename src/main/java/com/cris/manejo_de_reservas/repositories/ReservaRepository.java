package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
