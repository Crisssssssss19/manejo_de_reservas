package com.cris.manejo_de_reservas.services.vuelo;

import com.cris.manejo_de_reservas.dto.VueloDto;
import com.cris.manejo_de_reservas.entities.Vuelo;
import com.cris.manejo_de_reservas.mapper.VueloMapper;
import com.cris.manejo_de_reservas.repositories.VueloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VueloServiceLmpl implements VueloService {

    private final VueloMapper vueloMapper;
    private final VueloRepository vueloRepository;

    @Override
    public VueloDto guardarVuelo(VueloDto vuelo) {
        return vueloMapper.toIdDto(vueloRepository.save(vueloMapper.toIdEntity(vuelo)));
    }

    @Override
    public Optional<VueloDto> buscarVueloPorId(Long id) {
        return Optional.of(vueloMapper.toIdDto(vueloRepository.findById(id).get()));
    }

    @Override
    public List<VueloDto> BuscarVuelo() {
        return vueloMapper.toListDto(vueloRepository.findAll());
    }

    @Override
    public List<VueloDto> BuscarVueloByIds(List<Long> ids) {
        return vueloMapper.toListDto(vueloRepository.findByIdIn(ids));
    }

    @Override
    public Optional<VueloDto> actualizarVuelo(Long id, VueloDto vuelo) {
        return Optional.of(vueloMapper.toIdDto(vueloRepository.findById(id).map( vueloOld ->{
            vueloOld.setId_origen(vuelo.origen());
            vueloOld.setId_destino(vuelo.destino());
            vueloOld.setFechaDeSalida(vuelo.fechaDeSalida());
            vueloOld.setDuracion(vuelo.duracion());
            vueloOld.setCapacidad(vuelo.capacidad());
            return vueloRepository.save(vueloOld);
        }).get()));

    }

    @Override
    public void borrarVuelo(Long id) {
        vueloRepository.deleteById(id);
    }
}
