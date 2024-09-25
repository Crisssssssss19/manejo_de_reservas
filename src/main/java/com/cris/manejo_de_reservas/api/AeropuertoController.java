package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.entities.Aeropuerto;
import com.cris.manejo_de_reservas.services.aeropuerto.AeropuertoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
