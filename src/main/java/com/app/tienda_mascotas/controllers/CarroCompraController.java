package com.app.tienda_mascotas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.app.tienda_mascotas.models.CarroCompra;
import com.app.tienda_mascotas.models.Cliente;
import com.app.tienda_mascotas.models.Producto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CarroCompraController {

    private List<CarroCompra> carritoCompra = new ArrayList<>();

    public CarroCompraController() {
        ClienteController clienteController = new ClienteController();
        ProductoController productoController = new ProductoController();

        List<Producto> productos1 = new ArrayList<>();
        productos1.add(productoController.getProductoById(1));
        productos1.add(productoController.getProductoById(2));

        List<Producto> productos2 = new ArrayList<>();
        productos2.add(productoController.getProductoById(3));
        productos2.add(productoController.getProductoById(4));

        carritoCompra.add(new CarroCompra(1, clienteController.getClienteById(1), productos1, "2024-06-01", "Activo"));
        carritoCompra.add(new CarroCompra(2, clienteController.getClienteById(2), productos2, "2024-06-02", "Activo"));
    }


    @GetMapping("/carro-compra/agregar-producto")
    public String agregarProductoAlCarro(@RequestParam int clienteId, @RequestParam List<Integer> productoIds, @RequestParam String fechaCreacion) {

        ClienteController clienteController = new ClienteController();
        Cliente cliente = clienteController.getClienteById(clienteId);

        ProductoController productoController = new ProductoController();

        List<Producto> productos = new ArrayList<>();

        for (int productoId : productoIds) {
            
            Producto producto = productoController.getProductoById(productoId);
            productos.add(producto);

            if (producto == null) {
                return "Producto con ID " + productoId + " no encontrado";
            }
        }

        String estado = "Activo";
  
        CarroCompra carroCompra = new CarroCompra(carritoCompra.size() + 1, cliente, productos, fechaCreacion, estado);
        carritoCompra.add(carroCompra);

        return "Producto agregado al carro de compra";
    }

    @GetMapping("/carro-compra/{id}")
    public CarroCompra getCarroCompraById(@PathVariable int id) {
        for (CarroCompra carroCompra : carritoCompra) {
            if (carroCompra.getId() == id) {
                return carroCompra;
            }
        }
        return null;
    }

    @GetMapping("/carro-compra/eliminar/{id}")
    public String eliminarCarroCompra(@PathVariable int id) {
        for (CarroCompra carroCompra : carritoCompra) {
            if (carroCompra.getId() == id) {
                carritoCompra.remove(carroCompra);
                return "Carro de compra eliminado";
            }
        }
        return "Carro de compra no encontrado";
    }
    

}
