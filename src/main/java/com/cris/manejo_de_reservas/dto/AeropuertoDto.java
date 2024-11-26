package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Vuelo;

import java.util.List;

public record AeropuertoDto(Long id, String nombre, String ciudad, String pais, List<Vuelo> vuelo){
}
