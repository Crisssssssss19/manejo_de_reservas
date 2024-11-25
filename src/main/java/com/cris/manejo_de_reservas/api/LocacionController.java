package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.dto.LocacionDto;
import com.cris.manejo_de_reservas.services.locacion.LocacionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/0.1/locaciones")
@AllArgsConstructor
public class LocacionController {
    private final LocacionService locacionService;

    @GetMapping()
    public ResponseEntity<List<LocacionDto>> getAllLocaciones(){
        return ResponseEntity.ok(locacionService.traerLocaciones());
    }

    @PostMapping
    public ResponseEntity<LocacionDto> crearCliente(@RequestBody LocacionDto locacionDto){
        return createNewLocacion(locacionDto);
    }

    private ResponseEntity<LocacionDto> createNewLocacion(LocacionDto locacionDto) {
        LocacionDto newLocacion = locacionService.guardar(locacionDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")//Agrega un id
                .buildAndExpand(newLocacion.id())//Construye la url
                .toUri();
        return ResponseEntity.created(location).body(newLocacion);
    }
    @GetMapping("/locacion/{nombre}")//Buscar clinete por nombre
    public ResponseEntity<LocacionDto> getClienteByName(@PathVariable("nombre") String name){
        return ResponseEntity.ok(locacionService.buscarLocacionPorNombre(name).get());
    }
    @GetMapping("/buscarId/{id}")//Buscar clinete por nombre
    public ResponseEntity<LocacionDto> getClienteByName(@PathVariable("id") Long id){
        return ResponseEntity.ok(locacionService.buscarLocacionPorId(id).get());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity deleteLocacion(@PathVariable("id") Long id){
        locacionService.borrarLocacion(id);
        return ResponseEntity.noContent().build();
    }


}
