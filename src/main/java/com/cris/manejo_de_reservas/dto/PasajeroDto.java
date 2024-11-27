package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Reserva;
import lombok.Data;


@Data
public class PasajeroDto{
    private Long id;
    private String nombre;
    private String apellido;
    private Integer cc;
    private Integer telefono;
    private ReservaDto reserva;
}
