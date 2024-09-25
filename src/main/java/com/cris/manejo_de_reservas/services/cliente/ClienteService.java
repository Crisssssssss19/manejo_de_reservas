package com.cris.manejo_de_reservas.services.cliente;

import com.cris.manejo_de_reservas.entities.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente guardar (Cliente cliente);
    Optional<Cliente> buscarClientePorId(Long id);
    List<Cliente> BuscarCliente();
    List<Cliente>BuscarClientesByIds(List<Long> ids);
    List<Cliente>BuscarClientesByNombre(String nombre);
    Optional<Cliente> actualizarCliente(Long id,Cliente cliente);
    void borrarCliente(Long id);

}
