package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.dto.AerolineaDto;
import com.cris.manejo_de_reservas.services.aerolinea.AerolineaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/0.1/aerolineas")
@AllArgsConstructor
public class AerolineaController {

    private final AerolineaService aerolineaService;

    @GetMapping()
    public ResponseEntity<List<AerolineaDto>> getAllAerolinea(){
        return ResponseEntity.ok(aerolineaService.buscarAerolinea());
    }

    @GetMapping("/idAerolinea")
    public ResponseEntity<AerolineaDto> getAerolineaById(@PathVariable ("idAerolinea")Long id){
        return aerolineaService.buscarAerolineaPorId(id)
                .map(aerolinea -> ResponseEntity.ok().body(aerolinea))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/lista")
    public ResponseEntity<List<AerolineaDto>> getListAerolineas(@RequestBody List<Long> ids){
        return  ResponseEntity.ok(aerolineaService.buscarAerolineaPorIds(ids));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<AerolineaDto>> getAerolineaByName(@PathVariable("nombre") String name){
        return ResponseEntity.ok(aerolineaService.buscarAerolineaByNombre(name));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AerolineaDto> actualizarAerolinea(@PathVariable("id") Long id,@RequestBody AerolineaDto aerolinea){
        Optional<AerolineaDto> clienteUpdate = aerolineaService.actualizarAerolinea(id,aerolinea);
        return clienteUpdate.map(aerolineaA -> ResponseEntity.ok(aerolineaA))
                .orElseGet(() ->{
                    return createNewAerolinea(aerolinea);
                });
    }

    @PostMapping
    public ResponseEntity<AerolineaDto> crearAerolinea(@RequestBody AerolineaDto aerolinea){
        return crearAerolinea(aerolinea);
    }

    private ResponseEntity<AerolineaDto> createNewAerolinea(AerolineaDto aerolinea) {
        AerolineaDto newAeroplinea= aerolineaService.guardarAerolinea(aerolinea);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")//Agrega un id
                .buildAndExpand(newAeroplinea.getId())//Construye la url
                .toUri();
        return ResponseEntity.created(location).body(newAeroplinea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAerolinea(@PathVariable Long id){
        aerolineaService.borrarAerolinea(id);
        return ResponseEntity.noContent()
                .build();
    }
}
