package com.jpa.servicios;

import java.security.InvalidParameterException;

import com.jpa.entidades.Editorial;
import com.jpa.persistencia.EditorialDAO;

import jakarta.persistence.NoResultException;

public class EditorialServicio {

    private final EditorialDAO editorialDao;

    public EditorialServicio() {
        this.editorialDao = new EditorialDAO();
    }

    public Editorial crearEditorial(String nombre, boolean alta) throws Exception {

        this.validarData(nombre);

        Editorial e = new Editorial();
        e.setNombre(nombre);
        e.setAlta(alta);

        this.editorialDao.crear(e);
        return e;
    }

    public Editorial editarEditorial(int id, String nombre, boolean alta) throws Exception {
        this.validarData(nombre);

        editorialExiste(id);

        Editorial e = new Editorial();
        e.setId(id);
        e.setNombre(nombre);
        e.setAlta(alta);

        this.editorialDao.actualizar(e);

        return e;
    }

    public Editorial buscarEditorialPorNombre(String nombre) throws Exception {
        Editorial e = this.editorialDao.buscarPorNombre(nombre);

        System.out.println("ID | Nombre | Alta");
        System.out.println(e.getId() + " | " + e.getNombre() + " | " + e.isAlta());

        return e;
    }

    public Editorial buscarEditorialPorId(int id) throws Exception {
        return this.editorialDao.buscarPorId(id);
    }

    public void listaEditoriales() throws Exception {
        System.out.println("ID | Nombre | Alta");
        for (Editorial e : this.editorialDao.listar()) {
            System.out.println(e.getId() + " | " + e.getNombre() + " | " + e.isAlta());
        }
    }

    public void darDeBajaEditorial(String nombre) throws Exception {
        this.editorialDao.darDeBaja(nombre);
    }

    public void eliminarEditorialPorNombre(String nombre) throws Exception {
        this.editorialDao.eliminarPorNombre(nombre);
    }

    public void eliminarEditorial(int id) throws Exception {
        this.editorialDao.eliminar(id);
    }

    private void editorialExiste(int id) throws Exception {
        try {
            this.editorialDao.buscarPorId(id);
        } catch (NoResultException e) {
            System.out.println("No existe el registro con el ID " + id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void validarData(String nombre) throws Exception {
        if (nombre == null) {
            throw new InvalidParameterException("El nombre no puede ser nulo");
        }
        if (nombre.length() < 2) {
            throw new InvalidParameterException("El nombre debe contener al menos 2 caracteres.");
        }

        if (this.editorialDao.buscarPorNombre(nombre) != null) {
            throw new InvalidParameterException("La editorial " + nombre + " ya existe en la base de datos.");
        }
    }
}
