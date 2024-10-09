package com.cris.manejo_de_reservas.services.reserva;

import com.cris.manejo_de_reservas.dto.ReservaDto;
import com.cris.manejo_de_reservas.entities.Reserva;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface ReservaService {

    ReservaDto guardarReserva(ReservaDto reserva);
    Optional<ReservaDto> buscarReservaPorId(Long id);
    List<ReservaDto> BuscarReserva();
    List<ReservaDto> BuscarReservasByIds(List<Long> ids);
    Optional<ReservaDto> actualizarReserva(Long id, ReservaDto reserva);
    void borrarReserva(Long id);

}

