package com.techlab.ecommerce.exception;

public class Stockinsuficiente extends RuntimeException {

    public Stockinsuficiente(String mensaje) {
        super(mensaje);
    }
}