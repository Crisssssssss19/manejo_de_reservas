package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.AeropuertoDto;
import com.cris.manejo_de_reservas.dto.LocacionDto;
import com.cris.manejo_de_reservas.dto.VueloDto;
import com.cris.manejo_de_reservas.entities.Aeropuerto;
import com.cris.manejo_de_reservas.entities.Locacion;
import com.cris.manejo_de_reservas.entities.Vuelo;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AeropuertoMapper {

    AeropuertoMapper INSTANCE = Mappers.getMapper(AeropuertoMapper.class);
    @Mapping(source = "id", target = "id")
    default
    AeropuertoDto toIdDto(Aeropuerto aeropuerto){
        if(aeropuerto == null){
            return null;
        }
        AeropuertoDto aeropuertoDto = new AeropuertoDto();
        aeropuertoDto.setId(aeropuerto.getId());
        aeropuertoDto.setNombre(aeropuerto.getNombre());
        aeropuertoDto.setCiudad(aeropuerto.getCiudad());
        aeropuertoDto.setPais(aeropuerto.getPais());
        return  aeropuertoDto;
    }
    @Mapping(source = "id", target = "id")
    default
    Aeropuerto toIdEntity(AeropuertoDto aeropuertoDto){
        if(aeropuertoDto == null){
            return null;
        }
        Aeropuerto aeropuerto = new Aeropuerto();
        aeropuerto.setId(aeropuertoDto.getId());
        aeropuerto.setNombre(aeropuertoDto.getNombre());
        aeropuerto.setCiudad(aeropuertoDto.getCiudad());
        aeropuerto.setPais(aeropuertoDto.getPais());
        return  aeropuerto;
    }


//    // Mapeo de Aeropuerto a AeropuertoDto
//    @Mapping(source = "id", target = "id")
//
//    AeropuertoDto toIdDto(Aeropuerto aeropuerto);
//
//    // Mapeo de AeropuertoDto a Aeropuerto
//    @Mapping(source = "vuelo", target = "vuelo", qualifiedByName = "mapVueloDtoList")
//    Aeropuerto toIdEntity(AeropuertoDto aeropuertoDto);
//
//    // Métodos de apoyo para las listas de vuelos
//    @Named("mapVueloList")
//    static List<VueloDto> mapVueloList(List<Vuelo> vuelos) {
//        if (vuelos == null || vuelos.isEmpty()) return Collections.emptyList();
//        return vuelos.stream()
//                .map(VueloMapper.INSTANCE::toVueloDto)
//                .collect(Collectors.toList());
//    }
//
//    @Named("mapVueloDtoList")
//    static List<Vuelo> mapVueloDtoList(List<VueloDto> vuelosDto) {
//        if (vuelosDto == null || vuelosDto.isEmpty()) return Collections.emptyList();
//        return vuelosDto.stream()
//                .map(VueloMapper.INSTANCE::toVueloEntity)
//                .collect(Collectors.toList());
//    }

    // Métodos para convertir listas completas
    default List<AeropuertoDto> toDtoList(List<Aeropuerto> aeropuertos) {
        if (aeropuertos == null || aeropuertos.isEmpty()) return Collections.emptyList();
        return aeropuertos.stream().map(this::toIdDto).collect(Collectors.toList());
    }

    default List<Aeropuerto> toEntityList(List<AeropuertoDto> aeropuertoDtos) {
        if (aeropuertoDtos == null || aeropuertoDtos.isEmpty()) return Collections.emptyList();
        return aeropuertoDtos.stream().map(this::toIdEntity).collect(Collectors.toList());
    }
}