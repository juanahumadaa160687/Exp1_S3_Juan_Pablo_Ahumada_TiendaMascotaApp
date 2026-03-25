package com.app.tienda_mascotas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Producto {

    int id;
    int codigo;
    String nombre;
    String descripcion;
    double precio;
    int stock;

}
