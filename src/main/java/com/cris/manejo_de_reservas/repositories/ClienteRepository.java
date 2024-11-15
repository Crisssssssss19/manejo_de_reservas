package com.cris.manejo_de_reservas.repositories;


import com.cris.manejo_de_reservas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository  extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombre(String nombre);
    List<Usuario> findByIdIn(List<Long> ids);

}
