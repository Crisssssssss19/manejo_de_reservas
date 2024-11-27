package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.PasajeroDto;
import com.cris.manejo_de_reservas.entities.Pasajero;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PasajeroMapper {

    PasajeroMapper INSTANCE = Mappers.getMapper(PasajeroMapper.class);

    // Mapeo de Pasajero a PasajeroDto
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "cc", target = "cc")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "reserva", target = "reserva")  // Mapeo de Reserva a ReservaDto
    default PasajeroDto toPasajeroDto(Pasajero pasajero) {
        if (pasajero == null) return null;

        PasajeroDto dto = new PasajeroDto();
        dto.setId(pasajero.getId());
        dto.setNombre(pasajero.getNombre());
        dto.setApellido(pasajero.getApellido());
        dto.setCc(pasajero.getCc());
        dto.setTelefono(pasajero.getTelefono());

        // Si existe una reserva, mapeamos la reserva
        if (pasajero.getReserva_pasajero() != null) {
            dto.setReserva(ReservaMapper.INSTANCE.toReservaDto(pasajero.getReserva_pasajero()));  // Usamos el mapper de Reserva
        }

        return dto;
    }

    // Mapeo de PasajeroDto a Pasajero
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "apellido", target = "apellido")
    @Mapping(source = "cc", target = "cc")
    @Mapping(source = "telefono", target = "telefono")
    @Mapping(source = "reserva", target = "reserva")  // Mapeo de ReservaDto a Reserva
    default Pasajero toPasajeroEntity(PasajeroDto pasajeroDto) {
        if (pasajeroDto == null) return null;

        Pasajero pasajero = new Pasajero();
        pasajero.setId(pasajeroDto.getId());
        pasajero.setNombre(pasajeroDto.getNombre());
        pasajero.setApellido(pasajeroDto.getApellido());
        pasajero.setCc(pasajeroDto.getCc());
        pasajero.setTelefono(pasajeroDto.getTelefono());

        // Si existe una reservaDto, mapeamos la reserva
        if (pasajeroDto.getReserva() != null) {
            pasajero.setReserva_pasajero(ReservaMapper.INSTANCE.toReservaEntity(pasajeroDto.getReserva()));  // Usamos el mapper de Reserva
        }

        return pasajero;
    }

    // Mapeo de una lista de Pasajero a lista de PasajeroDto
    default List<PasajeroDto> toDtoList(List<Pasajero> pasajeros) {
        if (pasajeros == null || pasajeros.isEmpty()) return List.of();
        return pasajeros.stream().map(this::toPasajeroDto).collect(Collectors.toList());
    }

    // Mapeo de una lista de PasajeroDto a lista de Pasajero
    default List<Pasajero> toEntityList(List<PasajeroDto> pasajeroDtos) {
        if (pasajeroDtos == null || pasajeroDtos.isEmpty()) return List.of();
        return pasajeroDtos.stream().map(this::toPasajeroEntity).collect(Collectors.toList());
    }
}

