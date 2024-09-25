package com.cris.manejo_de_reservas.services.cliente;

import com.cris.manejo_de_reservas.entities.Cliente;
import com.cris.manejo_de_reservas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceLmpl implements ClienteService {


    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceLmpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> BuscarCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> BuscarClientesByIds(List<Long> ids) {
        return clienteRepository.findByIdIn(ids);
    }

    @Override
    public List<Cliente> BuscarClientesByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Cliente> actualizarCliente(Long id,Cliente cliente) {
        return clienteRepository.findById(id).map(oldCliente -> {
            oldCliente.setNombre(cliente.getNombre());
            oldCliente.setApellido(cliente.getApellido());
            oldCliente.setEmail(cliente.getEmail());
            oldCliente.setDireccion(cliente.getDireccion());
            oldCliente.setTelefono(cliente.getTelefono());
            oldCliente.setFechaNacimiento(cliente.getFechaNacimiento());
            return clienteRepository.save(oldCliente);
        });
    }

    @Override
    public void borrarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}