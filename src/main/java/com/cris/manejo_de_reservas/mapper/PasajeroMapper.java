package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.PasajeroDto;
import com.cris.manejo_de_reservas.entities.Pasajero;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PasajeroMapper {

    PasajeroMapper INSTANCE = Mappers.getMapper(PasajeroMapper.class);

    /**
     * Mapea una entidad Pasajero a un PasajeroDto, incluyendo el ID.
     *
     * @param pasajero la entidad Pasajero
     * @return el PasajeroDto correspondiente
     */
    @Named("conId")
    PasajeroDto toIdDto(Pasajero pasajero);

    /**
     * Mapea un PasajeroDto a una entidad Pasajero, incluyendo el ID.
     *
     * @param pasajeroDto el DTO de Pasajero
     * @return la entidad Pasajero correspondiente
     */
    @Named("conId")
    Pasajero toIdEntity(PasajeroDto pasajeroDto);

    /**
     * Mapea una lista de entidades Pasajero a una lista de PasajeroDto, incluyendo los IDs.
     *
     * @param pasajeros la lista de entidades Pasajero
     * @return la lista de PasajeroDto correspondiente
     */
    List<PasajeroDto> toListDto(List<Pasajero> pasajeros);

    /**
     * Mapea una lista de PasajeroDto a una lista de entidades Pasajero, incluyendo los IDs.
     *
     * @param pasajeroDtos la lista de PasajeroDto
     * @return la lista de entidades Pasajero correspondiente
     */
    List<Pasajero> toListEntity(List<PasajeroDto> pasajeroDtos);

    /**
     * Mapea una entidad Pasajero a un PasajeroDto, ignorando el campo ID.
     *
     * @param pasajero la entidad Pasajero
     * @return el PasajeroDto correspondiente sin el ID
     */
    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    PasajeroDto toDto(Pasajero pasajero);

    /**
     * Mapea un PasajeroDto a una entidad Pasajero, ignorando el campo ID.
     *
     * @param pasajeroDto el DTO de Pasajero
     * @return la entidad Pasajero correspondiente sin el ID
     */
    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    Pasajero toEntitySinId(PasajeroDto pasajeroDto);

    /**
     * Mapea una lista de entidades Pasajero a una lista de PasajeroDto, ignorando los campos ID.
     *
     * @param pasajeros la lista de entidades Pasajero
     * @return la lista de PasajeroDto correspondiente sin IDs
     */
    @IterableMapping(qualifiedByName = "sinId")
    List<PasajeroDto> toListDtoSinId(List<Pasajero> pasajeros);

    /**
     * Mapea una lista de PasajeroDto a una lista de entidades Pasajero, ignorando los campos ID.
     *
     * @param pasajeroDtos la lista de PasajeroDto
     * @return la lista de entidades Pasajero correspondiente sin IDs
     */
    @IterableMapping(qualifiedByName = "sinId")
    List<Pasajero> toListEntitySinId(List<PasajeroDto> pasajeroDtos);
}

