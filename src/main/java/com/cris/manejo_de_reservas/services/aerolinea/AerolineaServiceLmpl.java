package com.cris.manejo_de_reservas.services.aerolinea;

import com.cris.manejo_de_reservas.dto.AerolineaDto;
import com.cris.manejo_de_reservas.mapper.AerolineaMapper;
import com.cris.manejo_de_reservas.repositories.AerolineaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AerolineaServiceLmpl implements AerolineaService {

    private final AerolineaRepository aerolineaRepository;
    private final AerolineaMapper aerolineaMapper;

    @Override
    public AerolineaDto guardarAerolinea(AerolineaDto aerolinea) {
        return aerolineaMapper.toIdDto(aerolineaRepository.save(aerolineaMapper.toIdEntity(aerolinea)));
    }

    @Override
    public Optional<AerolineaDto> buscarAerolineaPorId(Long id) {
        return Optional.of(aerolineaMapper.toIdDto(aerolineaRepository.findById(id).get()));
    }

    @Override
    public List<AerolineaDto> buscarAerolinea() {
        return aerolineaMapper.toDtoList(aerolineaRepository.findAll());
    }

    @Override
    public List<AerolineaDto> buscarAerolineaPorIds(List<Long> ids) {
        return aerolineaMapper.toDtoList(aerolineaRepository.findByIdIn(ids));
    }

    @Override
    public List<AerolineaDto> buscarAerolineaByNombre(String nombre) {
        return aerolineaMapper.toDtoList(aerolineaRepository.findByNombre(nombre));
    }

    @Override
    public Optional<AerolineaDto> actualizarAerolinea(Long id, AerolineaDto aerolinea) {
        return Optional.of(aerolineaMapper.toIdDto(aerolineaRepository.findById(id).map(aerolineaOld -> {
            aerolineaOld.setNombre(aerolinea.getNombre());
            aerolineaOld.setCodigo_de_aerolinea(aerolinea.getCodigo_de_aerolinea());
            aerolineaOld.setPais_de_origen(aerolinea.getPais_de_origen());
            return aerolineaRepository.save(aerolineaOld);
            }).get()));
    }

    @Override
    public void borrarAerolinea(Long id) {
        aerolineaRepository.deleteById(id);
    }
}
