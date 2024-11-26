package com.cris.manejo_de_reservas.services.cliente;

import com.cris.manejo_de_reservas.dto.ClienteDto;
import com.cris.manejo_de_reservas.entities.Usuario;
import com.cris.manejo_de_reservas.mapper.UsuarioDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    UsuarioDto guardar (UsuarioDto usuarioDto);
    Optional<UsuarioDto> buscarClientePorId(Long id);
    List<UsuarioDto> BuscarCliente();
    List<UsuarioDto>BuscarClientesByIds(List<Long> ids);
    List<UsuarioDto>BuscarClientesByNombre(String nombre);
    Optional<UsuarioDto> actualizarCliente(Long id,UsuarioDto usuarioDto);
    void borrarCliente(Long id);

}
