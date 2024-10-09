package com.cris.manejo_de_reservas.services.pasajero;

import com.cris.manejo_de_reservas.dto.PasajeroDto;
import com.cris.manejo_de_reservas.entities.Pasajero;
import com.cris.manejo_de_reservas.mapper.PasajeroMapper;
import com.cris.manejo_de_reservas.repositories.PasajeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PasajeroServiceLmpl implements PasajeroService{
    private final PasajeroRepository pasajeroRepository;
    private final PasajeroMapper pasajeroMapper;

    @Override
    public PasajeroDto guardarPasajero(PasajeroDto pasajero) {
        return pasajeroMapper.toIdDto(pasajeroRepository.save(pasajeroMapper.toEntity(pasajero)));
    }

    @Override
    public Optional<PasajeroDto> buscarPasajeroPorId(Long id) {
        return Optional.of(pasajeroMapper.toIdDto(pasajeroRepository.findById(id).get()));
    }

    @Override
    public List<PasajeroDto> BuscarPasajero() {
        return pasajeroMapper.toListDto(pasajeroRepository.findAll());
    }

    @Override
    public List<PasajeroDto> BuscarPasajeroByIds(List<Long> ids) {
        return pasajeroMapper.toListDto(pasajeroRepository.findByIdIn(ids));
    }

    @Override
    public List<PasajeroDto> BuscarPasajeroByNombre(String nombre) {
        return pasajeroMapper.toListDto(pasajeroRepository.findByNombre(nombre));
    }

    @Override
    public Optional<PasajeroDto> actualizarPasajero(Long id, PasajeroDto pasajero) {
        return Optional.of( pasajeroMapper.toIdDto(pasajeroRepository.findById(id).map(pasajeroOld -> {
            pasajeroOld.setNombre(pasajero.nombre());
            pasajeroOld.setApellido(pasajero.apellido());
            pasajeroOld.setCc(pasajero.cc());
            pasajeroOld.setTelefono(pasajero.telefono());
            return pasajeroRepository.save(pasajeroOld);
        } ).get()));
    }

    @Override
    public void borrarPasajero(Long id) {
        pasajeroRepository.deleteById(id);
    }
}
