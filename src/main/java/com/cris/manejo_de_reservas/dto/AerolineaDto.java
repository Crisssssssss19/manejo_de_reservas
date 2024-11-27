package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Vuelo;
import lombok.Data;

import java.util.List;

@Data
public class AerolineaDto{
    private Long id;
    private String nombre;
    private Integer codigo_de_aerolinea;
    private String pais_de_origen;
    private List<Vuelo> vuelos;
}
