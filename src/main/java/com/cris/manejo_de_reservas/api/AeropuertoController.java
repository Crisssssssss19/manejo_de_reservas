package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.dto.AeropuertoDto;
import com.cris.manejo_de_reservas.services.aeropuerto.AeropuertoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/0.1/aeropuerto")
@AllArgsConstructor
public class AeropuertoController {
    private final AeropuertoService aeropuertoService;


    @GetMapping
    public ResponseEntity<List<AeropuertoDto>> getAllAeropuerto(){
        return ResponseEntity.ok(aeropuertoService.buscarAeropuerto());
    }

    @GetMapping("/idAeropuerto")
    public ResponseEntity<AeropuertoDto> getAeropuertoById(@PathVariable("idAeropuerto") Long id){
        return aeropuertoService.buscarAeropuertoPorId(id)
                .map(aeropuerto -> ResponseEntity.ok().body(aeropuerto))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/lista")
    public ResponseEntity<List<AeropuertoDto>> getListAeropuertos(@RequestBody List<Long>ids ){
        return ResponseEntity.ok(aeropuertoService.buscaraAropuertoPorIds(ids));
    }
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<AeropuertoDto>> getAeropuertoByName(@PathVariable("nombre") String name){
        return ResponseEntity.ok(aeropuertoService.buscarAeropuertoByNombre(name));
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AeropuertoDto> actualizarAeropuerto(@PathVariable("id") Long id,@RequestBody AeropuertoDto aeropuerto){
        Optional<AeropuertoDto> aeropuertoUpdate = aeropuertoService.actualizarAerolinea(id, aeropuerto);
        return aeropuertoUpdate.map(aeropuerto1 -> ResponseEntity.ok(aeropuerto1))
                .orElseGet(() ->{
                    return createNewAeropuerto(aeropuerto);
                });
    }
    @PostMapping
    public ResponseEntity<AeropuertoDto> crearAeropuerto(@RequestBody AeropuertoDto aeropuerto){
        return createNewAeropuerto(aeropuerto);
    }

    private ResponseEntity<AeropuertoDto> createNewAeropuerto(AeropuertoDto aeropuerto) {
        AeropuertoDto newAeropuerto = aeropuertoService.guardarAeropuerto(aeropuerto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")//Agrega un id
                .buildAndExpand(newAeropuerto.getId())
                .toUri();
        return ResponseEntity.created(location).body(newAeropuerto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAeropuerto(@PathVariable Long id){
        aeropuertoService.borrarAerolinea(id);
        return ResponseEntity.noContent()
                .build();
    }

}
