package com.jpa.servicios;

import java.util.List;

import com.jpa.entidades.Pago;
import com.jpa.persistencia.PagoDAO;

public class PagoServicio {
    private final PagoDAO daoPago;// Instancio a la unidad d persistencia para acceder a los metodos del EM

    public PagoServicio() {
        this.daoPago = new PagoDAO();
    }

    public void listarPagosPorNombreDeContacto(String nombreContacto) throws Exception {
        List<Pago> listaPagos = this.daoPago.listarPagosPorNombreDeContacto(nombreContacto);
        imprimirLista(listaPagos);
    }

    public void imprimirLista(List<Pago> listaRecibida) throws Exception {
        for (Pago unitariaPago : listaRecibida) {
            System.out.println(unitariaPago.getIdPago() + " - " + unitariaPago.getTotal() + " - "
                    + unitariaPago.getCliente().getNombreContacto());
        }
    }
}
