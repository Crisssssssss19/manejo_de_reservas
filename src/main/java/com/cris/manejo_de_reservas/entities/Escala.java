package com.cris.manejo_de_reservas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*Escala:
    ID_Escala (Clave Primaria)
    ID_Vuelo (Clave Externa referenciando a Vuelo.ID_Vuelo)
    ID_Aeropuerto (Clave Externa referenciando a Aeropuerto.ID_Aeropuerto)
    Tiempo de escala
*/
@Getter
@Setter
@Entity
@Table(name = "escalas")
public class Escala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @Column(nullable = false)
    private String tipo_de_escala;







}
