package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.dto.VueloDto;
import com.cris.manejo_de_reservas.services.vuelo.VueloService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/0.1/vuelos")
@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
public class VueloController {

    private final VueloService vueloService;

    @GetMapping()
    public ResponseEntity<List<VueloDto>> getAllVuelos(){
        return ResponseEntity.ok(vueloService.BuscarVuelo());
    }

    @GetMapping("/idVuelo")
    public ResponseEntity<VueloDto> getVueloById(Long idVuelo){
        return vueloService.buscarVueloPorId(idVuelo)
                .map(vuelo -> ResponseEntity.ok().body(vuelo))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/lista")
    public ResponseEntity<List<VueloDto>> getListVuelos(@RequestBody List<Long>ids){
        return ResponseEntity.ok(vueloService.BuscarVueloByIds(ids));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<VueloDto> actualizarVuelo(@PathVariable("id") Long id, @RequestBody VueloDto vuelo){
        Optional<VueloDto> vueloUpdate = vueloService.actualizarVuelo(id, vuelo);
        return vueloUpdate.map(vueloA ->ResponseEntity.ok(vueloA))
                .orElseGet(() ->{
                    return createNewVuelo(vuelo);
                });
    }
    @PostMapping
    public ResponseEntity<VueloDto> crearVuelo(@RequestBody VueloDto vuelo){
        return createNewVuelo(vuelo);
    }

    private ResponseEntity<VueloDto> createNewVuelo(VueloDto vuelo) {
        VueloDto newVuelo = vueloService.guardarVuelo(vuelo);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newVuelo.getId())
                .toUri();
        return ResponseEntity.created(location).body(vuelo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteVuelo(@PathVariable Long id){
        vueloService.borrarVuelo(id);
        return ResponseEntity.noContent()
                .build();
    }
}
