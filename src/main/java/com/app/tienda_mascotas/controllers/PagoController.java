package com.app.tienda_mascotas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.tienda_mascotas.models.CarroCompra;
import com.app.tienda_mascotas.models.Cliente;
import com.app.tienda_mascotas.models.Pago;
import com.app.tienda_mascotas.models.Producto;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class PagoController{

    // Simulamos una base de datos con una lista de pagos    
    private List<Pago> pagos = new ArrayList<>();

    ClienteController clienteController = new ClienteController();
    CarroCompraController carroCompraController = new CarroCompraController();

    // Agrega algunos pagos de ejemplo
    public PagoController() {
        pagos.add(new Pago(1, "Tarjeta de Crédito", 100.0, "Completado", "2024-06-01", clienteController.getClienteById(1), carroCompraController.getCarroCompraById(1).getProductos()));
        pagos.add(new Pago(2, "Tarjeta de Débito", 50.0, "Pendiente", "2024-06-02", clienteController.getClienteById(2), carroCompraController.getCarroCompraById(2).getProductos()));
    }

    // Métodos para manejar las solicitudes HTTP
    @GetMapping("/pagos")
    public List<Pago> getPagos() {
        return pagos;
    }

    @GetMapping("/pagos/{id}")
    public Pago getPagoById(@PathVariable int id) {
        for (Pago pago : pagos) {
            if (pago.getId() == id) {
                return pago;
            }
        }
        return null;
    }

    @GetMapping("/pagos/crear")

    public Pago crearPago(@RequestParam int id, @RequestParam String metodoPago, @RequestParam String fechaPago, @RequestParam int clienteId, @RequestParam int carroCompraId) {
        
        Cliente cliente = clienteController.getClienteById(clienteId);
        
        CarroCompra carroCompra = carroCompraController.getCarroCompraById(carroCompraId);

        double totalCalculado = 0.0;
        for (Producto producto : carroCompra.getProductos()) {
            totalCalculado += producto.getPrecio();
            int nuevo_stock = producto.getStock() - 1;
            producto.setStock(nuevo_stock);
        }
        
        Pago nuevoPago = new Pago(id, metodoPago, totalCalculado, "Finalizado", fechaPago, cliente, carroCompra.getProductos());
        
        pagos.add(nuevoPago);
        
        return nuevoPago;
    }

}
