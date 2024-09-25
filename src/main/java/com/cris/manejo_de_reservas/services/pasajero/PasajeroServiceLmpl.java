package com.cris.manejo_de_reservas.services.pasajero;

import com.cris.manejo_de_reservas.entities.Pasajero;
import com.cris.manejo_de_reservas.repositories.PasajeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroServiceLmpl implements PasajeroService{
    private PasajeroRepository pasajeroRepository;

    public PasajeroServiceLmpl(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    @Override
    public Pasajero guardarPasajero(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    @Override
    public Optional<Pasajero> buscarPasajeroPorId(Long id) {
        return pasajeroRepository.findById(id);
    }

    @Override
    public List<Pasajero> BuscarPasajero() {
        return pasajeroRepository.findAll();
    }

    @Override
    public List<Pasajero> BuscarPasajeroByIds(List<Long> ids) {
        return pasajeroRepository.findByIdIn(ids);
    }

    @Override
    public List<Pasajero> BuscarPasajeroByNombre(String nombre) {
        return pasajeroRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Pasajero> actualizarPasajero(Long id, Pasajero pasajero) {
        return pasajeroRepository.findById(id).map(pasajeroOld -> {
            pasajeroOld.setNombre(pasajero.getNombre());
            pasajeroOld.setApellido(pasajero.getApellido());
            pasajeroOld.setCc(pasajero.getCc());
            pasajeroOld.setTelefono(pasajero.getTelefono());
            return pasajeroRepository.save(pasajeroOld);
        } );
    }

    @Override
    public void borrarPasajero(Long id) {
        pasajeroRepository.deleteById(id);
    }
}
