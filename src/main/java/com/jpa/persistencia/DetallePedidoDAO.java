package com.jpa.persistencia;

import com.jpa.entidades.DetallePedido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DetallePedidoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarDetallePedido(DetallePedido detallePedido) {
        em.getTransaction().begin();
        em.persist(detallePedido);
        em.getTransaction().commit();
    }

    public DetallePedido buscarDetallePedido(int id) {
        return em.find(DetallePedido.class, id);
    }

    public void actualizarDetallePedido(DetallePedido detallePedido) {
        em.getTransaction().begin();
        em.merge(detallePedido);
        em.getTransaction().commit();
    }

    public void eliminarDetallePedido(int id) {
        DetallePedido detallePedido = em.find(DetallePedido.class, id);
        if (detallePedido != null) {
            em.getTransaction().begin();
            em.remove(detallePedido);
            em.getTransaction().commit();
        }
    }
}
