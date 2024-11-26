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
    date = "2024-11-26T02:31:09-0500",
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
        String nombre = null;
        Integer codigo_de_aerolinea = null;
        String pais_de_origen = null;
        List<Vuelo> vuelos = null;

        id = aerolinea.getId();
        nombre = aerolinea.getNombre();
        codigo_de_aerolinea = aerolinea.getCodigo_de_aerolinea();
        pais_de_origen = aerolinea.getPais_de_origen();
        List<Vuelo> list = aerolinea.getVuelos();
        if ( list != null ) {
            vuelos = new ArrayList<Vuelo>( list );
        }

        AerolineaDto aerolineaDto = new AerolineaDto( id, nombre, codigo_de_aerolinea, pais_de_origen, vuelos );

        return aerolineaDto;
    }

    @Override
    public Aerolinea toIdEntity(AerolineaDto aerolineaDto) {
        if ( aerolineaDto == null ) {
            return null;
        }

        Aerolinea aerolinea = new Aerolinea();

        aerolinea.setId( aerolineaDto.id() );
        aerolinea.setNombre( aerolineaDto.nombre() );
        aerolinea.setCodigo_de_aerolinea( aerolineaDto.codigo_de_aerolinea() );
        aerolinea.setPais_de_origen( aerolineaDto.pais_de_origen() );
        List<Vuelo> list = aerolineaDto.vuelos();
        if ( list != null ) {
            aerolinea.setVuelos( new ArrayList<Vuelo>( list ) );
        }

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
            list.add( aerolineaDtoToAerolinea( aerolineaDto ) );
        }

        return list;
    }

    @Override
    public AerolineaDto toDto(Aerolinea aerolinea) {
        if ( aerolinea == null ) {
            return null;
        }

        String nombre = null;
        Integer codigo_de_aerolinea = null;
        String pais_de_origen = null;
        List<Vuelo> vuelos = null;

        nombre = aerolinea.getNombre();
        codigo_de_aerolinea = aerolinea.getCodigo_de_aerolinea();
        pais_de_origen = aerolinea.getPais_de_origen();
        List<Vuelo> list = aerolinea.getVuelos();
        if ( list != null ) {
            vuelos = new ArrayList<Vuelo>( list );
        }

        Long id = null;

        AerolineaDto aerolineaDto = new AerolineaDto( id, nombre, codigo_de_aerolinea, pais_de_origen, vuelos );

        return aerolineaDto;
    }

    @Override
    public Aerolinea toEntity(AerolineaDto aerolineaDto) {
        if ( aerolineaDto == null ) {
            return null;
        }

        Aerolinea aerolinea = new Aerolinea();

        aerolinea.setNombre( aerolineaDto.nombre() );
        aerolinea.setCodigo_de_aerolinea( aerolineaDto.codigo_de_aerolinea() );
        aerolinea.setPais_de_origen( aerolineaDto.pais_de_origen() );
        List<Vuelo> list = aerolineaDto.vuelos();
        if ( list != null ) {
            aerolinea.setVuelos( new ArrayList<Vuelo>( list ) );
        }

        return aerolinea;
    }

    @Override
    public List<AerolineaDto> toListDtoSinId(List<Aerolinea> aerolineas) {
        if ( aerolineas == null ) {
            return null;
        }

        List<AerolineaDto> list = new ArrayList<AerolineaDto>( aerolineas.size() );
        for ( Aerolinea aerolinea : aerolineas ) {
            list.add( toDto( aerolinea ) );
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
        String nombre = null;
        Integer codigo_de_aerolinea = null;
        String pais_de_origen = null;
        List<Vuelo> vuelos = null;

        id = aerolinea.getId();
        nombre = aerolinea.getNombre();
        codigo_de_aerolinea = aerolinea.getCodigo_de_aerolinea();
        pais_de_origen = aerolinea.getPais_de_origen();
        List<Vuelo> list = aerolinea.getVuelos();
        if ( list != null ) {
            vuelos = new ArrayList<Vuelo>( list );
        }

        AerolineaDto aerolineaDto = new AerolineaDto( id, nombre, codigo_de_aerolinea, pais_de_origen, vuelos );

        return aerolineaDto;
    }

    protected Aerolinea aerolineaDtoToAerolinea(AerolineaDto aerolineaDto) {
        if ( aerolineaDto == null ) {
            return null;
        }

        Aerolinea aerolinea = new Aerolinea();

        aerolinea.setId( aerolineaDto.id() );
        aerolinea.setNombre( aerolineaDto.nombre() );
        aerolinea.setCodigo_de_aerolinea( aerolineaDto.codigo_de_aerolinea() );
        aerolinea.setPais_de_origen( aerolineaDto.pais_de_origen() );
        List<Vuelo> list = aerolineaDto.vuelos();
        if ( list != null ) {
            aerolinea.setVuelos( new ArrayList<Vuelo>( list ) );
        }

        return aerolinea;
    }
}
