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

    /**Muchos usuarios reservan un vuelo*/
    @OneToMany(mappedBy = "reserva",fetch = FetchType.EAGER)
    private List<Usuario> usuario;

    /** muchas reserva tiene muchos vuelos y muchos vuelos muchas reservas*/
    @ManyToMany(mappedBy = "reservas", fetch = FetchType.EAGER)
    private List<Vuelo> vuelos;

    @ManyToOne
    private Pasajero id_reserva;

}
