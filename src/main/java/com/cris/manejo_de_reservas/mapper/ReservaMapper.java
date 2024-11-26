package com.cris.manejo_de_reservas.mapper;

import com.cris.manejo_de_reservas.dto.ReservaDto;
import com.cris.manejo_de_reservas.entities.Reserva;
import com.cris.manejo_de_reservas.entities.Usuario;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    // Mapeo de Reserva a ReservaDto
    @Mapping(source = "id", target = "id")
    @Mapping(source = "fechaReserva", target = "fechaReserva")
    @Mapping(source = "numeroDePasajeros", target = "numeroDePasajeros")
    @Mapping(source = "clientes", target = "clientes")
    @Mapping(source = "vuelos", target = "vuelos")
    @Mapping(source = "id_reserva", target = "id_reserva")  // Mapeo de Pasajero
    default ReservaDto toReservaDto(Reserva reserva) {
        if (reserva == null) return null;

        ReservaDto dto = new ReservaDto();
        dto.setId(reserva.getId());
        dto.setFrechaReserva(reserva.getFecha_de_reserva());
        dto.setNumeroDePasajeros(reserva.getNumero_de_pasajeros());

        // Mapeo de clientes (List<Usuario>)
        if (reserva.getUsuario() != null) {
            dto.setClientes(reserva.getUsuario().stream()
                    .map(ClienteMapper.INSTANCE::toIdDto)  // Suponiendo que tienes un UsuarioMapper
                    .collect(Collectors.toList()));
        }

        // Mapeo de vuelos (List<Vuelo>)
        if (reserva.getVuelos() != null) {
            dto.setVuelos(reserva.getVuelos().stream()
                    .map(VueloMapper.INSTANCE::toVueloDto)  // Suponiendo que tienes un VueloMapper
                    .collect(Collectors.toList()));
        }

        // Mapeo de id_reserva (Pasajero)
        if (reserva.getId_reserva() != null) {
            dto.setId_reserva(PasajeroMapper.INSTANCE.toPasajeroDto(reserva.getId_reserva()));  // Suponiendo que tienes un PasajeroMapper
        }

        return dto;
    }

    // Mapeo de ReservaDto a Reserva
    @Mapping(source = "id", target = "id")
    @Mapping(source = "fechaReserva", target = "fechaReserva")
    @Mapping(source = "numeroDePasajeros", target = "numeroDePasajeros")
    @Mapping(source = "clientes", target = "clientes")
    @Mapping(source = "vuelos", target = "vuelos")
    @Mapping(source = "id_reserva", target = "id_reserva")  // Mapeo de PasajeroDto
    default Reserva toReservaEntity(ReservaDto reservaDto) {
        if (reservaDto == null) return null;

        Reserva reserva = new Reserva();
        reserva.setId(reservaDto.getId());
        reserva.setFecha_de_reserva(reservaDto.getFrechaReserva());
        reserva.setNumero_de_pasajeros(reservaDto.getNumeroDePasajeros());

        // Mapeo de clientes (List<UsuarioDto> a List<Usuario>)
        if (reservaDto.getClientes() != null) {
            reserva.setUsuario(reservaDto.getClientes().stream()
                    .map(ClienteMapper.INSTANCE::toIdEntity)  // Suponiendo que tienes un UsuarioMapper
                    .collect(Collectors.toList()));
        }

        // Mapeo de vuelos (List<VueloDto> a List<Vuelo>)
        if (reservaDto.getVuelos() != null) {
            reserva.setVuelos(reservaDto.getVuelos().stream()
                    .map(VueloMapper.INSTANCE::toVueloEntity)  // Suponiendo que tienes un VueloMapper
                    .collect(Collectors.toList()));
        }

        // Mapeo de id_reserva (PasajeroDto a Pasajero)
        if (reservaDto.getId_reserva() != null) {
            reserva.setId_reserva(PasajeroMapper.INSTANCE.toPasajeroEntity(reservaDto.getId_reserva()));  // Suponiendo que tienes un PasajeroMapper
        }

        return reserva;
    }

    // Método para convertir una lista de Reserva a una lista de ReservaDto
    default List<ReservaDto> toDtoList(List<Reserva> reservas) {
        if (reservas == null || reservas.isEmpty()) return List.of();
        return reservas.stream().map(this::toReservaDto).collect(Collectors.toList());
    }

    // Método para convertir una lista de ReservaDto a una lista de Reserva
    default List<Reserva> toEntityList(List<ReservaDto> reservaDtos) {
        if (reservaDtos == null || reservaDtos.isEmpty()) return List.of();
        return reservaDtos.stream().map(this::toReservaEntity).collect(Collectors.toList());
    }
}

