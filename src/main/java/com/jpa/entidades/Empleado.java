package com.jpa.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// ENTIDAD REVISADA Y ADAPTADA EN DOCS
@Entity // Declaro la clase como entidad
@Table(name = "empleado") // Específico como quiero llamar la tabla en mi BBDD.
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int idEmpleado;

    @Column(name = "apellido", length = 50) // Determino como se va a llamar la columna y cantidad maxima de caracteres
    private String apellido;

    @Column(name = "codigo_empleado")
    private int codigoEmpleado;

    @Column(name = "email", length = 100) // Determino como se va a llamar la columna y cantidad maxima de caracteres
    private String email;

    @Column(name = "extension", length = 10) // Determino cómo se va a llamar la columna y cantidad máxima de caracteres
    private String extension;

    @Column(name = "id_jefe")
    private int idJefe;

    @Column(name = "nombre", length = 50) // Determino como se va a llamar la columna y cantidad máxima de caracteres )
    private String nombre;

    @Column(name = "puesto")
    private String puesto;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }) // "Muchos empleados pueden pertenecer a una misma
                                                                     // oficina"
    @JoinColumn(name = "id_oficina") //// Establezco la relacion con Oficina. Indico con que "dato se relacionan".
    private Oficina Oficina;

    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Oficina getOficina() {
        return Oficina;
    }

    public void setOficina(Oficina oficina) {
        Oficina = oficina;
    }

}
