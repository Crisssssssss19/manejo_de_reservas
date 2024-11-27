package com.cris.manejo_de_reservas.mapper;


import com.cris.manejo_de_reservas.dto.LocacionDto;
import com.cris.manejo_de_reservas.entities.Locacion;
import com.cris.manejo_de_reservas.entities.Usuario;
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
public interface LocacionMapper {

    LocacionMapper INSTANCE = Mappers.getMapper(LocacionMapper.class);

    @Mapping(source = "id", target = "id")
    default LocacionDto toIdDto(Locacion locacion) {
        if (locacion == null) return null;

        LocacionDto dto = new LocacionDto();
        dto.setId(locacion.getId());
        dto.setNombre(locacion.getNombre());
        dto.setPais(locacion.getPais());
        dto.setSiglas(locacion.getSiglas());
        return dto;
    }

    @Mapping(source = "id", target = "id")
    default Locacion toIdEntity(LocacionDto locacionDto) {
        if (locacionDto == null) return null;
        Locacion locacion = new Locacion();
        locacion.setId(locacionDto.getId());
        locacion.setNombre(locacionDto.getNombre());
        locacion.setPais(locacionDto.getPais());
        locacion.setSiglas(locacionDto.getSiglas());
        return locacion;

    }

    default List<LocacionDto> toDtoList(List<Locacion> locacions) {
        if (locacions == null || locacions.isEmpty()) return List.of();
        return locacions.stream().map(this::toIdDto).collect(Collectors.toList());
    }

    default List<Locacion> toEntityList(List<LocacionDto> locacionDtos) {
        if (locacionDtos == null || locacionDtos.isEmpty()) return List.of();
        return locacionDtos.stream().map(this::toIdEntity).collect(Collectors.toList());
    }

}
