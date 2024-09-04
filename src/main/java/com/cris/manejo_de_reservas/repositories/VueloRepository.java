package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
}
