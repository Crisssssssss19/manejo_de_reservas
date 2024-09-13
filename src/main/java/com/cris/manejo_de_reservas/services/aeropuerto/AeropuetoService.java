package com.cris.manejo_de_reservas.services.aeropuerto;

import com.cris.manejo_de_reservas.entities.Aeropuerto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface AeropuetoService {
    Aeropuerto guardarAeropuerto(Aeropuerto aeropuerto);
    Optional<Aeropuerto> buscarAeropuertoPorId(Long id);
    List<Aeropuerto> buscarAeropuerto();
    List<Aeropuerto> buscaraAropuertoPorIds(List<Long>ids);
    List<Aeropuerto> buscarAeropuertoByNombre(String nombre);
    Optional<Aeropuerto> actualizarAerolinea(Long id, Aeropuerto aeropuerto);

}

