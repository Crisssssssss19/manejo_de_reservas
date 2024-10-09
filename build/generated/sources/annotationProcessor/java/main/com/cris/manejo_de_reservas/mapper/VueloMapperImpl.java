package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.VueloDto;
import com.cris.manejo_de_reservas.entities.Aerolinea;
import com.cris.manejo_de_reservas.entities.Aeropuerto;
import com.cris.manejo_de_reservas.entities.Reserva;
import com.cris.manejo_de_reservas.entities.Vuelo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-08T18:15:15-0500",
    comments = "version: 1.6.2, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class VueloMapperImpl implements VueloMapper {

    @Override
    public VueloDto toIdDto(Vuelo vuelo) {
        if ( vuelo == null ) {
            return null;
        }

        Long id = null;

        id = vuelo.id;

        String origen = null;
        String destino = null;
        Date fechaDeSalida = null;
        Date horaDeSalida = null;
        Integer duracion = null;
        Integer capacidad = null;
        Aeropuerto aeropuerto = null;
        Aerolinea aerolinea = null;
        List<Reserva> reservas = null;

        VueloDto vueloDto = new VueloDto( id, origen, destino, fechaDeSalida, horaDeSalida, duracion, capacidad, aeropuerto, aerolinea, reservas );

        return vueloDto;
    }

    @Override
    public Vuelo toIDEntity(VueloDto vueloDto) {
        if ( vueloDto == null ) {
            return null;
        }

        Vuelo vuelo = new Vuelo();

        vuelo.id = vueloDto.id();

        return vuelo;
    }

    @Override
    public List<VueloDto> toListDto(List<Vuelo> vuelos) {
        if ( vuelos == null ) {
            return null;
        }

        List<VueloDto> list = new ArrayList<VueloDto>( vuelos.size() );
        for ( Vuelo vuelo : vuelos ) {
            list.add( vueloToVueloDto( vuelo ) );
        }

        return list;
    }

    @Override
    public List<Vuelo> toListEntity(List<VueloDto> vueloDtos) {
        if ( vueloDtos == null ) {
            return null;
        }

        List<Vuelo> list = new ArrayList<Vuelo>( vueloDtos.size() );
        for ( VueloDto vueloDto : vueloDtos ) {
            list.add( toEntity( vueloDto ) );
        }

        return list;
    }

    @Override
    public VueloDto toDto(Vuelo vuelo) {
        if ( vuelo == null ) {
            return null;
        }

        Long id = null;
        String origen = null;
        String destino = null;
        Date fechaDeSalida = null;
        Date horaDeSalida = null;
        Integer duracion = null;
        Integer capacidad = null;
        Aeropuerto aeropuerto = null;
        Aerolinea aerolinea = null;
        List<Reserva> reservas = null;

        VueloDto vueloDto = new VueloDto( id, origen, destino, fechaDeSalida, horaDeSalida, duracion, capacidad, aeropuerto, aerolinea, reservas );

        return vueloDto;
    }

    @Override
    public Vuelo toEntity(VueloDto vueloDto) {
        if ( vueloDto == null ) {
            return null;
        }

        Vuelo vuelo = new Vuelo();

        return vuelo;
    }

    @Override
    public List<VueloDto> toListDtoSinId(List<Vuelo> vuelos) {
        if ( vuelos == null ) {
            return null;
        }

        List<VueloDto> list = new ArrayList<VueloDto>( vuelos.size() );
        for ( Vuelo vuelo : vuelos ) {
            list.add( vueloToVueloDto( vuelo ) );
        }

        return list;
    }

    @Override
    public List<Vuelo> toListEntitySinId(List<VueloDto> vueloDtos) {
        if ( vueloDtos == null ) {
            return null;
        }

        List<Vuelo> list = new ArrayList<Vuelo>( vueloDtos.size() );
        for ( VueloDto vueloDto : vueloDtos ) {
            list.add( toEntity( vueloDto ) );
        }

        return list;
    }

    protected VueloDto vueloToVueloDto(Vuelo vuelo) {
        if ( vuelo == null ) {
            return null;
        }

        Long id = null;

        id = vuelo.id;

        String origen = null;
        String destino = null;
        Date fechaDeSalida = null;
        Date horaDeSalida = null;
        Integer duracion = null;
        Integer capacidad = null;
        Aeropuerto aeropuerto = null;
        Aerolinea aerolinea = null;
        List<Reserva> reservas = null;

        VueloDto vueloDto = new VueloDto( id, origen, destino, fechaDeSalida, horaDeSalida, duracion, capacidad, aeropuerto, aerolinea, reservas );

        return vueloDto;
    }
}
