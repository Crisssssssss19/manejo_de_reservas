package com.cris.manejo_de_reservas.mapper;


import com.cris.manejo_de_reservas.dto.VueloDto;

import com.cris.manejo_de_reservas.entities.Vuelo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface VueloMapper {

    VueloMapper INSTANCE = Mappers.getMapper(VueloMapper.class);

    // Mapeo de Vuelo a VueloDto
    @Mapping(source = "id", target = "id")
    default VueloDto toVueloDto(Vuelo vuelo) {
        if (vuelo == null)
        {
            return null;
        };

        VueloDto dto = new VueloDto();
        dto.setId(vuelo.getId());
        dto.setFechaDeSalida(vuelo.getFechaDeSalida());
        dto.setDuracion(vuelo.getDuracion());
        dto.setCapacidad(vuelo.getCapacidad());
        //--------------------------------------------------------------------------
        dto.setOrigen(LocacionMapper.INSTANCE.toIdDto(vuelo.getId_origen()));
        dto.setDestino(LocacionMapper.INSTANCE.toIdDto(vuelo.getId_destino()));
        dto.setAeropuerto(AeropuertoMapper.INSTANCE.toIdDto(vuelo.getAeropuerto()));
        dto.setAerolinea(AerolineaMapper.INSTANCE.toIdDto(vuelo.getAerolinea()));
        return dto;
    }

    // Mapeo de VueloDto a Vuelo
    @Mapping(source = "id", target = "id")
    default Vuelo toVueloEntity(VueloDto vueloDto) {
        if (vueloDto == null) {
            return null;
        };

        Vuelo vuelo = new Vuelo();
        vuelo.setId(vueloDto.getId());
        vuelo.setFechaDeSalida(vueloDto.getFechaDeSalida());
        vuelo.setDuracion(vueloDto.getDuracion());
        vuelo.setCapacidad(vueloDto.getCapacidad());
        vuelo.setId_origen(LocacionMapper.INSTANCE.toIdEntity(vueloDto.getOrigen()));
        vuelo.setId_destino(LocacionMapper.INSTANCE.toIdEntity(vueloDto.getDestino()));
        vuelo.setAeropuerto(AeropuertoMapper.INSTANCE.toIdEntity(vueloDto.getAeropuerto()));
        vuelo.setAerolinea(AerolineaMapper.INSTANCE.toIdEntity(vueloDto.getAerolinea()));
        return vuelo;
    }
    default List<VueloDto> toDtoList(List<Vuelo> vuelos) {
        if (vuelos == null || vuelos.isEmpty()) return new ArrayList<>(); // Lista mutable vacía
        List<VueloDto> vueloDtos = new ArrayList<>();
        for (Vuelo vuelo : vuelos) {
            vueloDtos.add(this.toVueloDto(vuelo)); // Convertimos cada elemento y lo agregamos
        }
        return vueloDtos;
    }

    default List<Vuelo> toEntityList(List<VueloDto> vueloDtos) {
        if (vueloDtos == null || vueloDtos.isEmpty()) return new ArrayList<>(); // Lista mutable vacía
        List<Vuelo> vuelos = new ArrayList<>();
        for (VueloDto vueloDto : vueloDtos) {
            vuelos.add(this.toVueloEntity(vueloDto)); // Convertimos cada elemento y lo agregamos
        }
        return vuelos;
    }

}