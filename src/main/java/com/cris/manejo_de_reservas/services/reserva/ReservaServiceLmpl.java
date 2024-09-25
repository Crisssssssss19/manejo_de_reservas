package com.cris.manejo_de_reservas.services.reserva;

import com.cris.manejo_de_reservas.entities.Reserva;
import com.cris.manejo_de_reservas.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservaServiceLmpl implements ReservaService{
    private ReservaRepository reservaRepository;

    public ReservaServiceLmpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public Optional<Reserva> buscarReservaPorId(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public List<Reserva> BuscarReserva() {
        return reservaRepository.findAll();
    }

    @Override
    public List<Reserva> BuscarReservasByIds(List<Long> ids) {
        return reservaRepository.findByIdIn(ids);
    }

    @Override
    public Optional<Reserva> actualizarReserva(Long id, Reserva reserva) {
        return reservaRepository.findById(id).map(reservaOld -> {
            reservaOld.setFecha_de_reserva(reserva.getFecha_de_reserva());
            reservaOld.setNumero_de_pasajeros(reserva.getNumero_de_pasajeros());
            return reservaRepository.save(reservaOld);
        });
    }

    @Override
    public void borrarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
