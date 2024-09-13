package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Cliente;
import com.cris.manejo_de_reservas.entities.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero,Long> {
    List<Pasajero> findByNombre(String nombre);
    List<Pasajero> findByIdIn(List<Long> ids);
}
