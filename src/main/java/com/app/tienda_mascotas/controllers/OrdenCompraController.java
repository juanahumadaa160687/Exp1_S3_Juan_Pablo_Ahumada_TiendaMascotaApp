package com.app.tienda_mascotas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.app.tienda_mascotas.models.OrdenCompra;
import com.app.tienda_mascotas.models.Pago;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class OrdenCompraController {

    // Simulamos una base de datos con una lista de órdenes de compra
    private List<OrdenCompra> ordenesCompra = new ArrayList<>();

    PagoController pagoController = new PagoController();

    public OrdenCompraController() {

        // Agrega algunas órdenes de compra de ejemplo
        ordenesCompra.add(new OrdenCompra(1, 1001, "2024-06-01", pagoController.getPagoById(1)));
        ordenesCompra.add(new OrdenCompra(2, 1002, "2024-06-02", pagoController.getPagoById(2)));
    }

    // Métodos para manejar las solicitudes HTTP
    @GetMapping("/ordenes-compra")
    public List<OrdenCompra> getOrdenesCompra() {

        return ordenesCompra;
    }

    @GetMapping("/ordenes-compra/{id}")
    public OrdenCompra getOrdenCompraById(@PathVariable int id) {
        for (OrdenCompra ordenCompra : ordenesCompra) {
            if (ordenCompra.getId() == id) {
                return ordenCompra;
            }
        }
        return null;
    }

    @GetMapping("/ordenes-compra/crear")

    public OrdenCompra crearOrdenCompra(@RequestParam int id, @RequestParam int numeroOrden, @RequestParam String fechaOrden, @RequestParam int pagoId) {
        

        Pago pago = pagoController.getPagoById(pagoId);

        OrdenCompra ordenCompra = new OrdenCompra(id, numeroOrden, fechaOrden, pago);

        ordenesCompra.add(ordenCompra);

        return ordenCompra;
    }
}
