package com.cris.manejo_de_reservas.services.pasajero;

import com.cris.manejo_de_reservas.dto.PasajeroDto;
import com.cris.manejo_de_reservas.entities.Pasajero;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


public interface PasajeroService {

    PasajeroDto guardarPasajero (PasajeroDto pasajero);
    Optional<PasajeroDto> buscarPasajeroPorId(Long id);
    List<PasajeroDto> BuscarPasajero();
    List<PasajeroDto>BuscarPasajeroByIds(List<Long> ids);
    List<PasajeroDto>BuscarPasajeroByNombre(String nombre);
    Optional<PasajeroDto> actualizarPasajero(Long id,PasajeroDto pasajero);
    void borrarPasajero(Long id);
}

