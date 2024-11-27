package com.cris.manejo_de_reservas.services.cliente;

import com.cris.manejo_de_reservas.dto.VueloDto;
import com.cris.manejo_de_reservas.entities.Usuario;
import com.cris.manejo_de_reservas.mapper.ClienteMapper;
import com.cris.manejo_de_reservas.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceLmpl implements ClienteService {
    private final ClienteMapper clienteMapper;
    private ClienteRepository clienteRepository;
//
    @Override
    public VueloDto.UsuarioDto guardar(VueloDto.UsuarioDto usuarioDto) {
        return clienteMapper.toIdDto(clienteRepository.save(clienteMapper.toIdEntity(usuarioDto)));
    }

    @Override
    public Optional<VueloDto.UsuarioDto> buscarClientePorId(Long id) {
        return Optional.of(clienteMapper.toIdDto(clienteRepository.findById(id).get()));
    }

    @Override
    public List<VueloDto.UsuarioDto> BuscarCliente() {
        List<Usuario> usuarios =clienteRepository.findAll();
        if (usuarios.isEmpty()) return null;
        List<VueloDto.UsuarioDto> usuarioDtos = new ArrayList<>();
        for (Usuario usuario: usuarios){
            usuarioDtos.add(clienteMapper.toIdDto(usuario));
        }
        return usuarioDtos;
   }

    @Override
    public List<VueloDto.UsuarioDto> BuscarClientesByIds(List<Long> ids) {
        return clienteMapper.toDtoList(clienteRepository.findByIdIn(ids));
    }

    @Override
    public List<VueloDto.UsuarioDto> BuscarClientesByNombre(String nombre) {
        return clienteMapper.toDtoList(clienteRepository.findByNombre(nombre));
    }

    @Override
    public Optional<VueloDto.UsuarioDto> actualizarCliente(Long id, VueloDto.UsuarioDto usuarioDto) {
        return Optional.of(clienteMapper.toIdDto(clienteRepository.findById(id).map(oldCliente -> {

            oldCliente.setNombre(usuarioDto.getNombre());
            oldCliente.setApellido(usuarioDto.getApellido());
            oldCliente.setEmail(usuarioDto.getEmail());
            oldCliente.setDireccion(usuarioDto.getDireccion());
            oldCliente.setTelefono(usuarioDto.getTelefono());
            oldCliente.setFechaNacimiento(usuarioDto.getFechaNacimiento());
            return clienteRepository.save(oldCliente);
        }).get()));
    }

    @Override
    public void borrarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
