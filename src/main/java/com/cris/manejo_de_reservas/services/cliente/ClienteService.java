package com.cris.manejo_de_reservas.services.cliente;

import com.cris.manejo_de_reservas.dto.VueloDto;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    VueloDto.UsuarioDto guardar (VueloDto.UsuarioDto usuarioDto);
    Optional<VueloDto.UsuarioDto> buscarClientePorId(Long id);
    List<VueloDto.UsuarioDto> BuscarCliente();
    List<VueloDto.UsuarioDto>BuscarClientesByIds(List<Long> ids);
    List<VueloDto.UsuarioDto>BuscarClientesByNombre(String nombre);
    Optional<VueloDto.UsuarioDto> actualizarCliente(Long id, VueloDto.UsuarioDto usuarioDto);
    void borrarCliente(Long id);

}
