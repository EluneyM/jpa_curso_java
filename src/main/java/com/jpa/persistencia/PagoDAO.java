package com.jpa.persistencia;

import com.jpa.entidades.Pago;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PagoDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardaPago(Pago pago) throws Exception {
        em.getTransaction().begin();
        em.persist(pago);
        em.getTransaction().commit();
    }

    public Pago buscarPago(int id) {
        return em.find(Pago.class, id);
    }

    public void actualizarPago(Pago pago) {
        em.getTransaction().begin();
        em.merge(pago);
        em.getTransaction().commit();
    }

    public void eliminarPago(int id) {
        Pago pago = em.find(Pago.class, id);
        if (pago != null) {
            em.getTransaction().begin();
            em.remove(pago);
            em.getTransaction().commit();
        }
    }
}
