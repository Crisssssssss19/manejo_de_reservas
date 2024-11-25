package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.LocacionDto;
import com.cris.manejo_de_reservas.entities.Locacion;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T13:44:03-0500",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class LocacionMapperImpl implements LocacionMapper {

    @Override
    public LocacionDto toIdDto(Locacion locacion) {
        if ( locacion == null ) {
            return null;
        }

        Long id = null;

        id = locacion.id;

        String nombre = null;

        LocacionDto locacionDto = new LocacionDto( id, nombre );

        return locacionDto;
    }

    @Override
    public Locacion toIdEntity(LocacionDto locacionDto) {
        if ( locacionDto == null ) {
            return null;
        }

        Locacion locacion = new Locacion();

        locacion.id = locacionDto.id();

        return locacion;
    }

    @Override
    public List<LocacionDto> toLitDto(List<Locacion> locacions) {
        if ( locacions == null ) {
            return null;
        }

        List<LocacionDto> list = new ArrayList<LocacionDto>( locacions.size() );
        for ( Locacion locacion : locacions ) {
            list.add( locacionToLocacionDto( locacion ) );
        }

        return list;
    }

    @Override
    public List<Locacion> toListEntity(List<LocacionDto> locacionDtos) {
        if ( locacionDtos == null ) {
            return null;
        }

        List<Locacion> list = new ArrayList<Locacion>( locacionDtos.size() );
        for ( LocacionDto locacionDto : locacionDtos ) {
            list.add( locacionDtoToLocacion( locacionDto ) );
        }

        return list;
    }

    @Override
    public LocacionDto toDto(Locacion locacion) {
        if ( locacion == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;

        LocacionDto locacionDto = new LocacionDto( id, nombre );

        return locacionDto;
    }

    @Override
    public Locacion toIdEntitySinId(LocacionDto locacionDto) {
        if ( locacionDto == null ) {
            return null;
        }

        Locacion locacion = new Locacion();

        return locacion;
    }

    @Override
    public List<LocacionDto> toLitDtoSinId(List<Locacion> locacions) {
        if ( locacions == null ) {
            return null;
        }

        List<LocacionDto> list = new ArrayList<LocacionDto>( locacions.size() );
        for ( Locacion locacion : locacions ) {
            list.add( locacionToLocacionDto( locacion ) );
        }

        return list;
    }

    @Override
    public List<Locacion> toListEntitySinId(List<LocacionDto> locacionDtos) {
        if ( locacionDtos == null ) {
            return null;
        }

        List<Locacion> list = new ArrayList<Locacion>( locacionDtos.size() );
        for ( LocacionDto locacionDto : locacionDtos ) {
            list.add( locacionDtoToLocacion( locacionDto ) );
        }

        return list;
    }

    protected LocacionDto locacionToLocacionDto(Locacion locacion) {
        if ( locacion == null ) {
            return null;
        }

        Long id = null;

        id = locacion.id;

        String nombre = null;

        LocacionDto locacionDto = new LocacionDto( id, nombre );

        return locacionDto;
    }

    protected Locacion locacionDtoToLocacion(LocacionDto locacionDto) {
        if ( locacionDto == null ) {
            return null;
        }

        Locacion locacion = new Locacion();

        locacion.id = locacionDto.id();

        return locacion;
    }
}
