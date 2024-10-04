package com.cris.manejo_de_reservas.mapper;


import com.cris.manejo_de_reservas.dto.ClienteDto;
import com.cris.manejo_de_reservas.entities.Cliente;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    /**
     * Pasa Cliente a ClienteDto
     */
    @Named("clienteConId")
    ClienteDto toIdDto(Cliente cliente);

    /**
     * Pasa ClienteDto a Cliente
     */
    Cliente toIDEntity(ClienteDto clienteDto);

    /** Pasa una lista de Clinetes a ClientesDto*/
    @Named("listasConId")
    List<ClienteDto> toListDto(List<Cliente> cliente);

    /**Pasa una lista de ClientesDto a Clientes*/
    List<Cliente> toListEntity(List<ClienteDto> clienteDtos);

    /**Pasa clinete a clienteDto sin id*/
    @Named("cleinteSinId")
    @Mapping(target = "id", ignore = true)
    ClienteDto toDto(Cliente cliente);

    /**Pasa clienteDto a cliente sin id*/
    @Mapping(target = "id", ignore = true)
    Cliente toEntity(ClienteDto clienteDto);

    /**Pasa una lista de clientes a una lista de clinetesDto sin id*/
    @Named("listaDeClienteSinId")
    @Mapping(target = "id", ignore = true)
    List<ClienteDto> toListDtoSinId(List<Cliente> cliente);

    /**Pasa una lista de clientesDto a una lista de clinetes sin id*/
    @Mapping(target = "id", ignore = true)
    List<Cliente> toListEntitySinId(List<ClienteDto> clienteDto);

}
