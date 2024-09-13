package com.cris.manejo_de_reservas.services.reserva;

import com.cris.manejo_de_reservas.entities.Reserva;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface ReservaService {

    Reserva guardarReserva(Reserva reserva);
    Optional<Reserva> buscarReservaPorId(Long id);
    List<Reserva> BuscarReserva();
    List<Reserva> BuscarReservasByIds(List<Long> ids);
    List<Reserva> BuscarReservaByNombre(String nombre);
    Optional<Reserva> actualizarReserva(Long id, Reserva reserva);
}

