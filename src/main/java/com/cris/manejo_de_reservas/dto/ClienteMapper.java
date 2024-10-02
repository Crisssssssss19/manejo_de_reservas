package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public Cliente toClienteEntity(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setNombre(cliente.getNombre());
        cliente.setApellido(cliente.getApellido());
        cliente.setDireccion(cliente.getDireccion());
        cliente.setEmail(cliente.getEmail());
        cliente.setTelefono(cliente.getTelefono());
        cliente.setFechaNacimiento(cliente.getFechaNacimiento());
        return  cliente;
    }
    public ClienteDto toDto(Cliente cliente){
        ClienteDto clienteDto = new ClienteDto(cliente.getNombre(), cliente.getApellido(),cliente.getDireccion(),cliente.getEmail(),cliente.getTelefono(),cliente.getFechaNacimiento());
        return clienteDto;
    }
}
