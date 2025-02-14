package com.jpa.servicios;

import com.jpa.entidades.Empleado;
import com.jpa.persistencia.EmpleadoDAO;

public class EmpleadoServicio {
    private final EmpleadoDAO daoEmpleado;// Instancio a la unidad d persistencia para acceder a los metodos del EM

    public EmpleadoServicio() {
        this.daoEmpleado = new EmpleadoDAO();
    }

    public Empleado buscarEmplado(int id) {
        return daoEmpleado.buscarEmpleado(id);
    }
}
