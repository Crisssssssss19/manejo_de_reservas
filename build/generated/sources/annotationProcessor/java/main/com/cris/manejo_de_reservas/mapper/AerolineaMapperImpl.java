package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.AerolineaDto;
import com.cris.manejo_de_reservas.entities.Aerolinea;
import com.cris.manejo_de_reservas.entities.Vuelo;
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
public class AerolineaMapperImpl implements AerolineaMapper {

    @Override
    public AerolineaDto toIdDto(Aerolinea aerolinea) {
        if ( aerolinea == null ) {
            return null;
        }

        Long id = null;

        id = aerolinea.id;

        String nombre = null;
        Integer codigo_de_aerolinea = null;
        String pais_de_origen = null;
        List<Vuelo> vuelos = null;

        AerolineaDto aerolineaDto = new AerolineaDto( id, nombre, codigo_de_aerolinea, pais_de_origen, vuelos );

        return aerolineaDto;
    }

    @Override
    public Aerolinea toIDEntity(AerolineaDto aerolineaDto) {
        if ( aerolineaDto == null ) {
            return null;
        }

        Aerolinea aerolinea = new Aerolinea();

        aerolinea.id = aerolineaDto.id();

        return aerolinea;
    }

    @Override
    public List<AerolineaDto> toListDto(List<Aerolinea> aerolineas) {
        if ( aerolineas == null ) {
            return null;
        }

        List<AerolineaDto> list = new ArrayList<AerolineaDto>( aerolineas.size() );
        for ( Aerolinea aerolinea : aerolineas ) {
            list.add( aerolineaToAerolineaDto( aerolinea ) );
        }

        return list;
    }

    @Override
    public List<Aerolinea> toListEntity(List<AerolineaDto> aerolineaDtos) {
        if ( aerolineaDtos == null ) {
            return null;
        }

        List<Aerolinea> list = new ArrayList<Aerolinea>( aerolineaDtos.size() );
        for ( AerolineaDto aerolineaDto : aerolineaDtos ) {
            list.add( toEntity( aerolineaDto ) );
        }

        return list;
    }

    @Override
    public AerolineaDto toDto(Aerolinea aerolinea) {
        if ( aerolinea == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        Integer codigo_de_aerolinea = null;
        String pais_de_origen = null;
        List<Vuelo> vuelos = null;

        AerolineaDto aerolineaDto = new AerolineaDto( id, nombre, codigo_de_aerolinea, pais_de_origen, vuelos );

        return aerolineaDto;
    }

    @Override
    public Aerolinea toEntity(AerolineaDto aerolineaDto) {
        if ( aerolineaDto == null ) {
            return null;
        }

        Aerolinea aerolinea = new Aerolinea();

        return aerolinea;
    }

    @Override
    public List<AerolineaDto> toListDtoSinId(List<Aerolinea> aerolineas) {
        if ( aerolineas == null ) {
            return null;
        }

        List<AerolineaDto> list = new ArrayList<AerolineaDto>( aerolineas.size() );
        for ( Aerolinea aerolinea : aerolineas ) {
            list.add( aerolineaToAerolineaDto( aerolinea ) );
        }

        return list;
    }

    @Override
    public List<Aerolinea> toListEntitySinId(List<AerolineaDto> aerolineaDtos) {
        if ( aerolineaDtos == null ) {
            return null;
        }

        List<Aerolinea> list = new ArrayList<Aerolinea>( aerolineaDtos.size() );
        for ( AerolineaDto aerolineaDto : aerolineaDtos ) {
            list.add( toEntity( aerolineaDto ) );
        }

        return list;
    }

    protected AerolineaDto aerolineaToAerolineaDto(Aerolinea aerolinea) {
        if ( aerolinea == null ) {
            return null;
        }

        Long id = null;

        id = aerolinea.id;

        String nombre = null;
        Integer codigo_de_aerolinea = null;
        String pais_de_origen = null;
        List<Vuelo> vuelos = null;

        AerolineaDto aerolineaDto = new AerolineaDto( id, nombre, codigo_de_aerolinea, pais_de_origen, vuelos );

        return aerolineaDto;
    }
}
