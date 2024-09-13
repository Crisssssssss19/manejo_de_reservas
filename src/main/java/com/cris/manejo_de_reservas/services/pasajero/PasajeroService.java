package com.cris.manejo_de_reservas.services.pasajero;

import com.cris.manejo_de_reservas.entities.Pasajero;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface PasajeroService {

    Pasajero guardarPasajero (Pasajero pasajero);
    Optional<Pasajero> buscarPasajeroPorId(Long id);
    List<Pasajero> BuscarPasajero();
    List<Pasajero>BuscarPasajeroByIds(List<Long> ids);
    List<Pasajero>BuscarPasajeroByNombre(String nombre);
    Optional<Pasajero> actualizarPasajero(Long id,Pasajero pasajero);

}

