package com.cris.manejo_de_reservas.api;

import com.cris.manejo_de_reservas.dto.ReservaDto;
import com.cris.manejo_de_reservas.services.reserva.ReservaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/0.1/reservas")
@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
public class ReservaController {
    private final ReservaService reservaService;

    //Traer todos los clientes
    @GetMapping()//Se entiende que es la ruta clientes
    public ResponseEntity<List<ReservaDto>> getAllReservas(){
        return ResponseEntity.ok(reservaService.BuscarReserva());
    }

    @GetMapping("/idReserva/{idReserva}")//Traer cliente por id
    public ResponseEntity<ReservaDto> getReservaById(@PathVariable("idReserva") Long id){ // Tienen que ser iguales
        return reservaService.buscarReservaPorId(id)
                .map(cliente -> ResponseEntity.ok().body(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ReservaDto>> getListCliente(@RequestBody List<Long>ids ){
        return ResponseEntity.ok(reservaService.BuscarReservasByIds(ids));
    }



    @PutMapping("/actualizar/{id}")//actualizar cliente
    public ResponseEntity<ReservaDto> actualizarReserva(@PathVariable("id") Long id,@RequestBody ReservaDto reserva){
        Optional<ReservaDto> reservaUpdate = reservaService.actualizarReserva(id,reserva);
        return reservaUpdate.map(reservaA -> ResponseEntity.ok(reservaA))
                .orElseGet(() ->{
                    return createNewReserva(reserva);
                });
    }

    @PostMapping
    public ResponseEntity<ReservaDto> crearReserva(@RequestBody ReservaDto reserva) {
        // Validar y asignar una fecha de reserva si no viene en el DTO
        if (reserva.getFrechaReserva() == null) {
            reserva.setFrechaReserva(new Date()); // Asignar la fecha actual
        }
        return createNewReserva(reserva);
    }

    private ResponseEntity<ReservaDto> createNewReserva(ReservaDto reserva) {
        // Guardar la reserva utilizando el servicio
        ReservaDto newReserva = reservaService.guardarReserva(reserva);

        // Construir la URI para la nueva reserva
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}") // Agregar el ID
                .buildAndExpand(newReserva.getId()) // Construir la URL con el ID
                .toUri();

        // Retornar la respuesta con el estado HTTP 201 y el cuerpo de la nueva reserva
        return ResponseEntity.created(location).body(newReserva);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity deleteReserva(@PathVariable Long id){
        reservaService.borrarReserva(id);
        return ResponseEntity.noContent()
                .build();
    }

}
