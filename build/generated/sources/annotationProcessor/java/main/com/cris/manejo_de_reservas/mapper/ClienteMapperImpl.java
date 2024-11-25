package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.ClienteDto;
import com.cris.manejo_de_reservas.entities.Reserva;
import com.cris.manejo_de_reservas.entities.Usuario;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T13:44:03-0500",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDto toIdDto(Usuario cliente) {
        if ( cliente == null ) {
            return null;
        }

        Long id = null;

        id = cliente.id;

        String nombre = null;
        String apellido = null;
        String direccion = null;
        String email = null;
        String telefono = null;
        Date fechaNacimiento = null;
        Reserva reserva = null;
        Set<String> roles = null;

        ClienteDto clienteDto = new ClienteDto( id, nombre, apellido, direccion, email, telefono, fechaNacimiento, reserva, roles );

        return clienteDto;
    }

    @Override
    public Usuario toIDEntity(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.id = clienteDto.id();

        return usuario;
    }

    @Override
    public List<ClienteDto> toListDto(List<Usuario> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<ClienteDto> list = new ArrayList<ClienteDto>( clientes.size() );
        for ( Usuario usuario : clientes ) {
            list.add( usuarioToClienteDto( usuario ) );
        }

        return list;
    }

    @Override
    public List<Usuario> toListEntity(List<ClienteDto> clienteDtos) {
        if ( clienteDtos == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( clienteDtos.size() );
        for ( ClienteDto clienteDto : clienteDtos ) {
            list.add( toEntity( clienteDto ) );
        }

        return list;
    }

    @Override
    public ClienteDto toDto(Usuario cliente) {
        if ( cliente == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String apellido = null;
        String direccion = null;
        String email = null;
        String telefono = null;
        Date fechaNacimiento = null;
        Reserva reserva = null;
        Set<String> roles = null;

        ClienteDto clienteDto = new ClienteDto( id, nombre, apellido, direccion, email, telefono, fechaNacimiento, reserva, roles );

        return clienteDto;
    }

    @Override
    public Usuario toEntity(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        return usuario;
    }

    @Override
    public List<ClienteDto> toListDtoSinId(List<Usuario> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<ClienteDto> list = new ArrayList<ClienteDto>( clientes.size() );
        for ( Usuario usuario : clientes ) {
            list.add( usuarioToClienteDto( usuario ) );
        }

        return list;
    }

    @Override
    public List<Usuario> toListEntitySinId(List<ClienteDto> clienteDtos) {
        if ( clienteDtos == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( clienteDtos.size() );
        for ( ClienteDto clienteDto : clienteDtos ) {
            list.add( toEntity( clienteDto ) );
        }

        return list;
    }

    protected ClienteDto usuarioToClienteDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        Long id = null;

        id = usuario.id;

        String nombre = null;
        String apellido = null;
        String direccion = null;
        String email = null;
        String telefono = null;
        Date fechaNacimiento = null;
        Reserva reserva = null;
        Set<String> roles = null;

        ClienteDto clienteDto = new ClienteDto( id, nombre, apellido, direccion, email, telefono, fechaNacimiento, reserva, roles );

        return clienteDto;
    }
}
