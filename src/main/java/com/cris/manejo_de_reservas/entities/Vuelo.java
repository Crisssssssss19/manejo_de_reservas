package com.cris.manejo_de_reservas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/*
    Vuelo:
     ID_Vuelo (Clave Primaria)
     Origen
     Destino
     Fecha de salida
     Hora de salida
     Duración
     Capacidad
*/

@Entity
@Table(name = "vuelos")
@Getter
@Setter
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_Origen", referencedColumnName = "id")
    private Locacion id_origen;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_Destino", referencedColumnName = "id" )
    private Locacion id_destino;

    @Column(name = "fecha_de_salida",nullable = false)
    private Date fechaDeSalida;

    @Column(nullable = false)
    private Integer duracion;

    @Column(nullable = false)
    private Integer capacidad;

    /**un vuelo tiene un aeropuerto*/
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_aeropuerto", referencedColumnName = "id")
    private Aeropuerto aeropuerto;

    /**Una aerolinea tiene muchos vuelos*/
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_aerolinea", referencedColumnName = "id")
    private Aerolinea aerolinea;

    /** muchas reserva tiene muchos vuelos y muchos vuelos muchas reservas*/
    @ManyToMany
    @JoinTable(
            name = "rutas",
            joinColumns = @JoinColumn(name = "id_vuelo", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_reserva", referencedColumnName = "id")
    )
    private List<Reserva> reservas;


}
