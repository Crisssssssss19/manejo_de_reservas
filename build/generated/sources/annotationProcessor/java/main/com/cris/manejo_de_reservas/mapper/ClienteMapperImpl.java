package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.ClienteDto;
import com.cris.manejo_de_reservas.entities.Cliente;
import com.cris.manejo_de_reservas.entities.Reserva;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-08T18:24:45-0500",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteDto toIdDto(Cliente cliente) {
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

        id = cliente.getId();
        nombre = cliente.getNombre();
        apellido = cliente.getApellido();
        direccion = cliente.getDireccion();
        email = cliente.getEmail();
        telefono = cliente.getTelefono();
        fechaNacimiento = cliente.getFechaNacimiento();
        reserva = cliente.getReserva();

        ClienteDto clienteDto = new ClienteDto( id, nombre, apellido, direccion, email, telefono, fechaNacimiento, reserva );

        return clienteDto;
    }

    @Override
    public Cliente toIDEntity(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setId( clienteDto.id() );
        cliente.setNombre( clienteDto.nombre() );
        cliente.setApellido( clienteDto.apellido() );
        cliente.setDireccion( clienteDto.direccion() );
        cliente.setEmail( clienteDto.email() );
        cliente.setTelefono( clienteDto.telefono() );
        cliente.setFechaNacimiento( clienteDto.fechaNacimiento() );
        cliente.setReserva( clienteDto.reserva() );

        return cliente;
    }

    @Override
    public List<ClienteDto> toListDto(List<Cliente> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<ClienteDto> list = new ArrayList<ClienteDto>( clientes.size() );
        for ( Cliente cliente : clientes ) {
            list.add( clienteToClienteDto( cliente ) );
        }

        return list;
    }

    @Override
    public List<Cliente> toListEntity(List<ClienteDto> clienteDtos) {
        if ( clienteDtos == null ) {
            return null;
        }

        List<Cliente> list = new ArrayList<Cliente>( clienteDtos.size() );
        for ( ClienteDto clienteDto : clienteDtos ) {
            list.add( toEntity( clienteDto ) );
        }

        return list;
    }

    @Override
    public ClienteDto toDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        String nombre = null;
        String apellido = null;
        String direccion = null;
        String email = null;
        String telefono = null;
        Date fechaNacimiento = null;
        Reserva reserva = null;

        nombre = cliente.getNombre();
        apellido = cliente.getApellido();
        direccion = cliente.getDireccion();
        email = cliente.getEmail();
        telefono = cliente.getTelefono();
        fechaNacimiento = cliente.getFechaNacimiento();
        reserva = cliente.getReserva();

        Long id = null;

        ClienteDto clienteDto = new ClienteDto( id, nombre, apellido, direccion, email, telefono, fechaNacimiento, reserva );

        return clienteDto;
    }

    @Override
    public Cliente toEntity(ClienteDto clienteDto) {
        if ( clienteDto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setNombre( clienteDto.nombre() );
        cliente.setApellido( clienteDto.apellido() );
        cliente.setDireccion( clienteDto.direccion() );
        cliente.setEmail( clienteDto.email() );
        cliente.setTelefono( clienteDto.telefono() );
        cliente.setFechaNacimiento( clienteDto.fechaNacimiento() );
        cliente.setReserva( clienteDto.reserva() );

        return cliente;
    }

    @Override
    public List<ClienteDto> toListDtoSinId(List<Cliente> clientes) {
        if ( clientes == null ) {
            return null;
        }

        List<ClienteDto> list = new ArrayList<ClienteDto>( clientes.size() );
        for ( Cliente cliente : clientes ) {
            list.add( clienteToClienteDto( cliente ) );
        }

        return list;
    }

    @Override
    public List<Cliente> toListEntitySinId(List<ClienteDto> clienteDtos) {
        if ( clienteDtos == null ) {
            return null;
        }

        List<Cliente> list = new ArrayList<Cliente>( clienteDtos.size() );
        for ( ClienteDto clienteDto : clienteDtos ) {
            list.add( toEntity( clienteDto ) );
        }

        return list;
    }

    protected ClienteDto clienteToClienteDto(Cliente cliente) {
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

        id = cliente.getId();
        nombre = cliente.getNombre();
        apellido = cliente.getApellido();
        direccion = cliente.getDireccion();
        email = cliente.getEmail();
        telefono = cliente.getTelefono();
        fechaNacimiento = cliente.getFechaNacimiento();
        reserva = cliente.getReserva();

        ClienteDto clienteDto = new ClienteDto( id, nombre, apellido, direccion, email, telefono, fechaNacimiento, reserva );

        return clienteDto;
    }
}
