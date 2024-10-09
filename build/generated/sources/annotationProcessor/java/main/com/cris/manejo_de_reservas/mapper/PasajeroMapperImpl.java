package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.PasajeroDto;
import com.cris.manejo_de_reservas.entities.Pasajero;
import com.cris.manejo_de_reservas.entities.Reserva;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-08T18:15:15-0500",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class PasajeroMapperImpl implements PasajeroMapper {

    @Override
    public PasajeroDto toIdDto(Pasajero pasajero) {
        if ( pasajero == null ) {
            return null;
        }

        Long id = null;

        id = pasajero.id;

        String nombre = null;
        String apellido = null;
        Integer cc = null;
        Integer telefono = null;
        Reserva reserva = null;

        PasajeroDto pasajeroDto = new PasajeroDto( id, nombre, apellido, cc, telefono, reserva );

        return pasajeroDto;
    }

    @Override
    public Pasajero toIDEntity(PasajeroDto pasajeroDto) {
        if ( pasajeroDto == null ) {
            return null;
        }

        Pasajero pasajero = new Pasajero();

        pasajero.id = pasajeroDto.id();

        return pasajero;
    }

    @Override
    public List<PasajeroDto> toListDto(List<Pasajero> pasajeros) {
        if ( pasajeros == null ) {
            return null;
        }

        List<PasajeroDto> list = new ArrayList<PasajeroDto>( pasajeros.size() );
        for ( Pasajero pasajero : pasajeros ) {
            list.add( pasajeroToPasajeroDto( pasajero ) );
        }

        return list;
    }

    @Override
    public List<Pasajero> toListEntity(List<PasajeroDto> pasajeroDtos) {
        if ( pasajeroDtos == null ) {
            return null;
        }

        List<Pasajero> list = new ArrayList<Pasajero>( pasajeroDtos.size() );
        for ( PasajeroDto pasajeroDto : pasajeroDtos ) {
            list.add( toEntity( pasajeroDto ) );
        }

        return list;
    }

    @Override
    public PasajeroDto toDto(Pasajero pasajero) {
        if ( pasajero == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String apellido = null;
        Integer cc = null;
        Integer telefono = null;
        Reserva reserva = null;

        PasajeroDto pasajeroDto = new PasajeroDto( id, nombre, apellido, cc, telefono, reserva );

        return pasajeroDto;
    }

    @Override
    public Pasajero toEntity(PasajeroDto pasajeroDto) {
        if ( pasajeroDto == null ) {
            return null;
        }

        Pasajero pasajero = new Pasajero();

        return pasajero;
    }

    @Override
    public List<PasajeroDto> toListDtoSinId(List<Pasajero> pasajeros) {
        if ( pasajeros == null ) {
            return null;
        }

        List<PasajeroDto> list = new ArrayList<PasajeroDto>( pasajeros.size() );
        for ( Pasajero pasajero : pasajeros ) {
            list.add( pasajeroToPasajeroDto( pasajero ) );
        }

        return list;
    }

    @Override
    public List<Pasajero> toListEntitySinId(List<PasajeroDto> pasajeroDtos) {
        if ( pasajeroDtos == null ) {
            return null;
        }

        List<Pasajero> list = new ArrayList<Pasajero>( pasajeroDtos.size() );
        for ( PasajeroDto pasajeroDto : pasajeroDtos ) {
            list.add( toEntity( pasajeroDto ) );
        }

        return list;
    }

    protected PasajeroDto pasajeroToPasajeroDto(Pasajero pasajero) {
        if ( pasajero == null ) {
            return null;
        }

        Long id = null;

        id = pasajero.id;

        String nombre = null;
        String apellido = null;
        Integer cc = null;
        Integer telefono = null;
        Reserva reserva = null;

        PasajeroDto pasajeroDto = new PasajeroDto( id, nombre, apellido, cc, telefono, reserva );

        return pasajeroDto;
    }
}
