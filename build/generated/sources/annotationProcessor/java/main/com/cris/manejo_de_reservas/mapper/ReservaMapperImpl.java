package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.ReservaDto;
import com.cris.manejo_de_reservas.entities.Cliente;
import com.cris.manejo_de_reservas.entities.Pasajero;
import com.cris.manejo_de_reservas.entities.Reserva;
import com.cris.manejo_de_reservas.entities.Vuelo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-08T18:39:20-0500",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ReservaMapperImpl implements ReservaMapper {

    @Override
    public ReservaDto toIdDto(Reserva reserva) {
        if ( reserva == null ) {
            return null;
        }

        Long id = null;
        List<Cliente> clientes = null;
        List<Vuelo> vuelos = null;
        Pasajero id_reserva = null;

        id = reserva.getId();
        List<Cliente> list = reserva.getClientes();
        if ( list != null ) {
            clientes = new ArrayList<Cliente>( list );
        }
        List<Vuelo> list1 = reserva.getVuelos();
        if ( list1 != null ) {
            vuelos = new ArrayList<Vuelo>( list1 );
        }
        id_reserva = reserva.getId_reserva();

        Date frechaReserva = null;
        Integer numeroDePasajeros = null;

        ReservaDto reservaDto = new ReservaDto( id, frechaReserva, numeroDePasajeros, clientes, vuelos, id_reserva );

        return reservaDto;
    }

    @Override
    public Reserva toIDEntity(ReservaDto reservaDto) {
        if ( reservaDto == null ) {
            return null;
        }

        Reserva reserva = new Reserva();

        reserva.setId( reservaDto.id() );
        List<Cliente> list = reservaDto.clientes();
        if ( list != null ) {
            reserva.setClientes( new ArrayList<Cliente>( list ) );
        }
        List<Vuelo> list1 = reservaDto.vuelos();
        if ( list1 != null ) {
            reserva.setVuelos( new ArrayList<Vuelo>( list1 ) );
        }
        reserva.setId_reserva( reservaDto.id_reserva() );

        return reserva;
    }

    @Override
    public List<ReservaDto> toListDto(List<Reserva> reservas) {
        if ( reservas == null ) {
            return null;
        }

        List<ReservaDto> list = new ArrayList<ReservaDto>( reservas.size() );
        for ( Reserva reserva : reservas ) {
            list.add( reservaToReservaDto( reserva ) );
        }

        return list;
    }

    @Override
    public List<Reserva> toListEntity(List<ReservaDto> reservaDtos) {
        if ( reservaDtos == null ) {
            return null;
        }

        List<Reserva> list = new ArrayList<Reserva>( reservaDtos.size() );
        for ( ReservaDto reservaDto : reservaDtos ) {
            list.add( toEntity( reservaDto ) );
        }

        return list;
    }

    @Override
    public ReservaDto toDto(Reserva reserva) {
        if ( reserva == null ) {
            return null;
        }

        List<Cliente> clientes = null;
        List<Vuelo> vuelos = null;
        Pasajero id_reserva = null;

        List<Cliente> list = reserva.getClientes();
        if ( list != null ) {
            clientes = new ArrayList<Cliente>( list );
        }
        List<Vuelo> list1 = reserva.getVuelos();
        if ( list1 != null ) {
            vuelos = new ArrayList<Vuelo>( list1 );
        }
        id_reserva = reserva.getId_reserva();

        Long id = null;
        Date frechaReserva = null;
        Integer numeroDePasajeros = null;

        ReservaDto reservaDto = new ReservaDto( id, frechaReserva, numeroDePasajeros, clientes, vuelos, id_reserva );

        return reservaDto;
    }

    @Override
    public Reserva toEntity(ReservaDto reservaDto) {
        if ( reservaDto == null ) {
            return null;
        }

        Reserva reserva = new Reserva();

        List<Cliente> list = reservaDto.clientes();
        if ( list != null ) {
            reserva.setClientes( new ArrayList<Cliente>( list ) );
        }
        List<Vuelo> list1 = reservaDto.vuelos();
        if ( list1 != null ) {
            reserva.setVuelos( new ArrayList<Vuelo>( list1 ) );
        }
        reserva.setId_reserva( reservaDto.id_reserva() );

        return reserva;
    }

    @Override
    public List<ReservaDto> toListDtoSinId(List<Reserva> reservas) {
        if ( reservas == null ) {
            return null;
        }

        List<ReservaDto> list = new ArrayList<ReservaDto>( reservas.size() );
        for ( Reserva reserva : reservas ) {
            list.add( reservaToReservaDto( reserva ) );
        }

        return list;
    }

    @Override
    public List<Reserva> toListEntitySinId(List<ReservaDto> reservaDtos) {
        if ( reservaDtos == null ) {
            return null;
        }

        List<Reserva> list = new ArrayList<Reserva>( reservaDtos.size() );
        for ( ReservaDto reservaDto : reservaDtos ) {
            list.add( toEntity( reservaDto ) );
        }

        return list;
    }

    protected ReservaDto reservaToReservaDto(Reserva reserva) {
        if ( reserva == null ) {
            return null;
        }

        Long id = null;
        List<Cliente> clientes = null;
        List<Vuelo> vuelos = null;
        Pasajero id_reserva = null;

        id = reserva.getId();
        List<Cliente> list = reserva.getClientes();
        if ( list != null ) {
            clientes = new ArrayList<Cliente>( list );
        }
        List<Vuelo> list1 = reserva.getVuelos();
        if ( list1 != null ) {
            vuelos = new ArrayList<Vuelo>( list1 );
        }
        id_reserva = reserva.getId_reserva();

        Date frechaReserva = null;
        Integer numeroDePasajeros = null;

        ReservaDto reservaDto = new ReservaDto( id, frechaReserva, numeroDePasajeros, clientes, vuelos, id_reserva );

        return reservaDto;
    }
}
