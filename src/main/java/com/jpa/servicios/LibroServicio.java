package com.jpa.servicios;

import java.util.List;

import com.jpa.entidades.Libro;
import com.jpa.persistencia.LibroDAO;

public class LibroServicio {
    private final LibroDAO libroDao;

    public LibroServicio() {
        this.libroDao = new LibroDAO();
    }

    public void buscarLibrosPorNombreDeAutor(String nombreAutor) throws Exception {
        List<Libro> libros = this.libroDao.buscarPorNombreDeAutor(nombreAutor);
        imprimirLista(libros);
    }

    private void imprimirLista(List<Libro> libros) {
        System.out.println("ISBN | TITULO");
        for (Libro libro : libros) {
            System.out.println(libro.getIsbn() + " | " + libro.getTitulo());
        }
    }
}
