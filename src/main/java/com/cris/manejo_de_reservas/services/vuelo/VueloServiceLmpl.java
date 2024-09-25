package com.cris.manejo_de_reservas.services.vuelo;

import com.cris.manejo_de_reservas.entities.Vuelo;
import com.cris.manejo_de_reservas.repositories.VueloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloServiceLmpl implements VueloService {

    private VueloRepository vueloRepository;

    public VueloServiceLmpl(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Override
    public Vuelo guardarVuelo(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    @Override
    public Optional<Vuelo> buscarVueloPorId(Long id) {
        return vueloRepository.findById(id);
    }

    @Override
    public List<Vuelo> BuscarVuelo() {
        return vueloRepository.findAll();
    }

    @Override
    public List<Vuelo> BuscarVueloByIds(List<Long> ids) {
        return vueloRepository.findByIdIn(ids);
    }

    @Override
    public Optional<Vuelo> actualizarVuelo(Long id, Vuelo vuelo) {
        return vueloRepository.findById(id).map( vueloOld ->{
            vueloOld.setOrigen(vuelo.getOrigen());
            vueloOld.setDestino(vuelo.getDestino());
            vueloOld.setFechaDeSalida(vuelo.getFechaDeSalida());
            vueloOld.setHoraDeSalida(vuelo.getHoraDeSalida());
            vueloOld.setDuracion(vuelo.getDuracion());
            vueloOld.setCapacidad(vuelo.getCapacidad());
            return vueloRepository.save(vueloOld);
        } );
    }

    @Override
    public void borrarVuelo(Long id) {
        vueloRepository.deleteById(id);
    }
}