package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Reserva;

import java.sql.Date;

public record ClienteDto(Long id, String nombre, String apellido, String direccion, String email, String telefono, Date fechaNacimiento, Reserva reserva) {
}
