package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.dto.PasajeroDto;
import com.cris.manejo_de_reservas.services.pasajero.PasajeroService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/0.1/pasajeros")
@AllArgsConstructor
public class PasajeroController {
    private final PasajeroService pasajeroService;

    @GetMapping()
    public ResponseEntity<List<PasajeroDto>> getAllPasajeros(){
        return ResponseEntity.ok(pasajeroService.BuscarPasajero());
    }

    @GetMapping("/idPasajero")
    public ResponseEntity<PasajeroDto>getPasajeroById(@PathVariable("idPasajero") Long id){
        return pasajeroService.buscarPasajeroPorId(id)
                .map(pasajero -> ResponseEntity.ok().body(pasajero))
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/listaPasajeros")//Obtener lista de cliente
    public ResponseEntity<List<PasajeroDto>> getListPasajero(@RequestBody List<Long>ids ){
        return ResponseEntity.ok(pasajeroService.BuscarPasajeroByIds(ids));
    }

    @GetMapping("/nombre/{nombre}")//Buscar clinete por nombre
    public ResponseEntity<List<PasajeroDto>> getClienteByName(@PathVariable("nombre") String name){
        return ResponseEntity.ok(pasajeroService.BuscarPasajeroByNombre(name));
    }

    @PutMapping("/actualizar/{id}")//actualizar cliente
    public ResponseEntity<PasajeroDto> actualizarCliente(@PathVariable("id") Long id,@RequestBody PasajeroDto pasajero){
        Optional<PasajeroDto> pasajeroUpdate = pasajeroService.actualizarPasajero(id,pasajero);
        return pasajeroUpdate.map(pasajeroA -> ResponseEntity.ok(pasajeroA))
                .orElseGet(() ->{
                    return createNewPasajero(pasajero);
                });
    }

    @PostMapping
    public ResponseEntity<PasajeroDto> crearPasajero(@RequestBody PasajeroDto pasajero){
        return createNewPasajero(pasajero);
    }

    private ResponseEntity<PasajeroDto> createNewPasajero(PasajeroDto pasajero) {
        PasajeroDto newPasajero = pasajeroService.guardarPasajero(pasajero);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")//Agrega un id
                .buildAndExpand(newPasajero.id())//Construye la url
                .toUri();
        return ResponseEntity.created(location).body(newPasajero);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePasajero(@PathVariable Long id){
        pasajeroService.borrarPasajero(id);
        return ResponseEntity.noContent()
                .build();
    }



}
