package com.cris.manejo_de_reservas.services;

import com.cris.manejo_de_reservas.entities.Cliente;
import com.cris.manejo_de_reservas.repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository getClienteRepository;

    public ClienteServiceImpl(ClienteRepository getClienteRepository) { //No se necesita preprosesar
        this.getClienteRepository = getClienteRepository;
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return null;
    }

    @Override
    public Optional<Cliente> buscarClientePorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Cliente> BuscarCliente() {
        return List.of();
    }

    @Override
    public List<Cliente> BuscarClientesByIds(List<Long> ids) {
        return List.of();
    }

    @Override
    public List<Cliente> BuscarClientesByNombre(String nombre) {
        return List.of();
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return null;
    }
}
