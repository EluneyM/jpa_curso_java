package com.jpa.persistencia;

import java.util.List;

import com.jpa.entidades.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClienteDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardaCliente(Cliente cliente) throws Exception {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public Cliente buscarCliente(int id) {
        return em.find(Cliente.class, id);
    }

    public void actualizarCliente(Cliente cliente) {
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
    }

    public void eliminarCliente(int id) {
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente != null) {
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        }
    }

    public List<Cliente> listarTodas() throws Exception {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
    }

    public List<Cliente> listarClientesPorNombre(String nombreABuscar) throws Exception {
        return em.createQuery("SELECT c FROM Cliente c WHERE c.nombreContacto LIKE :nombre", Cliente.class)
                .setParameter("nombre", "%" + nombreABuscar + "%")
                .getResultList();
    }

    public List<Cliente> listarClientesPorCiudad(String ciudadABuscar) throws Exception {
        return em.createQuery("SELECT c FROM Cliente c WHERE c.ciudad LIKE :nombreCiudad", Cliente.class)
                .setParameter("nombreCiudad", "%" + ciudadABuscar + "%")
                .getResultList();
    }

}
