package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.ClienteDto;
import com.cris.manejo_de_reservas.entities.Usuario;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "role", target = "roles") // Mapear roles directamente si es necesario
    default UsuarioDto toIdDto(Usuario usuario) {
        if (usuario == null) return null;

        UsuarioDto dto = new UsuarioDto();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setDireccion(usuario.getDireccion());
        dto.setEmail(usuario.getEmail());
        dto.setTelefono(usuario.getTelefono());
        dto.setFechaNacimiento(usuario.getFechaNacimiento());

        // Asignar roles si están presentes, de lo contrario asignar un Set vacío
        if (usuario.getRole() != null) {
            dto.setRoles(new HashSet<>(usuario.getRole()));
        } else {
            dto.setRoles(Set.of());
        }

        return dto;
    }

    @Mapping(source = "id", target = "id")
    @Mapping(source = "roles", target = "role") // Mapear roles directamente
    default Usuario toIdEntity(UsuarioDto usuarioDto) {
        if (usuarioDto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setId(usuarioDto.getId());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setApellido(usuarioDto.getApellido());
        usuario.setDireccion(usuarioDto.getDireccion());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());

        // Asignar roles si están presentes, de lo contrario asignar un Set vacío
        if (usuarioDto.getRoles() != null) {
            usuario.setRole(new HashSet<>(usuarioDto.getRoles()));
        } else {
            usuario.setRole(Set.of());
        }

        return usuario;
    }

    default List<UsuarioDto> toDtoList(List<Usuario> usuarios) {
        if (usuarios == null || usuarios.isEmpty()) return List.of();
        return usuarios.stream().map(this::toIdDto).collect(Collectors.toList());
    }

    default List<Usuario> toEntityList(List<UsuarioDto> usuariosDto) {
        if (usuariosDto == null || usuariosDto.isEmpty()) return List.of();
        return usuariosDto.stream().map(this::toIdEntity).collect(Collectors.toList());
    }

}
