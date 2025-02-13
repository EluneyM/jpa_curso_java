package com.jpa.persistencia;

import com.jpa.entidades.GamaProducto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GamaProductoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarGamaProducto(GamaProducto gamaProducto) {
        em.getTransaction().begin();
        em.persist(gamaProducto);
        em.getTransaction().commit();
    }

    public GamaProducto buscarGamaProducto(int id) {
        return em.find(GamaProducto.class, id);
    }

    public void actualizarGamaProducto(GamaProducto gamaProducto) {
        em.getTransaction().begin();
        em.merge(gamaProducto);
        em.getTransaction().commit();
    }

    public void eliminarGamaProducto(int id) {
        GamaProducto gamaProducto = em.find(GamaProducto.class, id);
        if (gamaProducto != null) {
            em.getTransaction().begin();
            em.remove(gamaProducto);
            em.getTransaction().commit();
        }
    }
}
