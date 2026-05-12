package com.techlab.ecommerce.util;

import com.techlab.ecommerce.service.Pedido;
import com.techlab.ecommerce.model.Producto; 
import com.techlab.ecommerce.ui.Menu;
import com.techlab.ecommerce.exception.ProductoNoEncontrado;
import com.techlab.ecommerce.exception.Stockinsuficiente;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pedido pedido = new Pedido();
        cargarDatosDePrueba(pedido);
        Menu menu = new Menu(scanner, pedido);        
        int opcion;

        try {

            do {
                menu.mostrarMenu();
                opcion = Validador.leerEntero(scanner, "Seleccione una opción: ");

                try {
                    switch (opcion) {
                        case 1 -> menu.agregarProducto();
                        case 2 -> menu.listarProductos();
                        case 3 -> menu.buscarProducto();
                        case 4 -> menu.actualizarProducto();
                        case 5 -> menu.eliminarProducto();
                        case 6 -> System.out.println("Saliendo...");
                        default -> System.out.println("Opción no válida");
                    }
                } catch (IllegalArgumentException | ProductoNoEncontrado | Stockinsuficiente e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } while (opcion != 6);

            
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }


        private static void cargarDatosDePrueba(Pedido pedido) {
        pedido.guardar(new Producto("Café Italiano molido 250g", 4500, 30));
        pedido.guardar(new Producto("Matcha Latte 250gr", 3200, 50));
        pedido.guardar(new Producto("Te 30 sobres", 1850, 100));
        System.out.println("✔ Se cargaron 3 productos de prueba.\n");
    }

}
