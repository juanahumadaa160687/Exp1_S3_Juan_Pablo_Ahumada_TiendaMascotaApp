package com.app.tienda_mascotas.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class OrdenCompra {

    int id;
    int numeroOrden;
    String fechaOrden;
    Pago pago;

}
