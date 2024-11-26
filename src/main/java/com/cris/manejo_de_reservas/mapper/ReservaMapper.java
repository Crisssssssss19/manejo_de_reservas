package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.ReservaDto;
import com.cris.manejo_de_reservas.entities.Reserva;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    /**
     * Mapea una entidad Reserva a un ReservaDto, incluyendo el ID.
     *
     * @param reserva la entidad Reserva
     * @return el ReservaDto correspondiente
     */
    @Named("conId")
    ReservaDto toIdDto(Reserva reserva);

    /**
     * Mapea un ReservaDto a una entidad Reserva, incluyendo el ID.
     *
     * @param reservaDto el DTO de Reserva
     * @return la entidad Reserva correspondiente
     */
    @Named("conId")
    Reserva toIdEntity(ReservaDto reservaDto);

    /**
     * Mapea una lista de entidades Reserva a una lista de ReservaDto, incluyendo los IDs.
     *
     * @param reservas la lista de entidades Reserva
     * @return la lista de ReservaDto correspondiente
     */
    List<ReservaDto> toListDto(List<Reserva> reservas);

    /**
     * Mapea una lista de ReservaDto a una lista de entidades Reserva, incluyendo los IDs.
     *
     * @param reservaDtos la lista de ReservaDto
     * @return la lista de entidades Reserva correspondiente
     */
    List<Reserva> toListEntity(List<ReservaDto> reservaDtos);

    /**
     * Mapea una entidad Reserva a un ReservaDto, ignorando el campo ID.
     *
     * @param reserva la entidad Reserva
     * @return el ReservaDto correspondiente sin el ID
     */
    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    ReservaDto toDto(Reserva reserva);

    /**
     * Mapea un ReservaDto a una entidad Reserva, ignorando el campo ID.
     *
     * @param reservaDto el DTO de Reserva
     * @return la entidad Reserva correspondiente sin el ID
     */
    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    Reserva toEntitySinId(ReservaDto reservaDto);

    /**
     * Mapea una lista de entidades Reserva a una lista de ReservaDto, ignorando los campos ID.
     *
     * @param reservas la lista de entidades Reserva
     * @return la lista de ReservaDto correspondiente sin IDs
     */
    @IterableMapping(qualifiedByName = "sinId")
    List<ReservaDto> toListDtoSinId(List<Reserva> reservas);

    /**
     * Mapea una lista de ReservaDto a una lista de entidades Reserva, ignorando los campos ID.
     *
     * @param reservaDtos la lista de ReservaDto
     * @return la lista de entidades Reserva correspondiente sin IDs
     */
    @IterableMapping(qualifiedByName = "sinId")
    List<Reserva> toListEntitySinId(List<ReservaDto> reservaDtos);
}
