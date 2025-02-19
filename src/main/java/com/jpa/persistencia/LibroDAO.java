package com.jpa.persistencia;

import java.util.List;

import com.jpa.entidades.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class LibroDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void crear(Libro l) throws Exception {
        this.em.getTransaction().begin();
        this.em.persist(l);
        this.em.getTransaction().commit();
    }

    public void actualizar(Libro l) throws Exception, NoResultException {
        this.em.getTransaction().begin();
        this.em.merge(l);
        this.em.getTransaction().commit();
    }

    public Libro buscarPorId(int id) throws Exception {
        return this.em
                .createQuery("SELECT l FROM Libro l WHERE id = :id", Libro.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public Libro buscarPorIsbn(Long isbn) throws Exception {
        try {
            return this.em
                    .createQuery("SELECT l FROM Libro l WHERE isbn = :isbn", Libro.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Libro> buscarPorTitulo(String titulo) throws Exception {
        return this.em
                .createQuery("SELECT l FROM Libro l WHERE titulo = :titulo", Libro.class)
                .setParameter("titulo", titulo)
                .getResultList();
    }

    public List<Libro> buscarPorNombreDeAutor(String nombre) throws Exception {
        return this.em
                .createQuery("SELECT l FROM Libro l JOIN autor a WHERE a.nombre = :nombre", Libro.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }

    public List<Libro> buscarPorNombreDeEditorial(String nombre) throws Exception {
        return this.em
                .createQuery("SELECT l FROM Libro l JOIN editorial e WHERE e.nombre = :nombre", Libro.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }

    public List<Libro> listar() throws Exception {
        return this.em
                .createQuery("SELECT l FROM Libro l", Libro.class)
                .getResultList();
    }

    public void eliminar(int id) throws Exception {
        Libro l = buscarPorId(id);

        if (l != null) {
            this.em.getTransaction().begin();
            this.em.remove(l);
            this.em.getTransaction().commit();
        }
    }
}
