package com.jpa;

import com.jpa.entidades.Empleado;
import com.jpa.servicios.ClienteServicio;
import com.jpa.servicios.EmpleadoServicio;
import com.jpa.servicios.GamaProductoServicio;

public class Application {

    public static void main(String[] args) {
        // Instanciar la clase OficinaServicio para acceder a sus métodos
        // OficinaServicio oficinaServicio = new OficinaServicio();

        // Llamar al método del servicio para crear una nueva oficina
        // oficinaServicio.crearOficna("OFI01", "Mendoza", "Argentina", "Cuyo",
        // "11111111",
        // "CP5000");

        ClienteServicio clienteServicio = new ClienteServicio();

        Empleado empleado = (new EmpleadoServicio()).buscarEmplado(1);

        clienteServicio.crearCliente(123423580, "Marcos", "Contreras", "999999999", "9999999999", "Viedma", "Río Negro",
                "Argentina", "8500", 21341234.23, empleado);

        GamaProductoServicio gamaProductoServicio = new GamaProductoServicio();

    }
}
