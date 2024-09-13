package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
    List<Aeropuerto> findByNombre(String nombre);
    List<Aeropuerto> findByIdIn(List<Long> ids);
}
