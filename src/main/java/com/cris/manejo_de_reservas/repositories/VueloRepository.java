package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    List<Vuelo> findByNombre(String nombre);
    List<Vuelo> findByIdIn(List<Long> ids);
}
