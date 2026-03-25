package com.app.tienda_mascotas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.app.tienda_mascotas.models.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();

    public ClienteController() {
        clientes.add(new Cliente(1, "Juan", "Pérez", "juan.perez@example.com", "555-1234", "Calle Falsa 123"));
        clientes.add(new Cliente(2, "María", "Gómez", "maria.gomez@example.com", "555-5678", "Avenida Siempre Viva 456"));
        clientes.add(new Cliente(3, "Carlos", "López", "carlos.lopez@example.com", "555-9012", "Boulevard Central 789"));
        clientes.add(new Cliente(4, "Ana", "Martínez", "ana.martinez@example.com", "555-3456", "Calle Luna 321"));
        clientes.add(new Cliente(5, "Luis", "García", "luis.garcia@example.com", "555-7890", "Avenida Sol 654"));
    }

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clientes;
    }

    @GetMapping("/clientes/{id}")
    public Cliente getClienteById(@PathVariable int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    @GetMapping("/clientes/eliminar")
    public String eliminarCliente(@RequestParam int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clientes.remove(cliente);
                return "Cliente eliminado";
            }
        }
        return "Cliente no encontrado";
    }
    
}
