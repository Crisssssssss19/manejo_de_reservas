package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Reserva;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public record ClienteDto(Long id, String nombre, String apellido, String direccion, String email, String telefono, Date fechaNacimiento, List<Reserva> reserva, Set<String> roles) {
}
