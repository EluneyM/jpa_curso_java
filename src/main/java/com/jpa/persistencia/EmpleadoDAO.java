package com.jpa.persistencia;

import java.util.List;

import com.jpa.entidades.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpleadoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardaEmpleado(Empleado empleado) throws Exception {
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();
    }

    public Empleado buscarEmpleado(int id) {
        return em.find(Empleado.class, id);
    }

    public void actualizarEmpleado(Empleado empleado) {
        em.getTransaction().begin();
        em.merge(empleado);
        em.getTransaction().commit();
    }

    public void eliminarEmpleado(int id) {
        Empleado empleado = em.find(Empleado.class, id);
        if (empleado != null) {
            em.getTransaction().begin();
            em.remove(empleado);
            em.getTransaction().commit();
        }
    }

    public List<Empleado> listarEmpleadoPorOficina(int idOficina) throws Exception {
        return em.createQuery("SELECT c FROM Empleado c WHERE c.Oficina.idOficina = :id", Empleado.class)
                .setParameter("id", idOficina)
                .getResultList();
    }

}
