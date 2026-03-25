package com.app.tienda_mascotas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.tienda_mascotas.models.Producto;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductoController {

    private List<Producto> productos = new ArrayList<>();

    public ProductoController() {
        productos.add(new Producto(1, 1001, "Pelota de tenis", "Pelota de tenis para perros", 9.99, 50));
        productos.add(new Producto(2, 1002, "Rascador para gatos", "Rascador para gatos con plataforma y cuerda", 29.99, 20));
        productos.add(new Producto(3, 1003, "Comida para perros", "Comida seca para perros adultos", 19.99, 100));
        productos.add(new Producto(4, 1004, "Comida para gatos", "Comida húmeda para gatos", 14.99, 80));
        productos.add(new Producto(5, 1005, "Cama para mascotas", "Cama cómoda para perros y gatos", 49.99, 30));
        productos.add(new Producto(6, 1006, "Juguete para perros", "Juguete interactivo para perros", 24.99, 40));
        productos.add(new Producto(7, 1007, "Juguete para gatos", "Juguete de plumas para gatos", 12.99, 60));
        productos.add(new Producto(8, 1008, "Correa para perros", "Correa ajustable para perros", 19.99, 70));
        productos.add(new Producto(9, 1009, "Collar para gatos", "Collar con campana para gatos", 14.99, 90));
        productos.add(new Producto(10, 1010, "Transportadora para mascotas", "Transportadora de plástico para perros y gatos", 59.99, 15));
    }

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productos;
    }

    @GetMapping("/productos/{id}")
    public Producto getProductoById(@PathVariable int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
       return null;
    }

    @GetMapping("/productos/crear")
    public Producto crearProducto(@RequestParam int id, @RequestParam int codigo, @RequestParam String nombre,
                                  @RequestParam String descripcion, @RequestParam double precio, @RequestParam int stock) {
        Producto nuevoProducto = new Producto(id, codigo, nombre, descripcion, precio, stock);
        productos.add(nuevoProducto);
        return nuevoProducto;
    }

    @GetMapping("/productos/eliminar")
    public String eliminarProducto(@RequestParam int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                productos.remove(producto);
                return "Producto eliminado";
            }
        }
        return "Producto no encontrado";
    }

    @GetMapping("/productos/editar")
    public String editarProducto(@RequestParam int id, @RequestParam int codigo, @RequestParam String nombre,
                                 @RequestParam String descripcion, @RequestParam double precio, @RequestParam int stock) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setCodigo(codigo);
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setPrecio(precio);
                producto.setStock(stock);
                return "Producto actualizado";
            }
        }
        return "Producto no encontrado";
    }
    
}
