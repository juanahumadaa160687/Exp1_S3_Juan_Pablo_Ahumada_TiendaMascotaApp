package com.app.tienda_mascotas.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//Getters, Setters y Constructor con todos los argumentos vía Lombok
@Getter
@Setter
@AllArgsConstructor
public class Pago {

    int id;
    String metodoPago;
    double total;
    String estado;
    String fechaPago;
    Cliente cliente;

    List<Producto> productos;

}
