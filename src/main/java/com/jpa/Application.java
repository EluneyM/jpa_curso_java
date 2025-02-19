package com.jpa;

import com.jpa.entidades.Autor;
import com.jpa.servicios.AutorServicio;
import com.jpa.servicios.EditorialServicio;
import com.jpa.servicios.LibroServicio;

public class Application {

    public static void main(String[] args) {
        EditorialServicio editorialServicio = new EditorialServicio();
        AutorServicio autorServicio = new AutorServicio();
        LibroServicio libroServicio = new LibroServicio();

        try {
            // editorialServicio.crearEditorial("Planeta", true);
            // editorialServicio.editarEditorial(1, "RBA", false);
            // editorialServicio.eliminarEditorial(1);
            // editorialServicio.listaEditoriales();

            // autorServicio.crearAutor("Nico", true);
            // autorServicio.editarAutor(1, "Martín", false);
            // autorServicio.listaAutores();
            // autorServicio.eliminarAutor(1);

            // Autor autor = autorServicio.buscarAutorPorId(2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
