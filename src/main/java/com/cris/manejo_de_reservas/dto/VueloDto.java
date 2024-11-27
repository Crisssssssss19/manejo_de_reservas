package com.cris.manejo_de_reservas.dto;

import com.cris.manejo_de_reservas.entities.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class VueloDto{

    private Long id;
    private LocacionDto origen;
    private LocacionDto destino;
    private Date fechaDeSalida;
    private Integer duracion;
    private Integer capacidad;
    private AeropuertoDto aeropuerto;
    private AerolineaDto aerolinea;
    private List<ReservaDto> reservas = new ArrayList<>();

    @Data
    public static class UsuarioDto {

        private Long id;
        private String nombre;
        private String apellido;
        private String direccion;
        private String email;
        private String telefono;
        private java.sql.Date fechaNacimiento;
        private Set<Role> roles;
        private List<ReservaDto> reservaDtos = new ArrayList<>();


    }
}
