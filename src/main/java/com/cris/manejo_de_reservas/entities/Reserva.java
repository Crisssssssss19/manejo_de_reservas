package com.cris.manejo_de_reservas.entities;

/*Reserva:
    ID_Reserva (Clave Primaria)
    ID_Cliente (Clave Externa referenciando a Cliente.ID_Cliente)
    ID_Vuelo (Clave Externa referenciando a Vuelo.ID_Vuelo)
    Fecha de reserva
    Número de pasajeros
*/

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id; // Primary key


    @Column(nullable = false)
    private Date fecha_de_reserva;

    @Column(nullable = false)
    private Integer numero_de_pasajeros;

    /**Muchos clientes reservan un vuelo*/
    @OneToMany(mappedBy = "reserva")
    private List<Cliente> clientes;

    /** muchas reserva tiene muchos vuelos y muchos vuelos muchas reservas*/
    @ManyToMany(mappedBy = "reservas")
    private List<Vuelo> vuelos;

    @OneToOne(mappedBy = "reserva_pasajero")
    private Pasajero id_reserva;

}
