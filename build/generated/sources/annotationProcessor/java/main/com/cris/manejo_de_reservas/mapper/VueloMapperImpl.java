package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.VueloDto;
import com.cris.manejo_de_reservas.entities.Aerolinea;
import com.cris.manejo_de_reservas.entities.Aeropuerto;
import com.cris.manejo_de_reservas.entities.Locacion;
import com.cris.manejo_de_reservas.entities.Reserva;
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
public class VueloMapperImpl implements VueloMapper {

    @Override
    public VueloDto toIdDto(Vuelo vuelo) {
        if ( vuelo == null ) {
            return null;
        }

        Long id = null;
        Date fechaDeSalida = null;
        Integer duracion = null;
        Integer capacidad = null;
        Aeropuerto aeropuerto = null;
        Aerolinea aerolinea = null;
        List<Reserva> reservas = null;

        id = vuelo.getId();
        fechaDeSalida = vuelo.getFechaDeSalida();
        duracion = vuelo.getDuracion();
        capacidad = vuelo.getCapacidad();
        aeropuerto = vuelo.getAeropuerto();
        aerolinea = vuelo.getAerolinea();
        List<Reserva> list = vuelo.getReservas();
        if ( list != null ) {
            reservas = new ArrayList<Reserva>( list );
        }

        Locacion origen = null;
        Locacion destino = null;

        VueloDto vueloDto = new VueloDto( id, origen, destino, fechaDeSalida, duracion, capacidad, aeropuerto, aerolinea, reservas );

        return vueloDto;
    }

    @Override
    public Vuelo toIdEntity(VueloDto vueloDto) {
        if ( vueloDto == null ) {
            return null;
        }

        Vuelo vuelo = new Vuelo();

        vuelo.setId( vueloDto.id() );
        vuelo.setFechaDeSalida( vueloDto.fechaDeSalida() );
        vuelo.setDuracion( vueloDto.duracion() );
        vuelo.setCapacidad( vueloDto.capacidad() );
        vuelo.setAeropuerto( vueloDto.aeropuerto() );
        vuelo.setAerolinea( vueloDto.aerolinea() );
        List<Reserva> list = vueloDto.reservas();
        if ( list != null ) {
            vuelo.setReservas( new ArrayList<Reserva>( list ) );
        }

        return vuelo;
    }

    @Override
    public List<VueloDto> toListDto(List<Vuelo> vuelos) {
        if ( vuelos == null ) {
            return null;
        }

        List<VueloDto> list = new ArrayList<VueloDto>( vuelos.size() );
        for ( Vuelo vuelo : vuelos ) {
            list.add( toIdDto( vuelo ) );
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
            list.add( vueloDtoToVuelo( vueloDto ) );
        }

        return list;
    }

    @Override
    public VueloDto toDto(Vuelo vuelo) {
        if ( vuelo == null ) {
            return null;
        }

        Date fechaDeSalida = null;
        Integer duracion = null;
        Integer capacidad = null;
        Aeropuerto aeropuerto = null;
        Aerolinea aerolinea = null;
        List<Reserva> reservas = null;

        fechaDeSalida = vuelo.getFechaDeSalida();
        duracion = vuelo.getDuracion();
        capacidad = vuelo.getCapacidad();
        aeropuerto = vuelo.getAeropuerto();
        aerolinea = vuelo.getAerolinea();
        List<Reserva> list = vuelo.getReservas();
        if ( list != null ) {
            reservas = new ArrayList<Reserva>( list );
        }

        Long id = null;
        Locacion origen = null;
        Locacion destino = null;

        VueloDto vueloDto = new VueloDto( id, origen, destino, fechaDeSalida, duracion, capacidad, aeropuerto, aerolinea, reservas );

        return vueloDto;
    }

    @Override
    public Vuelo toEntitySinId(VueloDto vueloDto) {
        if ( vueloDto == null ) {
            return null;
        }

        Vuelo vuelo = new Vuelo();

        vuelo.setFechaDeSalida( vueloDto.fechaDeSalida() );
        vuelo.setDuracion( vueloDto.duracion() );
        vuelo.setCapacidad( vueloDto.capacidad() );
        vuelo.setAeropuerto( vueloDto.aeropuerto() );
        vuelo.setAerolinea( vueloDto.aerolinea() );
        List<Reserva> list = vueloDto.reservas();
        if ( list != null ) {
            vuelo.setReservas( new ArrayList<Reserva>( list ) );
        }

        return vuelo;
    }

    @Override
    public List<VueloDto> toListDtoSinId(List<Vuelo> vuelos) {
        if ( vuelos == null ) {
            return null;
        }

        List<VueloDto> list = new ArrayList<VueloDto>( vuelos.size() );
        for ( Vuelo vuelo : vuelos ) {
            list.add( toDto( vuelo ) );
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
            list.add( toEntitySinId( vueloDto ) );
        }

        return list;
    }

    protected Vuelo vueloDtoToVuelo(VueloDto vueloDto) {
        if ( vueloDto == null ) {
            return null;
        }

        Vuelo vuelo = new Vuelo();

        vuelo.setId( vueloDto.id() );
        vuelo.setFechaDeSalida( vueloDto.fechaDeSalida() );
        vuelo.setDuracion( vueloDto.duracion() );
        vuelo.setCapacidad( vueloDto.capacidad() );
        vuelo.setAeropuerto( vueloDto.aeropuerto() );
        vuelo.setAerolinea( vueloDto.aerolinea() );
        List<Reserva> list = vueloDto.reservas();
        if ( list != null ) {
            vuelo.setReservas( new ArrayList<Reserva>( list ) );
        }

        return vuelo;
    }
}
