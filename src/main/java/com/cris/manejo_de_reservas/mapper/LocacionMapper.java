package com.cris.manejo_de_reservas.mapper;


import com.cris.manejo_de_reservas.dto.LocacionDto;
import com.cris.manejo_de_reservas.entities.Locacion;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocacionMapper {

    LocacionMapper INSTANCE = Mappers.getMapper(LocacionMapper.class);

    /**
     * Mapea una entidad Locacion a un LocacionDto, incluyendo el ID.
     *
     * @param locacion la entidad Locacion
     * @return el LocacionDto correspondiente
     */
    @Named("conId")
    LocacionDto toIdDto(Locacion locacion);

    /**
     * Mapea un LocacionDto a una entidad Locacion, incluyendo el ID.
     *
     * @param locacionDto el DTO de Locacion
     * @return la entidad Locacion correspondiente
     */
    @Named("conId")
    Locacion toIdEntity(LocacionDto locacionDto);

    /**
     * Mapea una lista de entidades Locacion a una lista de LocacionDto, incluyendo los IDs.
     *
     * @param locaciones la lista de entidades Locacion
     * @return la lista de LocacionDto correspondiente
     */
    List<LocacionDto> toListDto(List<Locacion> locaciones);

    /**
     * Mapea una lista de LocacionDto a una lista de entidades Locacion, incluyendo los IDs.
     *
     * @param locacionDtos la lista de LocacionDto
     * @return la lista de entidades Locacion correspondiente
     */
    List<Locacion> toListEntity(List<LocacionDto> locacionDtos);

    /**
     * Mapea una entidad Locacion a un LocacionDto, ignorando el campo ID.
     *
     * @param locacion la entidad Locacion
     * @return el LocacionDto correspondiente sin el ID
     */
    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    LocacionDto toDto(Locacion locacion);

    /**
     * Mapea un LocacionDto a una entidad Locacion, ignorando el campo ID.
     *
     * @param locacionDto el DTO de Locacion
     * @return la entidad Locacion correspondiente sin el ID
     */
    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    Locacion toEntitySinId(LocacionDto locacionDto);

    /**
     * Mapea una lista de entidades Locacion a una lista de LocacionDto, ignorando los campos ID.
     *
     * @param locaciones la lista de entidades Locacion
     * @return la lista de LocacionDto correspondiente sin IDs
     */
    @IterableMapping(qualifiedByName = "sinId")
    List<LocacionDto> toListDtoSinId(List<Locacion> locaciones);

    /**
     * Mapea una lista de LocacionDto a una lista de entidades Locacion, ignorando los campos ID.
     *
     * @param locacionDtos la lista de LocacionDto
     * @return la lista de entidades Locacion correspondiente sin IDs
     */
    @IterableMapping(qualifiedByName = "sinId")
    List<Locacion> toListEntitySinId(List<LocacionDto> locacionDtos);
}
