package com.cris.manejo_de_reservas.services.cliente;

import com.cris.manejo_de_reservas.dto.ClienteDto;
import com.cris.manejo_de_reservas.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    ClienteDto guardar (ClienteDto cliente);
    Optional<ClienteDto> buscarClientePorId(Long id);
    List<ClienteDto> BuscarCliente();
    List<ClienteDto>BuscarClientesByIds(List<Long> ids);
    List<ClienteDto>BuscarClientesByNombre(String nombre);
    Optional<ClienteDto> actualizarCliente(Long id,ClienteDto cliente);
    void borrarCliente(Long id);

}
