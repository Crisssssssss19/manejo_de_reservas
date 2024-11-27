package com.cris.manejo_de_reservas.services.aeropuerto;

import com.cris.manejo_de_reservas.dto.AeropuertoDto;
import com.cris.manejo_de_reservas.entities.Aeropuerto;
import com.cris.manejo_de_reservas.mapper.AeropuertoMapper;
import com.cris.manejo_de_reservas.repositories.AeropuertoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AeropuertoServiceLmpl implements AeropuertoService {

    private final AeropuertoRepository aeropuertoRepository;
    private final AeropuertoMapper aeropuertoMapper;

    @Override
    public AeropuertoDto guardarAeropuerto(AeropuertoDto aeropuerto) {
        return aeropuertoMapper.toIdDto(aeropuertoRepository.save(aeropuertoMapper.toIdEntity(aeropuerto)));
    }

    @Override
    public Optional<AeropuertoDto> buscarAeropuertoPorId(Long id) {
        return Optional.of(aeropuertoMapper.toIdDto(aeropuertoRepository.findById(id).get())) ;
    }

    @Override
    public List<AeropuertoDto> buscarAeropuerto() {
        return aeropuertoMapper.toDtoList(aeropuertoRepository.findAll());
    }

    @Override
    public List<AeropuertoDto> buscaraAropuertoPorIds(List<Long> ids) {
        return aeropuertoMapper.toDtoList(aeropuertoRepository.findByIdIn(ids));
    }

    @Override
    public List<AeropuertoDto> buscarAeropuertoByNombre(String nombre) {
        return  aeropuertoMapper.toDtoList(aeropuertoRepository.findByNombre(nombre));
    }

    @Override
    public Optional<AeropuertoDto> actualizarAerolinea(Long id, AeropuertoDto aeropuerto) {
        return Optional.of(aeropuertoMapper.toIdDto(aeropuertoRepository.findById(id).map(aeropuertoOld -> {
            aeropuertoOld.setNombre(aeropuerto.getNombre());
            aeropuertoOld.setCiudad(aeropuerto.getCiudad());
            aeropuertoOld.setPais(aeropuerto.getPais());
            return aeropuertoRepository.save(aeropuertoOld);
        }).get()));
    }

    @Override
    public void borrarAerolinea(Long id) {
        aeropuertoRepository.deleteById(id);
    }

}
