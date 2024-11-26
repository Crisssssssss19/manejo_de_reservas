package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.AerolineaDto;
import com.cris.manejo_de_reservas.dto.LocacionDto;
import com.cris.manejo_de_reservas.entities.Aerolinea;
import com.cris.manejo_de_reservas.entities.Locacion;
import com.cris.manejo_de_reservas.entities.Vuelo;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AerolineaMapper {

    AerolineaMapper INSTANCE = Mappers.getMapper(AerolineaMapper.class);

    @Mapping(source = "vuelos", target = "vuelos")
    @Mapping(source = "id", target = "id")
    default AerolineaDto toIdDto(Aerolinea aerolinea) {
        if (aerolinea == null) return null;

        AerolineaDto dto = new AerolineaDto();
        dto.setId(aerolinea.getId());
        dto.setNombre(aerolinea.getNombre());
        dto.setCodigo_de_aerolinea(aerolinea.getCodigo_de_aerolinea());
        dto.setPais_de_origen(aerolinea.getPais_de_origen());
//        for(Vuelo vuelo: aerolinea.getVuelos()){
//            dto.getVuelos().add(VueloMapper.INSTANCE);
//        }

        return dto;
    }

    @Mapping(source = "id", target = "id")
    default Aerolinea toIdEntity(AerolineaDto aerolineaDto) {
        if (aerolineaDto == null) return null;
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setId(aerolineaDto.getId());
        aerolinea.setNombre(aerolineaDto.getNombre());
        aerolinea.setCodigo_de_aerolinea(aerolineaDto.getCodigo_de_aerolinea());
        aerolinea.setPais_de_origen(aerolineaDto.getPais_de_origen());
        return aerolinea;

    }

    default List<AerolineaDto> toDtoList(List<Aerolinea> aerolineas) {
        if (aerolineas == null || aerolineas.isEmpty()) return List.of();
        return aerolineas.stream().map(this::toIdDto).collect(Collectors.toList());
    }

    default List<Aerolinea> toEntityList(List<AerolineaDto> aerolineaDtos) {
        if (aerolineaDtos == null || aerolineaDtos.isEmpty()) return List.of();
        return aerolineaDtos.stream().map(this::toIdEntity).collect(Collectors.toList());
    }
    
}
