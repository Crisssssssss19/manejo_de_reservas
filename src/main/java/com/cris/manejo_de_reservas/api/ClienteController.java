package com.cris.manejo_de_reservas.api;
import com.cris.manejo_de_reservas.dto.ClienteDto;
import com.cris.manejo_de_reservas.exceptions.ClienteNotFounException;
import com.cris.manejo_de_reservas.services.cliente.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/0.1/clientes")//Version de la api
@AllArgsConstructor
public class ClienteController{

    private final ClienteService clienteService;

    //Traer todos los clientes
    @GetMapping()//Se entiende que es la ruta clientes
    public ResponseEntity<List<ClienteDto>> getAllClientes(){
        return ResponseEntity.ok(clienteService.BuscarCliente()); //200 lo encontro
    }

    @GetMapping("/idCliente/{idCliente}")//Traer cliente por Id
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable("idCliente") Long id){ // Tienen que ser iguales
        return clienteService.buscarClientePorId(id)
                .map(cliente -> ResponseEntity.ok().body(cliente))
                .orElseThrow(ClienteNotFounException::new);
    }

    @GetMapping("/lista")//Obtener lista de clientes
    public ResponseEntity<List<ClienteDto>> getListCliente(@RequestBody List<Long>ids ){
        return ResponseEntity.ok(clienteService.BuscarClientesByIds(ids));
    }

    @GetMapping("/nombre/{nombre}")//Buscar clinete por nombre
    public ResponseEntity<List<ClienteDto>> getClienteByName(@PathVariable("nombre") String name){
        return ResponseEntity.ok(clienteService.BuscarClientesByNombre(name));
    }

    @PutMapping("/actualizar/{id}")//actualizar cliente
    public ResponseEntity<ClienteDto> actualizarCliente(@PathVariable("id") Long id,@RequestBody ClienteDto cliente){
        Optional<ClienteDto> clienteUpdate = clienteService.actualizarCliente(id,cliente);
        return clienteUpdate.map(clienteA -> ResponseEntity.ok(clienteA))
                .orElseGet(() ->{
                    return createNewCliente(cliente);
                });
    }

    @PostMapping
    public ResponseEntity<ClienteDto> crearCliente(@RequestBody ClienteDto cliente){
        return createNewCliente(cliente);
    }

    private ResponseEntity<ClienteDto> createNewCliente(ClienteDto cliente) {
        ClienteDto newCliente = clienteService.guardar(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")//Agrega un id
                .buildAndExpand(newCliente.id())//Construye la url
                .toUri();
        return ResponseEntity.created(location).body(newCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClinete(@PathVariable Long id){
        clienteService.borrarCliente(id);
        return ResponseEntity.noContent()
                .build();
    }

}
