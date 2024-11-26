package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.ReservaDto;
import com.cris.manejo_de_reservas.entities.Pasajero;
import com.cris.manejo_de_reservas.entities.Reserva;
import com.cris.manejo_de_reservas.entities.Usuario;
import com.cris.manejo_de_reservas.entities.Vuelo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-26T02:44:02-0500",
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
        List<Vuelo> vuelos = null;
        Pasajero id_reserva = null;

        id = reserva.getId();
        List<Vuelo> list = reserva.getVuelos();
        if ( list != null ) {
            vuelos = new ArrayList<Vuelo>( list );
        }
        id_reserva = reserva.getId_reserva();

        Date frechaReserva = null;
        Integer numeroDePasajeros = null;
        List<Usuario> clientes = null;

        ReservaDto reservaDto = new ReservaDto( id, frechaReserva, numeroDePasajeros, clientes, vuelos, id_reserva );

        return reservaDto;
    }

    @Override
    public Reserva toIdEntity(ReservaDto reservaDto) {
        if ( reservaDto == null ) {
            return null;
        }

        Reserva reserva = new Reserva();

        reserva.setId( reservaDto.id() );
        List<Vuelo> list = reservaDto.vuelos();
        if ( list != null ) {
            reserva.setVuelos( new ArrayList<Vuelo>( list ) );
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
            list.add( reservaDtoToReserva( reservaDto ) );
        }

        return list;
    }

    @Override
    public ReservaDto toDto(Reserva reserva) {
        if ( reserva == null ) {
            return null;
        }

        List<Vuelo> vuelos = null;
        Pasajero id_reserva = null;

        List<Vuelo> list = reserva.getVuelos();
        if ( list != null ) {
            vuelos = new ArrayList<Vuelo>( list );
        }
        id_reserva = reserva.getId_reserva();

        Long id = null;
        Date frechaReserva = null;
        Integer numeroDePasajeros = null;
        List<Usuario> clientes = null;

        ReservaDto reservaDto = new ReservaDto( id, frechaReserva, numeroDePasajeros, clientes, vuelos, id_reserva );

        return reservaDto;
    }

    @Override
    public Reserva toEntitySinId(ReservaDto reservaDto) {
        if ( reservaDto == null ) {
            return null;
        }

        Reserva reserva = new Reserva();

        List<Vuelo> list = reservaDto.vuelos();
        if ( list != null ) {
            reserva.setVuelos( new ArrayList<Vuelo>( list ) );
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
            list.add( toDto( reserva ) );
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
            list.add( toEntitySinId( reservaDto ) );
        }

        return list;
    }

    protected ReservaDto reservaToReservaDto(Reserva reserva) {
        if ( reserva == null ) {
            return null;
        }

        Long id = null;
        List<Vuelo> vuelos = null;
        Pasajero id_reserva = null;

        id = reserva.getId();
        List<Vuelo> list = reserva.getVuelos();
        if ( list != null ) {
            vuelos = new ArrayList<Vuelo>( list );
        }
        id_reserva = reserva.getId_reserva();

        Date frechaReserva = null;
        Integer numeroDePasajeros = null;
        List<Usuario> clientes = null;

        ReservaDto reservaDto = new ReservaDto( id, frechaReserva, numeroDePasajeros, clientes, vuelos, id_reserva );

        return reservaDto;
    }

    protected Reserva reservaDtoToReserva(ReservaDto reservaDto) {
        if ( reservaDto == null ) {
            return null;
        }

        Reserva reserva = new Reserva();

        reserva.setId( reservaDto.id() );
        List<Vuelo> list = reservaDto.vuelos();
        if ( list != null ) {
            reserva.setVuelos( new ArrayList<Vuelo>( list ) );
        }
        reserva.setId_reserva( reservaDto.id_reserva() );

        return reserva;
    }
}
