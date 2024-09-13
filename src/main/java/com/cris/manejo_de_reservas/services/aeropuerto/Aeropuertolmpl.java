package com.cris.manejo_de_reservas.services.aeropuerto;

import com.cris.manejo_de_reservas.entities.Aeropuerto;
import com.cris.manejo_de_reservas.repositories.AeropuertoRepository;
import java.util.List;
import java.util.Optional;


public class Aeropuertolmpl implements AeropuetoService{

    private AeropuertoRepository aeropuertoRepository;

    @Override
    public Aeropuerto guardarAeropuerto(Aeropuerto aeropuerto) {
        return aeropuertoRepository.save(aeropuerto);
    }

    @Override
    public Optional<Aeropuerto> buscarAeropuertoPorId(Long id) {
        return aeropuertoRepository.findById(id);
    }

    @Override
    public List<Aeropuerto> buscarAeropuerto() {
        return aeropuertoRepository.findAll();
    }

    @Override
    public List<Aeropuerto> buscaraAropuertoPorIds(List<Long> ids) {
        return aeropuertoRepository.findByIdIn(ids);
    }

    @Override
    public List<Aeropuerto> buscarAeropuertoByNombre(String nombre) {
        return aeropuertoRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Aeropuerto> actualizarAerolinea(Long id, Aeropuerto aeropuerto) {
        return aeropuertoRepository.findById(id).map(aeropuertoOld -> {
            aeropuertoOld.setNombre(aeropuerto.getNombre());
            aeropuertoOld.setCiudad(aeropuerto.getCiudad());
            aeropuertoOld.setPais(aeropuerto.getPais());
            return aeropuertoRepository.save(aeropuertoOld);
        });
    }
}
