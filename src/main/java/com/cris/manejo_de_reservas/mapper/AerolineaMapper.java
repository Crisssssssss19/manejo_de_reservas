package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.AerolineaDto;
import com.cris.manejo_de_reservas.entities.Aerolinea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AerolineaMapper {

    AerolineaMapper INSTANCE = Mappers.getMapper(AerolineaMapper.class);

    /**
     * Mapea una entidad Aerolinea a un AerolineaDto, incluyendo el ID.
     *
     * @param aerolinea la entidad Aerolinea
     * @return el AerolineaDto correspondiente
     */
    @Named("conId")
    AerolineaDto toIdDto(Aerolinea aerolinea);

    /**
     * Mapea un AerolineaDto a una entidad Aerolinea, incluyendo el ID.
     *
     * @param aerolineaDto el DTO de Aerolinea
     * @return la entidad Aerolinea correspondiente
     */
    @Named("conId")
    Aerolinea toIDEntity(AerolineaDto aerolineaDto);

    /**
     * Mapea una lista de entidades Aerolinea a una lista de AerolineaDto, incluyendo los IDs.
     *
     * @param aerolineas la lista de entidades Aerolinea
     * @return la lista de AerolineaDto correspondiente
     */
    List<AerolineaDto> toListDto(List<Aerolinea> aerolineas);

    /**
     * Mapea una lista de AerolineaDto a una lista de entidades Aerolinea, incluyendo los IDs.
     *
     * @param aerolineaDtos la lista de AerolineaDto
     * @return la lista de entidades Aerolinea correspondiente
     */
    List<Aerolinea> toListEntity(List<AerolineaDto> aerolineaDtos);

    /**
     * Mapea una entidad Aerolinea a un AerolineaDto, ignorando el campo ID.
     *
     * @param aerolinea la entidad Aerolinea
     * @return el AerolineaDto correspondiente sin el ID
     */
    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    AerolineaDto toDto(Aerolinea aerolinea);

    /**
     * Mapea un AerolineaDto a una entidad Aerolinea, ignorando el campo ID.
     *
     * @param aerolineaDto el DTO de Aerolinea
     * @return la entidad Aerolinea correspondiente sin el ID
     */
    @Mapping(target = "id", ignore = true)
    Aerolinea toEntity(AerolineaDto aerolineaDto);

    /**
     * Mapea una lista de entidades Aerolinea a una lista de AerolineaDto, ignorando los campos ID.
     *
     * @param aerolineas la lista de entidades Aerolinea
     * @return la lista de AerolineaDto correspondiente sin IDs
     */
    @Mapping(target = "id", ignore = true)
    List<AerolineaDto> toListDtoSinId(List<Aerolinea> aerolineas);

    /**
     * Mapea una lista de AerolineaDto a una lista de entidades Aerolinea, ignorando los campos ID.
     *
     * @param aerolineaDtos la lista de AerolineaDto
     * @return la lista de entidades Aerolinea correspondiente sin IDs
     */
    @Mapping(target = "id", ignore = true)
    List<Aerolinea> toListEntitySinId(List<AerolineaDto> aerolineaDtos);
}
