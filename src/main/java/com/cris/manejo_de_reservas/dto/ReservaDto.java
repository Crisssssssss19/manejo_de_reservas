package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.Cliente;
import com.cris.manejo_de_reservas.entities.Pasajero;
import com.cris.manejo_de_reservas.entities.Vuelo;

import java.util.Date;
import java.util.List;

public record ReservaDto(Long id, Date frechaReserva, Integer numeroDePasajeros, List<Cliente> clientes, List<Vuelo> vuelos,
                         Pasajero id_reserva) {
}
