package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
    List<Aerolinea> findByNombre(String nonbre);
    List<Aerolinea> findByIdIn(List<Long> ids);
    List<Aerolinea> findByCodigo_de_aerolinea(Integer codigo);
}
