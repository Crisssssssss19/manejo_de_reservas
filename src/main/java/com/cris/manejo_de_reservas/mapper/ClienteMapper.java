package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.ClienteDto;
import com.cris.manejo_de_reservas.entities.Usuario;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    /**
     * Mapea una entidad Usuario (Cliente) a un ClienteDto, incluyendo el ID.
     *
     * @param cliente la entidad Usuario (Cliente)
     * @return el ClienteDto correspondiente
     */
    @Named("conId")
    ClienteDto toIdDto(Usuario cliente);

    /**
     * Mapea un ClienteDto a una entidad Usuario (Cliente), incluyendo el ID.
     *
     * @param clienteDto el DTO de Cliente
     * @return la entidad Usuario (Cliente) correspondiente
     */
    @Named("conId")
    Usuario toIdEntity(ClienteDto clienteDto);

    /**
     * Mapea una lista de entidades Usuario (Cliente) a una lista de ClienteDto, incluyendo los IDs.
     *
     * @param clientes la lista de entidades Usuario (Cliente)
     * @return la lista de ClienteDto correspondiente
     */
    List<ClienteDto> toListDto(List<Usuario> clientes);

    /**
     * Mapea una lista de ClienteDto a una lista de entidades Usuario (Cliente), incluyendo los IDs.
     *
     * @param clienteDtos la lista de ClienteDto
     * @return la lista de entidades Usuario (Cliente) correspondiente
     */
    List<Usuario> toListEntity(List<ClienteDto> clienteDtos);

    /**
     * Mapea una entidad Usuario (Cliente) a un ClienteDto, ignorando el campo ID.
     *
     * @param cliente la entidad Usuario (Cliente)
     * @return el ClienteDto correspondiente sin el ID
     */
    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    ClienteDto toDto(Usuario cliente);

    /**
     * Mapea un ClienteDto a una entidad Usuario (Cliente), ignorando el campo ID.
     *
     * @param clienteDto el DTO de Cliente
     * @return la entidad Usuario (Cliente) correspondiente sin el ID
     */
    @Named("sinId")
    @Mapping(target = "id", ignore = true)
    Usuario toEntity(ClienteDto clienteDto);

    /**
     * Mapea una lista de entidades Usuario (Cliente) a una lista de ClienteDto, ignorando los campos ID.
     *
     * @param clientes la lista de entidades Usuario (Cliente)
     * @return la lista de ClienteDto correspondiente sin IDs
     */
    @IterableMapping(qualifiedByName = "sinId")
    List<ClienteDto> toListDtoSinId(List<Usuario> clientes);

    /**
     * Mapea una lista de ClienteDto a una lista de entidades Usuario (Cliente), ignorando los campos ID.
     *
     * @param clienteDtos la lista de ClienteDto
     * @return la lista de entidades Usuario (Cliente) correspondiente sin IDs
     */
    @IterableMapping(qualifiedByName = "sinId")
    List<Usuario> toListEntitySinId(List<ClienteDto> clienteDtos);
}
