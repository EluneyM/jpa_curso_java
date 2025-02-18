package com.jpa;

import com.jpa.servicios.EditorialServicio;

public class Application {

    public static void main(String[] args) {
        EditorialServicio editorialServicio = new EditorialServicio();

        try {
            editorialServicio.crearEditorial("Planeta", true);
            //editorialServicio.editarEditorial(1, "RBA", false);
            //editorialServicio.eliminarEditorial(1);

            editorialServicio.listaEditoriales();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
