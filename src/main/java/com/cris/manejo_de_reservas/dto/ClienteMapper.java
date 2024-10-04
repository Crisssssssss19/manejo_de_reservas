package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    @Autowired
    ModelMapper modelMapper;
    public Cliente toClienteEntity(ClienteDto clienteDto){
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        return  cliente;
    }
    public ClienteDto toDto(Cliente cliente){

        ClienteDto clienteDto = modelMapper.map(cliente,ClienteDto.class);
        return clienteDto;
    }
}
