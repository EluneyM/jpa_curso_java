package com.jpa.servicios;

import java.util.List;

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

    public void listarEmpleadosPorOficina(int idOficina) throws Exception {
        List<Empleado> empleadosOficina = daoEmpleado.listarEmpleadoPorOficina(idOficina);
        imprimirLista(empleadosOficina);
    }

    public void imprimirLista(List<Empleado> listaRecibida) throws Exception {
        for (Empleado empleado : listaRecibida) {
            System.out.println(empleado.getCodigoEmpleado() + " - " + empleado.getApellido() + " - "
                    + empleado.getNombre());
        }
    }

    public void imprimirEmpleadosExcluyendo(int idEmpleado) throws Exception {
        List<Empleado> listaEmpleados = daoEmpleado.listarEmpleadosExcluyendo(idEmpleado);
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado.getNombre() + " - " +
                    empleado.getOficina().getCiudad() + " - " +
                    empleado.getOficina().getCodigoOficina());
        }
    }

}
