package com.app.tienda_mascotas.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//Getters, Setters y Constructor con todos los argumentos vía Lombok
@Setter
@Getter
@AllArgsConstructor
public class OrdenCompra {

    int id;
    int numeroOrden;
    String fechaOrden;
    Pago pago;

}
