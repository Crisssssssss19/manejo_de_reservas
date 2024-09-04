package com.cris.manejo_de_reservas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String nombre;

    @Column(nullable = false)
    public String apellido;

    @Column(nullable = false)
    public String email;

    @Column(nullable = false)
    public String telefono;

    @Column(nullable = false)
    public String direccion;

    @Column(nullable = false)
    public String correo;

    @OneToOne(optional = false)
    @JoinColumn( name = "id_reserva", referencedColumnName = "id")
    public Reserva reserva;
}
