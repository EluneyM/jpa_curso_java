package com.jpa.servicios;

import java.security.InvalidParameterException;

import com.jpa.entidades.GamaProducto;
import com.jpa.persistencia.GamaProductoDAO;

public class GamaProductoServicio {
    private final GamaProductoDAO daoGamaProducto;// Instancio a la unidad d persistencia para acceder a los metodos del
                                                  // EM

    public GamaProductoServicio() {
        this.daoGamaProducto = new GamaProductoDAO();
    }

    public void crearGamaproducto(String descripcionTexto, String descripcionHtml, String gama,
            String imagen) {

        try {
            this.validarData(descripcionTexto, gama);
            // Crear una nueva instancia de GamaProducto
            GamaProducto GamaProductoNueva = new GamaProducto();

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

    private void validarData(String descripcionTexto, String gama) throws InvalidParameterException {
        if (descripcionTexto == null) {
            throw new InvalidParameterException("Descripción es obligatoria.");
        }

        if (descripcionTexto.length() > 255) {
            throw new InvalidParameterException("Descripción no puede contener más de 255 caracteres.");
        }

        if (gama == null) {
            throw new InvalidParameterException("Gama es obligatoria.");
        }

        if (gama.length() > 255) {
            throw new InvalidParameterException("Gama no puede contener más de 255 caracteres.");
        }
    }
}
