package com.cris.manejo_de_reservas.services.vuelo;

import com.cris.manejo_de_reservas.entities.Vuelo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface VueloService {

    Vuelo guardarVuelo(Vuelo vuelo);
    Optional<Vuelo> buscarVueloPorId(Long id);
    List<Vuelo> BuscarVuelo();
    List<Vuelo>BuscarVueloByIds(List<Long> ids);
    Optional<Vuelo> actualizarVuelo(Long id,Vuelo vuelo);

}
