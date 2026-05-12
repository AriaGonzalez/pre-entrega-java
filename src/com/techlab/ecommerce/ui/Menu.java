package com.techlab.ecommerce.ui;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.service.Pedido;
import com.techlab.ecommerce.util.Validador;

import java.util.Scanner;
import java.util.List;


public class Menu {

    private final Scanner sc;
    private final Pedido pedido;

    public Menu(Scanner sc, Pedido pedido) {
        this.sc = sc;
        this.pedido = pedido;
    }

    public void mostrarMenu() {
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar producto por ID");
        System.out.println("4) Actualizar producto");
        System.out.println("5) Eliminar producto");
        System.out.println("6) Salir");
        System.out.println("==============================================");
    
    }

    public void agregarProducto() {
        System.out.println("--- Nuevo producto ---");
        String nombre = Validador.leerTexto(sc, "Nombre: ");
        double precio = Validador.leerDouble(sc, "Precio: ");
        int stock = Validador.leerEntero(sc, "Stock: ");

        Producto p = new Producto(nombre, precio, stock);
        Producto guardado = pedido.guardar(p);

        System.out.println("✔ Producto agregado con id " + guardado.getId());
    }

    public void listarProductos() {
        
        List<Producto> lista = pedido.getProductos();

        if (lista.isEmpty()) {
            System.out.println("No hay productos cargados.");
            return;
        }

        System.out.println("--- Catálogo ---");
        for (Producto p : lista) {
            
            System.out.println(p);
        }
    }

    public void buscarProducto() {
    
        int id = Validador.leerEntero(sc, "Ingrese el id del producto a buscar: ");
    
        Producto p = pedido.obtenerPorId(id);
        System.out.println("Encontrado: " + p);
    }

    public void actualizarProducto() {
        int id = Validador.leerEntero(sc, "Ingrese el id del producto a actualizar: ");

     
        Producto actual = pedido.obtenerPorId(id);
        System.out.println("Datos actuales: " + actual);

        System.out.println("--- Ingrese los nuevos datos ---");
        String nombre = Validador.leerTexto(sc, "Nombre: ");
        double precio = Validador.leerDouble(sc, "Precio: ");
        int stock = Validador.leerEntero(sc, "Stock: ");

        Producto datos = new Producto(nombre, precio, stock);
        Producto actualizado = pedido.actualizar(id, datos);

        System.out.println("Producto actualizado: " + actualizado);
    }

    public void eliminarProducto() {
        int id = Validador.leerEntero(sc, "Ingrese el id del producto a eliminar: ");
        pedido.eliminar(id);
        System.out.println("Producto eliminado.");
    }

    public void venderProducto() {
        int id = Validador.leerEntero(sc, "Ingrese el id del producto a vender: ");
        int cantidad = Validador.leerEntero(sc, "Ingrese la cantidad a vender: ");
        pedido.vender(id, cantidad);
        System.out.println("Venta realizada.");
    }

}
