package com.cris.manejo_de_reservas.services.reserva;

import com.cris.manejo_de_reservas.dto.ReservaDto;
import com.cris.manejo_de_reservas.entities.Reserva;
import com.cris.manejo_de_reservas.mapper.ReservaMapper;
import com.cris.manejo_de_reservas.repositories.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ReservaServiceLmpl implements ReservaService{
    private ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;

    @Override
    public ReservaDto guardarReserva(ReservaDto reserva) {
        return reservaMapper.toReservaDto(reservaRepository.save(reservaMapper.toReservaEntity(reserva)));
    }

    @Override
    public Optional<ReservaDto> buscarReservaPorId(Long id) {
        return Optional.of(reservaMapper.toReservaDto(reservaRepository.findById(id).get()));
    }

    @Override
    public List<ReservaDto> BuscarReserva() {
        return reservaMapper.toDtoList(reservaRepository.findAll());
    }

    @Override
    public List<ReservaDto> BuscarReservasByIds(List<Long> ids) {
        return reservaMapper.toDtoList(reservaRepository.findByIdIn(ids));
    }

    @Override
    public Optional<ReservaDto> actualizarReserva(Long id, ReservaDto reserva) {
        return Optional.of(reservaMapper.toReservaDto(reservaRepository.findById(id).map(reservaOld -> {
            reservaOld.setFecha_de_reserva(reserva.getFrechaReserva());
            reservaOld.setNumero_de_pasajeros(reserva.getNumeroDePasajeros());
            return reservaRepository.save(reservaOld);
        }).get()));
    }

    @Override
    public void borrarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
