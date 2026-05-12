package com.techlab.ecommerce.exception;


public class ProductoNoEncontrado extends RuntimeException {

    public ProductoNoEncontrado(String mensaje) {
        super(mensaje);
    }
}
