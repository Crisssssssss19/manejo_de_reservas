package com.cris.manejo_de_reservas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.swing.plaf.PanelUI;

@Entity
@Getter
@Setter
@Table(name = "pasajeros")
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private Integer cc;

    @Column(nullable = false)
    private Integer telefono;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id")
    private Reserva reserva_pasajero;
}
