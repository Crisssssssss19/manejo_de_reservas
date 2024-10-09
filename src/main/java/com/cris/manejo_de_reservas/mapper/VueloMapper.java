package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.VueloDto;
import com.cris.manejo_de_reservas.entities.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VueloMapper {
    VueloMapper INSTANCE = Mappers.getMapper(VueloMapper.class);

    /**
     * Mapea una entidad Vuelo a un VueloDto, incluyendo el ID.
     *
     * @param vuelo la entidad Vuelo
     * @return el VueloDto correspondiente
     */
    @Named("conId")
    VueloDto toIdDto(Vuelo vuelo);

    /**
     * Mapea un VueloDto a una entidad Vuelo, incluyendo el ID.
     *
     * @param vueloDto el DTO de Vuelo
     * @return la entidad Vuelo correspondiente
     */
    @Named("conId")
    Vuelo toIDEntity(VueloDto vueloDto);

    /**
     * Mapea una lista de entidades Vuelo a una lista de VueloDto, incluyendo los IDs.
     *
     * @param vuelos la lista de entidades Vuelo
     * @return la lista de VueloDto correspondiente
     */
    @Named("listasConId")
    List<VueloDto> toListDto(List<Vuelo> vuelos);

    /**
     * Mapea una lista de VueloDto a una lista de entidades Vuelo, incluyendo los IDs.
     *
     * @param vueloDtos la lista de VueloDto
     * @return la lista de entidades Vuelo correspondiente
     */
    List<Vuelo> toListEntity(List<VueloDto> vueloDtos);

    /**
     * Mapea una entidad Vuelo a un VueloDto, ignorando el campo ID.
     *
     * @param vuelo la entidad Vuelo
     * @return el VueloDto correspondiente sin el ID
     */
    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    VueloDto toDto(Vuelo vuelo);

    /**
     * Mapea un VueloDto a una entidad Vuelo, ignorando el campo ID.
     *
     * @param vueloDto el DTO de Vuelo
     * @return la entidad Vuelo correspondiente sin el ID
     */
    @Mapping(target = "id", ignore = true)
    Vuelo toEntity(VueloDto vueloDto);

    /**
     * Mapea una lista de entidades Vuelo a una lista de VueloDto, ignorando los campos ID.
     *
     * @param vuelos la lista de entidades Vuelo
     * @return la lista de VueloDto correspondiente sin IDs
     */
    @Named("listaSinId")
    @Mapping(target = "id", ignore = true)
    List<VueloDto> toListDtoSinId(List<Vuelo> vuelos);

    /**
     * Mapea una lista de VueloDto a una lista de entidades Vuelo, ignorando los campos ID.
     *
     * @param vueloDtos la lista de VueloDto
     * @return la lista de entidades Vuelo correspondiente sin IDs
     */
    @Mapping(target = "id", ignore = true)
    List<Vuelo> toListEntitySinId(List<VueloDto> vueloDtos);
}
