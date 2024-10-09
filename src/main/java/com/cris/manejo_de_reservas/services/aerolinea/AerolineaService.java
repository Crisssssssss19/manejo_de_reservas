package com.cris.manejo_de_reservas.services.aerolinea;

import com.cris.manejo_de_reservas.dto.AerolineaDto;
import com.cris.manejo_de_reservas.entities.Aerolinea;

import java.util.List;
import java.util.Optional;

public interface AerolineaService {
    AerolineaDto guardarAerolinea(AerolineaDto aerolinea);
    Optional<AerolineaDto> buscarAerolineaPorId(Long id);
    List<AerolineaDto> buscarAerolinea();
    List<AerolineaDto> buscarAerolineaPorIds(List<Long>ids);
    List<AerolineaDto> buscarAerolineaByNombre(String nombre);
    Optional<AerolineaDto> actualizarAerolinea(Long id, AerolineaDto aerolinea);
    void borrarAerolinea(Long id);

}
