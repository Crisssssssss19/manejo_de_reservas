package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.AeropuertoDto;
import com.cris.manejo_de_reservas.entities.Aeropuerto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AeropuertoMapper {

    AeropuertoMapper INSTANCE = Mappers.getMapper(AeropuertoMapper.class);

    /**
     * Mapea una entidad Aeropuerto a un AeropuertoDto, incluyendo el ID.
     *
     * @param aeropuerto la entidad Aeropuerto
     * @return el AeropuertoDto correspondiente
     */
    @Named("conId")
    AeropuertoDto toIdDto(Aeropuerto aeropuerto);

    /**
     * Mapea un AeropuertoDto a una entidad Aeropuerto, incluyendo el ID.
     *
     * @param aeropuertoDto el DTO de Aeropuerto
     * @return la entidad Aeropuerto correspondiente
     */
    @Named("conId")
    Aeropuerto toIdEntity(AeropuertoDto aeropuertoDto);

    /**
     * Mapea una lista de entidades Aeropuerto a una lista de AeropuertoDto, incluyendo los IDs.
     *
     * @param aeropuertos la lista de entidades Aeropuerto
     * @return la lista de AeropuertoDto correspondiente
     */
    List<AeropuertoDto> toListDto(List<Aeropuerto> aeropuertos);

    /**
     * Mapea una lista de AeropuertoDto a una lista de entidades Aeropuerto, incluyendo los IDs.
     *
     * @param aeropuertoDtos la lista de AeropuertoDto
     * @return la lista de entidades Aeropuerto correspondiente
     */
    List<Aeropuerto> toListEntity(List<AeropuertoDto> aeropuertoDtos);

    /**
     * Mapea una entidad Aeropuerto a un AeropuertoDto, ignorando el campo ID.
     *
     * @param aeropuerto la entidad Aeropuerto
     * @return el AeropuertoDto correspondiente sin el ID
     */
    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    AeropuertoDto toDto(Aeropuerto aeropuerto);

    /**
     * Mapea un AeropuertoDto a una entidad Aeropuerto, ignorando el campo ID.
     *
     * @param aeropuertoDto el DTO de Aeropuerto
     * @return la entidad Aeropuerto correspondiente sin el ID
     */
    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    Aeropuerto toEntity(AeropuertoDto aeropuertoDto);

    /**
     * Mapea una lista de entidades Aeropuerto a una lista de AeropuertoDto, ignorando los campos ID.
     *
     * @param aeropuertos la lista de entidades Aeropuerto
     * @return la lista de AeropuertoDto correspondiente sin IDs
     */
    @IterableMapping(qualifiedByName = "sinId")
    List<AeropuertoDto> toListDtoSinId(List<Aeropuerto> aeropuertos);

    /**
     * Mapea una lista de AeropuertoDto a una lista de entidades Aeropuerto, ignorando los campos ID.
     *
     * @param aeropuertoDtos la lista de AeropuertoDto
     * @return la lista de entidades Aeropuerto correspondiente sin IDs
     */
    @IterableMapping(qualifiedByName = "sinId")
    List<Aeropuerto> toListEntitySinId(List<AeropuertoDto> aeropuertoDtos);
}
