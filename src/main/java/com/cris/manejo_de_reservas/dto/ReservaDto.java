package com.cris.manejo_de_reservas.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class ReservaDto{
    private Long id;
    private Date frechaReserva;
    private Integer numeroDePasajeros;
    private List<VueloDto.UsuarioDto> clientes = new ArrayList<>();
    private List<VueloDto> vuelos = new ArrayList<>();
    private PasajeroDto id_reserva;
}
