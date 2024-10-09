package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Aerolinea;
import com.cris.manejo_de_reservas.entities.Aeropuerto;
import com.cris.manejo_de_reservas.entities.Reserva;

import java.util.Date;
import java.util.List;

public record VueloDto(Long id, String origen, String destino, Date fechaDeSalida, Date horaDeSalida, Integer duracion, Integer capacidad,
                       Aeropuerto aeropuerto, Aerolinea aerolinea, List<Reserva> reservas) {
}
