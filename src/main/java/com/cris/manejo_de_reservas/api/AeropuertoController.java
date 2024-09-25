package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.entities.Aeropuerto;
import com.cris.manejo_de_reservas.entities.Cliente;
import com.cris.manejo_de_reservas.services.aeropuerto.AeropuertoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/0.1/aeropuerto")
public class AeropuertoController {
    private final AeropuertoService aeropuertoService;

    public AeropuertoController(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }


    @GetMapping
    public ResponseEntity<List<Aeropuerto>> getAllAeropuerto(){
        return ResponseEntity.ok(aeropuertoService.buscarAeropuerto());
    }

    @GetMapping("/idAeropuerto")
    public ResponseEntity<Aeropuerto> getAeropuertoById(@PathVariable("idAeropuerto") Long id){
        return aeropuertoService.buscarAeropuertoPorId(id)
                .map(aeropuerto -> ResponseEntity.ok().body(aeropuerto))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/lista")
    public ResponseEntity<List<Aeropuerto>> getListAeropuertos(@RequestBody List<Long>ids ){
        return ResponseEntity.ok(aeropuertoService.buscaraAropuertoPorIds(ids));
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Aeropuerto>> getAeropuertoByName(@PathVariable("nombre") String name){
        return ResponseEntity.ok(aeropuertoService.buscarAeropuertoByNombre(name));
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Aeropuerto> actualizarAeropuerto(@PathVariable("id") Long id,@RequestBody Aeropuerto aeropuerto){
        Optional<Aeropuerto> aeropuertoUpdate = aeropuertoService.actualizarAerolinea(id, aeropuerto);
        return aeropuertoUpdate.map(aeropuerto1 -> ResponseEntity.ok(aeropuerto1))
                .orElseGet(() ->{
                    return createNewAeropuerto(aeropuerto);
                });
    }
    @PostMapping
    public ResponseEntity<Aeropuerto> crearAeropuerto(@RequestBody Aeropuerto aeropuerto){
        return createNewAeropuerto(aeropuerto);
    }

    private ResponseEntity<Aeropuerto> createNewAeropuerto(Aeropuerto aeropuerto) {
        Aeropuerto newAeropuerto = aeropuertoService.guardarAeropuerto(aeropuerto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")//Agrega un id
                .buildAndExpand(newAeropuerto.getId())
                .toUri();
        return ResponseEntity.created(location).body(newAeropuerto);
    }

}
