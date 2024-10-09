package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Vuelo;

import java.util.List;

public record AerolineaDto(Long id,String nombre, Integer codigo_de_aerolinea, String pais_de_origen, List<Vuelo> vuelos) {
}
