package com.cris.manejo_de_reservas.api;
import com.cris.manejo_de_reservas.entities.Cliente;
import com.cris.manejo_de_reservas.services.cliente.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/0.1") //Version de la api
public class ClienteController{

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Traer todos los clientes
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok(clienteService.BuscarCliente()); //200 lo encontro
    }

    @GetMapping("/clientes/idCliente")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("idCliente") Long id){ // Tienen que ser iguales
        return clienteService.buscarClientePorId(id)
                .map(cliente -> ResponseEntity.ok().body(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/clientes/idsListaDeCliente")
    public ResponseEntity<List<Cliente>> getListCliente(@PathVariable("idsListaDeCliente") List<Long>ids ){
        return ResponseEntity.ok(clienteService.BuscarClientesByIds(ids));
    }

    @GetMapping("/clientes/buscarClientesPorNombre")
    public ResponseEntity<List<Cliente>> getClienteByName(@PathVariable("buscarPorNombre") String name){
        return ResponseEntity.ok(clienteService.BuscarClientesByNombre(name));
    }
    @GetMapping("/clientes/idCliente/ActualizarCliente")
    public ResponseEntity<Cliente> setClienteDatos(@PathVariable("idCliente") Long id,@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.actualizarCliente(id,cliente)
                .map(clienteNewDatos -> ResponseEntity.ok().body(clienteNewDatos))
                .orElse(ResponseEntity.notFound().build())
                .getBody());
    }


}
