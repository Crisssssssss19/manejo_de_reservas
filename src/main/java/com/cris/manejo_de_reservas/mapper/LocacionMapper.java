package com.cris.manejo_de_reservas.mapper;


import com.cris.manejo_de_reservas.dto.LocacionDto;
import com.cris.manejo_de_reservas.entities.Locacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocacionMapper {

    LocacionMapper INSTANCE = Mappers.getMapper(LocacionMapper.class);

    @Named("conId")
    LocacionDto toIdDto(Locacion locacion);

    @Named("conId")
    Locacion toIdEntity(LocacionDto locacionDto);

    List<LocacionDto> toLitDto(List<Locacion> locacions);

    List<Locacion> toListEntity(List<LocacionDto> locacionDtos);

    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    LocacionDto toDto(Locacion locacion);

    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    Locacion toIdEntitySinId(LocacionDto locacionDto);

    @Mapping(target = "id", ignore = true)
    List<LocacionDto> toLitDtoSinId(List<Locacion> locacions);

    @Mapping(target = "id", ignore = true)
    List<Locacion> toListEntitySinId(List<LocacionDto> locacionDtos);
}
