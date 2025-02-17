package com.jpa;

import com.jpa.servicios.OficinaServicio;

public class Application {

    public static void main(String[] args) {
        OficinaServicio oficinaServicio = new OficinaServicio();

        try {

            // IMPRIMIR TODAS LAS OFICINAS
            System.out.println("****************OFICINAS DISPONIBLES*****************");
            System.out.println("ID OFICINA // CIUDAD OFICINA // PAIS OFICINA");
            oficinaServicio.listarOficinas();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
