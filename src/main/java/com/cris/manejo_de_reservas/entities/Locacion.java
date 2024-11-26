package com.cris.manejo_de_reservas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "locaciones")
public class Locacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // Relación uno a muchos: Esta locación puede ser origen de muchos vuelos
    @OneToMany(mappedBy = "id_origen")
    private List<Vuelo> vuelosOrigen;

    // Relación uno a muchos: Esta locación puede ser destino de muchos vuelos
    @OneToMany(mappedBy = "id_destino")
    private List<Vuelo> vuelosDestino;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String siglas;

}
