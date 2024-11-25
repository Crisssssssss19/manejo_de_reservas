package com.cris.manejo_de_reservas.repositories;


import com.cris.manejo_de_reservas.entities.Locacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocacionRepository extends JpaRepository<Locacion, Long> {
Optional<Locacion> findByNombre(String nombre);
Optional<Locacion> findById(Long id);
}
