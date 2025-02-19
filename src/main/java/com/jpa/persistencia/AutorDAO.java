package com.jpa.persistencia;

import java.util.List;

import com.jpa.entidades.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class AutorDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void crear(Autor e) throws Exception {
        this.em.getTransaction().begin();
        this.em.persist(e);
        this.em.getTransaction().commit();
    }

    public void actualizar(Autor e) throws Exception, NoResultException {
        this.em.getTransaction().begin();
        this.em.merge(e);
        this.em.getTransaction().commit();
    }

    public Autor buscarPorId(int id) throws Exception {
        return this.em
                .createQuery("SELECT a FROM Autor a WHERE id = :id", Autor.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public Autor buscarPorNombre(String nombre) throws Exception {
        try {
            return this.em
                    .createQuery("SELECT a FROM Autor a WHERE nombre = :nombre", Autor.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    public void darDeBaja(String nombre) throws Exception {
        Autor a = buscarPorNombre(nombre);
        if (a != null) {
            a.setAlta(false);
            actualizar(a);
        }
    }

    public List<Autor> listar() throws Exception {
        return this.em
                .createQuery("SELECT a FROM Autor a", Autor.class)
                .getResultList();
    }

    public void eliminar(int id) throws Exception {
        Autor e = buscarPorId(id);

        if (e != null) {
            this.em.getTransaction().begin();
            this.em.remove(e);
            this.em.getTransaction().commit();
        }
    }
}
