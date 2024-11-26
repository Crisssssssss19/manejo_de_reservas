package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Vuelo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AeropuertoDto{
    private Long id;
    private String nombre;
    private String ciudad;
    private String pais;
    private List<VueloDto> vuelo= new ArrayList<>();
}
