package com.cris.manejo_de_reservas.services.vuelo;

import com.cris.manejo_de_reservas.dto.VueloDto;
import com.cris.manejo_de_reservas.entities.Vuelo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


public interface VueloService {

    VueloDto guardarVuelo(VueloDto vuelo);
    Optional<VueloDto> buscarVueloPorId(Long id);
    List<VueloDto> BuscarVuelo();
    List<VueloDto>BuscarVueloByIds(List<Long> ids);
    Optional<VueloDto> actualizarVuelo(Long id,VueloDto vuelo);
    void borrarVuelo(Long id);
}
