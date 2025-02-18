package com.jpa;

import com.jpa.servicios.AutorServicio;
import com.jpa.servicios.EditorialServicio;

public class Application {

    public static void main(String[] args) {
        EditorialServicio editorialServicio = new EditorialServicio();
        AutorServicio autorServicio = new AutorServicio();

        try {
            //editorialServicio.crearEditorial("Planeta", true);
            //editorialServicio.editarEditorial(1, "RBA", false);
            //editorialServicio.eliminarEditorial(1);
            //editorialServicio.listaEditoriales();

            //autorServicio.crearAutor("Nico", true);
            //autorServicio.editarAutor(1, "Martín", false);
            autorServicio.listaAutores();
            autorServicio.eliminarAutor(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
