package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.entities.Vuelo;
import com.cris.manejo_de_reservas.services.vuelo.VueloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/idVuelo")
    public ResponseEntity<Vuelo> getVueloById(Long idVuelo){
        return vueloService.buscarVueloPorId(idVuelo)
                .map(vuelo -> ResponseEntity.ok().body(vuelo))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/lista")
    public ResponseEntity<List<Vuelo>> getListVuelos(@RequestBody List<Long>ids){
        return ResponseEntity.ok(vueloService.BuscarVueloByIds(ids));
    }

    @PostMapping
    public ResponseEntity<Vuelo> crearVuelo(@RequestBody Vuelo vuelo){
        return createNewVuelo(vuelo);
    }

    private ResponseEntity<Vuelo> createNewVuelo(Vuelo vuelo) {
        Vuelo newVuelo = vueloService.guardarVuelo(vuelo);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newVuelo.getId())
                .toUri();
        return ResponseEntity.created(location).body(vuelo);
    }
}
