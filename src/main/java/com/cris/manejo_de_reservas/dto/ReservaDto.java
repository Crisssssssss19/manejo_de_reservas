package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Usuario;
import com.cris.manejo_de_reservas.entities.Pasajero;
import com.cris.manejo_de_reservas.entities.Vuelo;
import com.cris.manejo_de_reservas.mapper.UsuarioDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
public class ReservaDto{
    private Long id;
    private Date frechaReserva;
    private Integer numeroDePasajeros;
    private List<UsuarioDto> clientes = new ArrayList<>();
    private List<VueloDto> vuelos = new ArrayList<>();
    private PasajeroDto id_reserva;
}
