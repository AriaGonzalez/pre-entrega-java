package com.techlab.ecommerce.util;



import java.util.InputMismatchException;
import java.util.Scanner;

public class Validador {

    public static void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    public static double validarDouble(Scanner scanner) {
        double numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                numero = scanner.nextDouble();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.print("Entrada no válida. Por favor, ingrese un número decimal: ");
                scanner.nextLine();
            }
        }
        return numero;
    }

    public static void validarPrecio(double precio) {
        
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
    }

    public static void validarStock(int stock) {
    if (stock < 0) {
        throw new IllegalArgumentException("El stock no puede ser negativo");
    }
}



public static int leerEntero(Scanner sc, String mensaje) {
       
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = sc.nextInt();
                sc.nextLine(); 
                return valor;
            } catch (InputMismatchException e) {
                System.out.println(" Debe ingresar un número entero. Intente nuevamente.");
                sc.nextLine(); 
            }
        }
    }

    public static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                double valor = sc.nextDouble();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número (puede usar coma o punto). Intente nuevamente.");
                sc.nextLine(); 
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje) {
       
        System.out.print(mensaje);
        return sc.nextLine(); 
    }
}
