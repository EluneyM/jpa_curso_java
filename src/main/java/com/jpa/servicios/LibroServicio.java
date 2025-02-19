package com.jpa.servicios;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.List;

import com.jpa.entidades.Autor;
import com.jpa.entidades.Editorial;
import com.jpa.entidades.Libro;
import com.jpa.persistencia.LibroDAO;

public class LibroServicio {
    private final LibroDAO libroDao;

    public LibroServicio() {
        this.libroDao = new LibroDAO();
    }

    public void crearLibro(
            Long isbn,
            String titulo,
            int anio,
            int ejemplares,
            boolean alta,
            Autor autor,
            Editorial editorial) throws Exception {

        validarData(isbn, titulo, anio, ejemplares, alta, autor, editorial);

        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setAlta(alta);
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        this.libroDao.crear(libro);
    }

    public void darDeBajaLibro(Long isbn) throws Exception {
        this.libroDao.darDeBaja(isbn);
    }

    private void validarData(
            Long isbn,
            String titulo,
            int anio,
            int ejemplares,
            boolean alta,
            Autor autor,
            Editorial editorial) throws Exception {
        if (isbn == null) {
            throw new InvalidParameterException("ISBN no puede ser nulo.");
        }
        if (titulo == null) {
            throw new InvalidParameterException("Título no puede ser nulo.");
        }
        if (!esAnioValido(anio)) {
            throw new InvalidParameterException("El año debe estar entre 1000 y " + LocalDate.now().getYear());
        }
        if (ejemplares < 1) {
            throw new InvalidParameterException("Debe ingresar al menos 1 ejemplar.");
        }
        if (autor == null) {
            throw new InvalidParameterException("El autor no puede ser nulo.");
        }
        if (editorial == null) {
            throw new InvalidParameterException("La editorial no puede ser nula.");
        }

        if (this.libroDao.buscarPorIsbn(isbn) != null) {
            throw new InvalidParameterException("El libro con ISBN " + isbn + " ya existe en la base de datos.");
        }
    }

    private boolean esAnioValido(int anio) {
        return anio >= 1000 && anio <= LocalDate.now().getYear();
    }

    public void buscarLibroPorIsbn(Long isbn) throws Exception {
        Libro libro = this.libroDao.buscarPorIsbn(isbn);
        imprimirLibro(libro);
    }

    public void buscarLibroPorTitulo(String titulo) throws Exception {
        List<Libro> libros = this.libroDao.buscarPorTitulo(titulo);
        imprimirLista(libros);
    }

    public void buscarLibrosPorNombreDeAutor(String nombreAutor) throws Exception {
        List<Libro> libros = this.libroDao.buscarPorNombreDeAutor(nombreAutor);
        imprimirLista(libros);
    }

    public void buscarLibroPorNombreDeEditorial(String nombreEditorial) throws Exception {
        List<Libro> libros = this.libroDao.buscarPorNombreDeEditorial(nombreEditorial);
        imprimirLista(libros);
    }

    private void imprimirLibro(Libro libro) {
        System.out.println("ISBN | TITULO");
        System.out.println(libro.getIsbn() + " | " + libro.getTitulo());
    }

    private void imprimirLista(List<Libro> libros) {
        System.out.println("ISBN | TITULO");
        for (Libro libro : libros) {
            System.out.println(libro.getIsbn() + " | " + libro.getTitulo());
        }
    }
}
