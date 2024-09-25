package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.entities.Aeropuerto;
import com.cris.manejo_de_reservas.entities.Cliente;
import com.cris.manejo_de_reservas.services.aeropuerto.AeropuertoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
