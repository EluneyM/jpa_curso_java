package com.jpa.persistencia;

import com.jpa.entidades.Oficina;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OficinaDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardaOficina(Oficina oficina) throws Exception {
        em.getTransaction().begin();
        em.persist(oficina);
        em.getTransaction().commit();
    }

    public Oficina buscarOficina(int id) {
        return em.find(Oficina.class, id);
    }

    public void actualizarOficina(Oficina oficina) {
        em.getTransaction().begin();
        em.merge(oficina);
        em.getTransaction().commit();
    }

    public void eliminarOficina(int id) {
        Oficina oficina = em.find(Oficina.class, id);
        if (oficina != null) {
            em.getTransaction().begin();
            em.remove(oficina);
            em.getTransaction().commit();
        }
    }
}
