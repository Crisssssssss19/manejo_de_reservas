package com.cris.manejo_de_reservas.dto;

import java.sql.Date;

public record ClienteDto(String nombre, String apellido, String direccion, String email, String telefono, Date fechaNacimiento) {
}
