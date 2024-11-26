package com.cris.manejo_de_reservas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "aeropuertos")

public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    private String nombre;


    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String pais;

    @OneToMany(mappedBy = "aeropuerto", fetch = FetchType.EAGER)
    private List<Vuelo> vuelo;

  }
