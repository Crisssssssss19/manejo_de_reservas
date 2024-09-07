package com.cris.manejo_de_reservas.repositories;

import com.cris.manejo_de_reservas.entities.Cliente;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNombre(String nombre);

    List<Cliente> guardarClientes(List<Cliente> clientes);
}
