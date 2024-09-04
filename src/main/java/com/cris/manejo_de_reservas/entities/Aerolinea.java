package com.cris.manejo_de_reservas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "aerolineas")
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    private String nombre;


    @Column(nullable = false)
    private Integer codigo_de_aerolinea;


    @Column(nullable = false)
    private String pais_de_origen;

    /**Una aerolinea tiene muchos vuelos*/
    @OneToMany(mappedBy =  "aerolinea")
    private List<Vuelo> vuelos;



}
