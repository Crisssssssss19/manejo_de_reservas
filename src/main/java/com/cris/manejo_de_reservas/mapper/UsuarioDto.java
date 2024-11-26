package com.cris.manejo_de_reservas.mapper;


import com.cris.manejo_de_reservas.entities.Reserva;
import com.cris.manejo_de_reservas.entities.Role;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
public class UsuarioDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private String telefono;
    private Date fechaNacimiento;
    private Set<Role>roles;


}
