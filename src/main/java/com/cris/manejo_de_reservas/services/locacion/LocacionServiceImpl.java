package com.cris.manejo_de_reservas.services.locacion;

import com.cris.manejo_de_reservas.dto.LocacionDto;
import com.cris.manejo_de_reservas.mapper.LocacionMapper;
import com.cris.manejo_de_reservas.repositories.LocacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocacionServiceImpl implements LocacionService{
    private LocacionMapper locacionMapper;
    private LocacionRepository locacionRepository;

    @Override
    public LocacionDto guardar(LocacionDto locacionDto) {
        return locacionMapper.toIdDto(locacionRepository.save(locacionMapper.toIdEntity(locacionDto)));
    }

    @Override
    public List<LocacionDto> traerLocaciones() {
        return locacionMapper.toListDto((locacionRepository.findAll()));
    }

    @Override
    public Optional<LocacionDto> buscarLocacionPorId(Long id) {
        return Optional.of(locacionMapper.toIdDto(locacionRepository.findById(id).get()));
    }

    @Override
    public Optional<LocacionDto> buscarLocacionPorNombre(String nombre) {
        return Optional.of(locacionMapper.toIdDto(locacionRepository.findByNombre(nombre).get()));
    }

    @Override
    public void borrarLocacion(Long id) {
        locacionRepository.deleteById(id);
    }
}
