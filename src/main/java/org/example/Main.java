package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.*;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceAppPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin(); // Inicio transaccion

          /*  Factura factura1 = Factura.builder() // Creo Factura
                    .numero(1)
                    .total(3000)
                    .build();

            Domicilio domicilio1 = Domicilio.builder() // Creo un domicilio
                    .nombreCalle("Belgrano")
                    .numeroCalle(305)
                    .build();

            Cliente cliente1 = Cliente.builder()  // Creo un cliente
                    .nombre("Agustin")
                    .apellido("Astudillo")
                    .dni(40689434)
                    .build();

            cliente1.setDomicilio(domicilio1);  // Relaciono cliente con domicilio

            factura1.setCliente(cliente1); // Relaciono factura con un cliente

            Categoria lacteos = Categoria.builder() // Creo una categoria
                    .denominacion("lacteos")
                    .build();

            Categoria dulces = Categoria.builder() // Creo una categoria
                    .denominacion("dulces")
                    .build();

            Articulo galletas = Articulo.builder() // Creo un articulo
                    .denominacion("Melba")
                    .cantidad(2)
                    .precio(400)
                    .build();

            Articulo leche = Articulo.builder() // Creo un articulo
                    .denominacion("Deslactozada")
                    .cantidad(5)
                    .precio(5000)
                    .build();

            galletas.getCategorias().add(dulces);
            dulces.getArticulos().add(galletas);

            leche.getCategorias().add(lacteos);
            lacteos.getArticulos().add(leche);

            DetalleFactura detallefactura1 = DetalleFactura.builder() //Creo un detalle factura
                    .build();
            detallefactura1.setArticulo(galletas);
            detallefactura1.setCantidad(2);
            detallefactura1.setSubtotal(400);

            galletas.getArticulosDetalleFactura().add(detallefactura1);  // Relaciono galletas y detalle factura

            factura1.getDetalleFactura().add(detallefactura1); // Establezco la relacion bidireccional entre detallefactura y factura
            detallefactura1.setFactura(factura1);

            DetalleFactura detalleFactura2 = DetalleFactura.builder().build(); // Hago lo mismo en la misma factura

            detalleFactura2.setArticulo(leche);
            detalleFactura2.setCantidad(5);
            detalleFactura2.setSubtotal(5000);

            leche.getArticulosDetalleFactura().add(detalleFactura2);
            factura1.getDetalleFactura().add(detalleFactura2);
            detalleFactura2.setFactura(factura1);

            factura1.setTotal(5400); */

            Factura factura1 = entityManager.find(Factura.class, 1L);

            /* factura1.setNumero(85); */

            entityManager.remove(factura1);

            entityManager.flush();

            entityManager.getTransaction().commit();

        }catch (Exception e){
            entityManager.getTransaction().rollback();
            System.out.println("Exception: " + e.getMessage());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}