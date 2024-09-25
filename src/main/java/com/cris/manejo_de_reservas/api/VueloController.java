package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.entities.Vuelo;
import com.cris.manejo_de_reservas.services.vuelo.VueloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/0.1/vuelos")
public class VueloController {

    private final VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping()
    public ResponseEntity<List<Vuelo>> getAllVuelos(){
        return ResponseEntity.ok(vueloService.BuscarVuelo());
    }
}
