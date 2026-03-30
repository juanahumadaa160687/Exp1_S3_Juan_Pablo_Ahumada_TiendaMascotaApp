package com.app.tienda_mascotas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//Getters, Setters y Constructor con todos los argumentos vía Lombok
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
