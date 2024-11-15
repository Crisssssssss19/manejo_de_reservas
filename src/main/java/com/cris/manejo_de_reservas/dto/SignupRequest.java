package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Reserva;

import java.sql.Date;
import java.util.Set;

public record SignupRequest(String nombre, String apellido, String direccion, String telefono, Date fechaNacimiento, String username, String password, String email,
                            Reserva idReserva , Set<String> roles) {
}
