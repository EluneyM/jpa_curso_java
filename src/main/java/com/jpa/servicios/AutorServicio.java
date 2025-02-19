package com.jpa.servicios;

import java.security.InvalidParameterException;

import com.jpa.entidades.Autor;
import com.jpa.persistencia.AutorDAO;

import jakarta.persistence.NoResultException;

public class AutorServicio {
    private final AutorDAO autorDao;

    public AutorServicio() {
        this.autorDao = new AutorDAO();
    }

    public Autor crearAutor(String nombre, boolean alta) throws Exception {

        this.validarData(nombre);

        Autor e = new Autor();
        e.setNombre(nombre);
        e.setAlta(alta);

        this.autorDao.crear(e);
        return e;
    }

    public Autor editarAutor(int id, String nombre, boolean alta) throws Exception {
        this.validarData(nombre);

        editorialExiste(id);

        Autor e = new Autor();
        e.setId(id);
        e.setNombre(nombre);
        e.setAlta(alta);

        this.autorDao.actualizar(e);

        return e;
    }

    public Autor buscarAutorPorId(int id) throws Exception {
        return this.autorDao.buscarPorId(id);
    }

    public Autor buscarAutorPorNombre(String nombre) throws Exception {
        Autor a = this.autorDao.buscarPorNombre(nombre);
        System.out.println("ID | Nombre | Alta");
        System.out.println(a.getId() + " | " + a.getNombre() + " | " + a.isAlta());
        return a;
    }

    public void listaAutores() throws Exception {
        System.out.println("ID | Nombre | Alta");
        for (Autor e : this.autorDao.listar()) {
            System.out.println(e.getId() + " | " + e.getNombre() + " | " + e.isAlta());
        }
    }

    public void eliminarAutor(int id) throws Exception {
        this.autorDao.eliminar(id);
    }

    public void darDeBajaAutor(String nombre) throws Exception {
        this.autorDao.darDeBaja(nombre);
    }

    private void editorialExiste(int id) throws Exception {
        try {
            this.autorDao.buscarPorId(id);
        } catch (NoResultException e) {
            System.out.println("No existe el registro con el ID " + id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void validarData(String nombre) throws Exception {
        if (nombre == null) {
            throw new InvalidParameterException("El nombre no puede ser nulo.");
        }
        if (nombre.length() < 2) {
            throw new InvalidParameterException("El nombre debe contener al menos 2 caracteres.");
        }

        if (this.autorDao.buscarPorNombre(nombre) != null) {
            throw new InvalidParameterException("La editorial " + nombre + " ya existe en la base de datos.");
        }
    }
}
