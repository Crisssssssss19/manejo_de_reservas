package com.cris.manejo_de_reservas.services.cliente;

import com.cris.manejo_de_reservas.dto.ClienteDto;
import com.cris.manejo_de_reservas.entities.Cliente;
import com.cris.manejo_de_reservas.mapper.ClienteMapper;
import com.cris.manejo_de_reservas.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceLmpl implements ClienteService {
    private final ClienteMapper clienteMapper;
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDto guardar(ClienteDto cliente) {
        return clienteMapper.toIdDto(clienteRepository.save(clienteMapper.toEntity(cliente)));
    }

    @Override
    public Optional<ClienteDto> buscarClientePorId(Long id) {
        return Optional.of(clienteMapper.toIdDto(clienteRepository.findById(id).get()));
    }

    @Override
    public List<ClienteDto> BuscarCliente() {
        return clienteMapper.toListDto(clienteRepository.findAll());
   }

    @Override
    public List<ClienteDto> BuscarClientesByIds(List<Long> ids) {
        return clienteMapper.toListDto(clienteRepository.findByIdIn(ids));
    }

    @Override
    public List<ClienteDto> BuscarClientesByNombre(String nombre) {
        return clienteMapper.toListDto(clienteRepository.findByNombre(nombre));
    }

    @Override
    public Optional<ClienteDto> actualizarCliente(Long id,ClienteDto cliente) {
        return Optional.of(clienteMapper.toIdDto(clienteRepository.findById(id).map(oldCliente -> {

            oldCliente.setNombre(cliente.nombre());
            oldCliente.setApellido(cliente.apellido());
            oldCliente.setEmail(cliente.email());
            oldCliente.setDireccion(cliente.direccion());
            oldCliente.setTelefono(cliente.telefono());
            oldCliente.setFechaNacimiento(cliente.fechaNacimiento());
            return clienteRepository.save(oldCliente);
        }).get()));
    }

    @Override
    public void borrarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
