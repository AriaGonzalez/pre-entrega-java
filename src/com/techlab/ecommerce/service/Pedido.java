
package com.techlab.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import com.techlab.ecommerce.model.Producto;
import com.techlab.ecommerce.exception.ProductoNoEncontrado;
import com.techlab.ecommerce.util.Validador;
import com.techlab.ecommerce.exception.Stockinsuficiente;

public class Pedido {
   
     private List<Producto> productos = new ArrayList<>();

     private static int contadorId = 1; 
     
     public Producto guardar(Producto p) {
      Validador.validarNombre(p.getNombre());
      Validador.validarPrecio(p.getPrecio());
      Validador.validarStock(p.getStock());



      p.setId(contadorId);
      contadorId++;
      productos.add(p);
      return p;

     }

     public List<Producto> getProductos() {
         return productos;
     }

     public Producto obtenerPorId(int id) {
         for (Producto p : productos) {
             if (p.getId() == id) {
                 return p;
             }
         }
         throw new ProductoNoEncontrado("Producto con ID " + id + " no encontrado");
     }
     
     public Producto actualizar(int id, Producto nuevosDatos) {
         Producto existente = obtenerPorId(id);
         existente.setNombre(nuevosDatos.getNombre());
         existente.setPrecio(nuevosDatos.getPrecio());
         existente.setStock(nuevosDatos.getStock());
         return existente;
     }

     public void eliminar(int id) {
         Producto p = obtenerPorId(id);
         productos.remove(p);
     }
   

     public void vender(int id, int cantidad) {
         Producto p = obtenerPorId(id);
         if (p.getStock() < cantidad) {
             throw new Stockinsuficiente("Stock insuficiente " + p.getNombre());
         }
         p.setStock(p.getStock() - cantidad);
     }
}
