package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Reserva;

public record PasajeroDto(Long id, String nombre, String apellido, Integer cc, Integer telefono, Reserva reserva) {
}
