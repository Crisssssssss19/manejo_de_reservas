package com.cris.manejo_de_reservas.api;
import com.cris.manejo_de_reservas.entities.Cliente;
import com.cris.manejo_de_reservas.services.cliente.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/0.1/clientes") //Version de la api
public class ClienteController{

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Traer todos los clientes
    @GetMapping()//Se entiende que es la ruta clientes
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok(clienteService.BuscarCliente()); //200 lo encontro
    }

    @GetMapping("/idCliente/{idCliente}")//Traer cliente por id
    public ResponseEntity<Cliente> getClienteById(@PathVariable("idCliente") Long id){ // Tienen que ser iguales
        return clienteService.buscarClientePorId(id)
                .map(cliente -> ResponseEntity.ok().body(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/lista")//Obtener lista de clientes
    public ResponseEntity<List<Cliente>> getListCliente(@RequestBody List<Long>ids ){
        return ResponseEntity.ok(clienteService.BuscarClientesByIds(ids));
    }

    @GetMapping("/nombre/{nombre}")//Buscar clinete por nombre
    public ResponseEntity<List<Cliente>> getClienteByName(@PathVariable("buscarClientesPorNombre") String name){
        return ResponseEntity.ok(clienteService.BuscarClientesByNombre(name));
    }

    @PutMapping("/actualizar/{id}")//actualizar cliente
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable("id") Long id,@RequestBody Cliente cliente){
        Optional<Cliente> clienteUpdate = clienteService.actualizarCliente(id,cliente);
        return clienteUpdate
                .map(clienteA -> ResponseEntity.ok(clienteA))
                .orElseGet(() ->{
                    return createNewCliente(cliente);
                });
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        return createNewCliente(cliente);
    }

    private ResponseEntity<Cliente> createNewCliente(Cliente cliente) {
        Cliente newCliente = clienteService.guardar(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")//Agrega un id
                .buildAndExpand(newCliente.getId())//Construye la url
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
