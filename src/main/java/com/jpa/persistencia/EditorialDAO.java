package com.jpa.persistencia;

import java.util.List;

import com.jpa.entidades.Editorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class EditorialDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void crear(Editorial e) throws Exception {
        this.em.getTransaction().begin();
        this.em.persist(e);
        this.em.getTransaction().commit();
    }

    public void actualizar(Editorial e) throws Exception, NoResultException {
        this.em.getTransaction().begin();
        this.em.merge(e);
        this.em.getTransaction().commit();
    }

    public Editorial buscarPorId(int id) throws Exception {
        return this.em
                .createQuery("SELECT e FROM Editorial e WHERE id = :id", Editorial.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public Editorial buscarPorNombre(String nombre) throws Exception {
        try {
            return this.em
                    .createQuery("SELECT e FROM Editorial e WHERE nombre = :nombre", Editorial.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }

    }

    public List<Editorial> listar() throws Exception {
        return this.em
                .createQuery("SELECT e FROM Editorial e", Editorial.class)
                .getResultList();
    }

    public void darDeBaja(String nombre) throws Exception {
        Editorial e = buscarPorNombre(nombre);
        e.setAlta(false);
        actualizar(e);
    }

    public void eliminar(int id) throws Exception {
        Editorial e = buscarPorId(id);

        if (e != null) {
            this.em.getTransaction().begin();
            this.em.remove(e);
            this.em.getTransaction().commit();
        }
    }

    public void eliminarPorNombre(String nombre) throws Exception {
        Editorial e = buscarPorNombre(nombre);

        if (e != null) {
            this.em.getTransaction().begin();
            this.em.remove(e);
            this.em.getTransaction().commit();
        }
    }
}
