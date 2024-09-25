package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.entities.Aerolinea;
import com.cris.manejo_de_reservas.entities.Cliente;
import com.cris.manejo_de_reservas.services.aerolinea.AerolineaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/0.1/aerolineas")
public class AerolineaController {

    private final AerolineaService aerolineaService;

    public AerolineaController(AerolineaService aerolineaService) {
        this.aerolineaService = aerolineaService;
    }

    @GetMapping()
    public ResponseEntity<List<Aerolinea>> getAllAerolinea(){
        return ResponseEntity.ok(aerolineaService.buscarAerolinea());
    }

    @GetMapping("/idAerolinea")
    public ResponseEntity<Aerolinea> getAerolineaById(@PathVariable ("idAerolinea")Long id){
        return aerolineaService.buscarAerolineaPorId(id)
                .map(aerolinea -> ResponseEntity.ok().body(aerolinea))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Aerolinea>> getListAerolineas(@RequestBody List<Long> ids){
        return  ResponseEntity.ok(aerolineaService.buscarAerolineaPorIds(ids));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Aerolinea>> getAerolineaByName(@PathVariable("nombre") String name){
        return ResponseEntity.ok(aerolineaService.buscarAerolineaByNombre(name));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Aerolinea> actualizarAerolinea(@PathVariable("id") Long id,@RequestBody Aerolinea aerolinea){
        Optional<Aerolinea> clienteUpdate = aerolineaService.actualizarAerolinea(id,aerolinea);
        return clienteUpdate.map(aerolineaA -> ResponseEntity.ok(aerolineaA))
                .orElseGet(() ->{
                    return createNewAerolinea(aerolinea);
                });
    }

    private ResponseEntity<Aerolinea> createNewAerolinea(Aerolinea aerolinea) {
       Aerolinea newAeroplinea= aerolineaService.guardarAerolinea(aerolinea);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")//Agrega un id
                .buildAndExpand(newAeroplinea.getId())//Construye la url
                .toUri();
        return ResponseEntity.created(location).body(newAeroplinea);
    }
}
