package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Aerolinea;
import com.cris.manejo_de_reservas.entities.Aeropuerto;
import com.cris.manejo_de_reservas.entities.Locacion;
import com.cris.manejo_de_reservas.entities.Reserva;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class VueloDto{

    private Long id;
    private LocacionDto origen;
    private LocacionDto destino;
    private Date fechaDeSalida;
    private Integer duracion;
    private Integer capacidad;
    private AeropuertoDto aeropuerto;
    private AerolineaDto aerolinea;
    private List<ReservaDto> reservas = new ArrayList<>();
}
