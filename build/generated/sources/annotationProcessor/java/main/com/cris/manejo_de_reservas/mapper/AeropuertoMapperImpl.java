package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.AeropuertoDto;
import com.cris.manejo_de_reservas.entities.Aeropuerto;
import com.cris.manejo_de_reservas.entities.Vuelo;
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
public class AeropuertoMapperImpl implements AeropuertoMapper {

    @Override
    public AeropuertoDto toIdDto(Aeropuerto aeropuerto) {
        if ( aeropuerto == null ) {
            return null;
        }

        Long id = null;

        id = aeropuerto.id;

        String nombre = null;
        String ciudad = null;
        String pais = null;
        Vuelo vuelo = null;

        AeropuertoDto aeropuertoDto = new AeropuertoDto( id, nombre, ciudad, pais, vuelo );

        return aeropuertoDto;
    }

    @Override
    public Aeropuerto toIDEntity(AeropuertoDto aeropuertoDto) {
        if ( aeropuertoDto == null ) {
            return null;
        }

        Aeropuerto aeropuerto = new Aeropuerto();

        aeropuerto.id = aeropuertoDto.id();

        return aeropuerto;
    }

    @Override
    public List<AeropuertoDto> toListDto(List<Aeropuerto> aeropuertos) {
        if ( aeropuertos == null ) {
            return null;
        }

        List<AeropuertoDto> list = new ArrayList<AeropuertoDto>( aeropuertos.size() );
        for ( Aeropuerto aeropuerto : aeropuertos ) {
            list.add( aeropuertoToAeropuertoDto( aeropuerto ) );
        }

        return list;
    }

    @Override
    public List<Aeropuerto> toListEntity(List<AeropuertoDto> aeropuertoDtos) {
        if ( aeropuertoDtos == null ) {
            return null;
        }

        List<Aeropuerto> list = new ArrayList<Aeropuerto>( aeropuertoDtos.size() );
        for ( AeropuertoDto aeropuertoDto : aeropuertoDtos ) {
            list.add( toEntity( aeropuertoDto ) );
        }

        return list;
    }

    @Override
    public AeropuertoDto toDto(Aeropuerto aeropuerto) {
        if ( aeropuerto == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String ciudad = null;
        String pais = null;
        Vuelo vuelo = null;

        AeropuertoDto aeropuertoDto = new AeropuertoDto( id, nombre, ciudad, pais, vuelo );

        return aeropuertoDto;
    }

    @Override
    public Aeropuerto toEntity(AeropuertoDto aeropuertoDto) {
        if ( aeropuertoDto == null ) {
            return null;
        }

        Aeropuerto aeropuerto = new Aeropuerto();

        return aeropuerto;
    }

    @Override
    public List<AeropuertoDto> toListDtoSinId(List<Aeropuerto> aeropuertos) {
        if ( aeropuertos == null ) {
            return null;
        }

        List<AeropuertoDto> list = new ArrayList<AeropuertoDto>( aeropuertos.size() );
        for ( Aeropuerto aeropuerto : aeropuertos ) {
            list.add( aeropuertoToAeropuertoDto( aeropuerto ) );
        }

        return list;
    }

    @Override
    public List<Aeropuerto> toListEntitySinId(List<AeropuertoDto> aeropuertoDtos) {
        if ( aeropuertoDtos == null ) {
            return null;
        }

        List<Aeropuerto> list = new ArrayList<Aeropuerto>( aeropuertoDtos.size() );
        for ( AeropuertoDto aeropuertoDto : aeropuertoDtos ) {
            list.add( toEntity( aeropuertoDto ) );
        }

        return list;
    }

    protected AeropuertoDto aeropuertoToAeropuertoDto(Aeropuerto aeropuerto) {
        if ( aeropuerto == null ) {
            return null;
        }

        Long id = null;

        id = aeropuerto.id;

        String nombre = null;
        String ciudad = null;
        String pais = null;
        Vuelo vuelo = null;

        AeropuertoDto aeropuertoDto = new AeropuertoDto( id, nombre, ciudad, pais, vuelo );

        return aeropuertoDto;
    }
}
