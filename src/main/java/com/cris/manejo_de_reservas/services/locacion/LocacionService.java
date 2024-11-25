package com.cris.manejo_de_reservas.services.locacion;

import com.cris.manejo_de_reservas.dto.LocacionDto;
import com.cris.manejo_de_reservas.entities.Locacion;

import java.util.List;
import java.util.Optional;

public interface LocacionService {
    LocacionDto guardar (LocacionDto locacionDto);
    List<LocacionDto> traerLocaciones();
    Optional<LocacionDto> buscarLocacionPorId(Long id);
    Optional<LocacionDto> buscarLocacionPorNombre(String nombre);
    void borrarLocacion(Long id);
}
