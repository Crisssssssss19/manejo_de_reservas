package com.cris.manejo_de_reservas.api;
import com.cris.manejo_de_reservas.dto.ClienteDto;
import com.cris.manejo_de_reservas.exceptions.ClienteNotFounException;
import com.cris.manejo_de_reservas.mapper.UsuarioDto;
import com.cris.manejo_de_reservas.services.cliente.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/api/0.1/clientes")
@CrossOrigin(origins = "http://localhost:5173")//Version de la api
@AllArgsConstructor
public class ClienteController{

    private final ClienteService clienteService;

//    //Traer todos los clientes
//    @GetMapping()//Se entiende que es la ruta clientes
//    public ResponseEntity<HashMap<String, Object>> getAllClientes() {
//        HashMap<String, Object> response = new HashMap<>();
//        List<UsuarioDto> clientes = clienteService.BuscarCliente();
//
//        if (clientes.isEmpty()) {
//            response.put("error", "No se encontraron Clientes");
//            return ResponseEntity.status(404).body(response); // Código HTTP 404
//        }
//
//        response.put("clientes", clientes);
//        response.put("total", clientes.size());
//        return ResponseEntity.ok(response); // Código HTTP 200
//    }

    @GetMapping()
    public ResponseEntity<List<UsuarioDto>>getAllClientes(){
        return ResponseEntity.ok(clienteService.BuscarCliente());
    }




    @GetMapping("/idCliente/{idCliente}")//Traer cliente por Id
    public ResponseEntity<UsuarioDto> getClienteById(@PathVariable("idCliente") Long id){ // Tienen que ser iguales
        return clienteService.buscarClientePorId(id)
                .map(cliente -> ResponseEntity.ok().body(cliente))
                .orElseThrow(ClienteNotFounException::new);
    }

    @GetMapping("/lista")//Obtener lista de clientes
    public ResponseEntity<List<UsuarioDto>> getListCliente(@RequestBody List<Long>ids ){
        return ResponseEntity.ok(clienteService.BuscarClientesByIds(ids));
    }

    @GetMapping("/nombre/{nombre}")//Buscar clinete por nombre
    public ResponseEntity<List<UsuarioDto>> getClienteByName(@PathVariable("nombre") String name){
        return ResponseEntity.ok(clienteService.BuscarClientesByNombre(name));
    }

    @PutMapping("/actualizar/{id}")//actualizar cliente
    public ResponseEntity<UsuarioDto> actualizarCliente(@PathVariable("id") Long id,@RequestBody UsuarioDto cliente){
        Optional<UsuarioDto> clienteUpdate = clienteService.actualizarCliente(id,cliente);
        return clienteUpdate.map(clienteA -> ResponseEntity.ok(clienteA))
                .orElseGet(() ->{
                    return createNewCliente(cliente);
                });
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> crearCliente(@RequestBody UsuarioDto cliente){
        return createNewCliente(cliente);
    }

    private ResponseEntity<UsuarioDto> createNewCliente(UsuarioDto cliente) {
        UsuarioDto newCliente = clienteService.guardar(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")//Agrega un id
                .buildAndExpand(newCliente.getId())//Construye la url
                .toUri();
        return ResponseEntity.created(location).body(newCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClinete(@PathVariable("id") Long id){
        clienteService.borrarCliente(id);
        return ResponseEntity.noContent()
                .build();
    }

}
