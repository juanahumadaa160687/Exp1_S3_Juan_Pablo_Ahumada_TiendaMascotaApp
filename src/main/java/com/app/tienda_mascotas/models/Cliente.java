package com.app.tienda_mascotas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Cliente {

    int id;
    String nombre;
    String apellido;
    String email;
    String telefono;
    String direccion;

}
