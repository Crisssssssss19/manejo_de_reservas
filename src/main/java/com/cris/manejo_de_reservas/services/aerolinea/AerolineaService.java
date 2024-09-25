package com.cris.manejo_de_reservas.services.aerolinea;

import com.cris.manejo_de_reservas.entities.Aerolinea;

import java.util.List;
import java.util.Optional;

public interface AerolineaService {
    Aerolinea guardarAerolinea(Aerolinea aerolinea);
    Optional<Aerolinea> buscarAerolineaPorId(Long id);
    List<Aerolinea> buscarAerolinea();
    List<Aerolinea> buscarAerolineaPorIds(List<Long>ids);
    List<Aerolinea> buscarAerolineaByNombre(String nombre);
    Optional<Aerolinea> actualizarAerolinea(Long id, Aerolinea aerolinea);
    void borrarAerolinea(Long id);

}
