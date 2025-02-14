package com.jpa.servicios;

import com.jpa.entidades.GamaProducto;
import com.jpa.persistencia.GamaProductoDAO;

public class GamaProductoServicio {
    private final GamaProductoDAO daoGamaProducto;// Instancio a la unidad d persistencia para acceder a los metodos del
                                                  // EM

    public GamaProductoServicio() {
        this.daoGamaProducto = new GamaProductoDAO();
    }

    public void crearGamaproducto(int idGama, String descripcionTexto, String descripcionHtml, String gama,
            String imagen) {

        try {
            // Crear una nueva instancia de GamaProducto
            GamaProducto GamaProductoNueva = new GamaProducto();

            GamaProductoNueva.setIdGama(idGama);
            GamaProductoNueva.setDescripcionTexto(descripcionTexto);
            GamaProductoNueva.setDescripcionHtml(descripcionHtml);
            GamaProductoNueva.setGama(gama);
            GamaProductoNueva.setImagen(imagen);

            // Llamar al método de GamaProductoDAO para guardar la nueva GamaProducto
            daoGamaProducto.guardarGamaProducto(GamaProductoNueva);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo la nueva GamaProducto de manera correcta");
        }

    }
}
