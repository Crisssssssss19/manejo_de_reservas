package com.cris.manejo_de_reservas.services.aerolinea;

import com.cris.manejo_de_reservas.entities.Aerolinea;
import com.cris.manejo_de_reservas.repositories.AerolineaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AerolineaServiceLmpl implements AerolineaService {
    private final AerolineaRepository aerolineaRepository;

    public AerolineaServiceLmpl(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }

    @Override
    public Aerolinea guardarAerolinea(Aerolinea aerolinea) {
        return aerolineaRepository.save(aerolinea);
    }

    @Override
    public Optional<Aerolinea> buscarAerolineaPorId(Long id) {
        return aerolineaRepository.findById(id);
    }

    @Override
    public List<Aerolinea> buscarAerolinea() {
        return aerolineaRepository.findAll();
    }

    @Override
    public List<Aerolinea> buscarAerolineaPorIds(List<Long> ids) {
        return aerolineaRepository.findByIdIn(ids);
    }

    @Override
    public List<Aerolinea> buscarAerolineaByNombre(String nombre) {
        return aerolineaRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Aerolinea> actualizarAerolinea(Long id, Aerolinea aerolinea) {
        return aerolineaRepository.findById(id).map(aerolineaOld -> {
            aerolineaOld.setNombre(aerolinea.getNombre());
            aerolineaOld.setCodigo_de_aerolinea(aerolinea.getCodigo_de_aerolinea());
            aerolineaOld.setPais_de_origen(aerolinea.getPais_de_origen());
            return aerolineaRepository.save(aerolineaOld);
        }) ;
    }

    @Override
    public void borrarAerolinea(Long id) {
        aerolineaRepository.deleteById(id);
    }
}
