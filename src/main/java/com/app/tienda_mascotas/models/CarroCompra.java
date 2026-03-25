package com.app.tienda_mascotas.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class CarroCompra {

    int id;
    Cliente cliente;
    List<Producto> productos;
    String fechaCreacion;
    String estado;
    
}
