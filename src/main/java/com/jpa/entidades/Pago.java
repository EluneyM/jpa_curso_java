package com.jpa.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private int idPago;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pago")
    private Date fechaPago;

    @Column(name = "forma_pago")
    private String formaPago;

    @Column(name = "id_transaccion")
    private String idTransaccion;

    @Column(name = "total")
    private double total;

    @ManyToOne // Muchos pagos pueden estar asociados a un cliente.
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    // GETTERS Y SETTERS / CONSTRUCTOR VACÍO
}
