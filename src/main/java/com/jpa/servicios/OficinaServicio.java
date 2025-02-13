package com.jpa.servicios;

import com.jpa.entidades.Oficina;
import com.jpa.persistencia.OficinaDAO;

public class OficinaServicio {

    private final OficinaDAO daoOficina;// Instancio a la unidad d persistencia para acceder a los metodos del EM

    public OficinaServicio() {
        this.daoOficina = new OficinaDAO();
    }

    public void crearOficna(String codigodOficina, String ciudad, String pais,
            String region, String telefono, String codigoPostal) {

        try {
            // Crear una nueva instancia de Oficina
            Oficina oficinaNueva = new Oficina();

            oficinaNueva.setCodigoOficina(codigodOficina);
            oficinaNueva.setCiudad(ciudad);
            oficinaNueva.setPais(pais);
            oficinaNueva.setRegion(region);
            oficinaNueva.setTelefono(telefono);
            oficinaNueva.setCodigoPostal(codigoPostal);

            // Llamar al método de OficinaDAO para guardar la nueva oficina
            daoOficina.guardaOficina(oficinaNueva);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo la nueva oficina de manera correcta");
        }

    }
}
