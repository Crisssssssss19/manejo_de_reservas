package com.cris.manejo_de_reservas.services.aeropuerto;

import com.cris.manejo_de_reservas.dto.AeropuertoDto;
import com.cris.manejo_de_reservas.entities.Aeropuerto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface AeropuertoService {
    AeropuertoDto guardarAeropuerto(AeropuertoDto aeropuerto);
    Optional<AeropuertoDto> buscarAeropuertoPorId(Long id);
    List<AeropuertoDto> buscarAeropuerto();
    List<AeropuertoDto> buscaraAropuertoPorIds(List<Long>ids);
    List<AeropuertoDto> buscarAeropuertoByNombre(String nombre);
    Optional<AeropuertoDto> actualizarAerolinea(Long id, AeropuertoDto aeropuerto);
    void borrarAerolinea(Long id);
}

