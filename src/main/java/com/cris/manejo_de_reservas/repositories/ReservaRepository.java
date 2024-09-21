package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByIdIn(List<Long> id);
}
