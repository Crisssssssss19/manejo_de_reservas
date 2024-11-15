package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Usuario;
import com.cris.manejo_de_reservas.entities.Pasajero;
import com.cris.manejo_de_reservas.entities.Vuelo;

import java.util.Date;
import java.util.List;

public record ReservaDto(Long id, Date frechaReserva, Integer numeroDePasajeros, List<Usuario> clientes, List<Vuelo> vuelos,
                         Pasajero id_reserva) {
}
