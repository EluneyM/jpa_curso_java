package com.jpa;

import java.util.Scanner;

import com.jpa.entidades.Autor;
import com.jpa.entidades.Editorial;
import com.jpa.servicios.AutorServicio;
import com.jpa.servicios.EditorialServicio;
import com.jpa.servicios.LibroServicio;

public class Application {
    private static Scanner scanner = new Scanner(System.in);
    private static LibroServicio libroServicio = new LibroServicio();
    private static AutorServicio autorServicio = new AutorServicio();
    private static EditorialServicio editorialServicio = new EditorialServicio();

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            try {
                switch (opcion) {
                    case 1:
                        crearLibro();
                        break;
                    case 2:
                        añadirAutor();
                        break;
                    case 3:
                        añadirEditorial();
                        break;
                    case 4:
                        buscarAutorPorNombre();
                        break;
                    case 5:
                        buscarLibroPorIsbn();
                        break;
                    case 6:
                        buscarLibroPorTitulo();
                        break;
                    case 7:
                        buscarLibrosPorAutor();
                        break;
                    case 8:
                        buscarLibrosPorEditorial();
                        break;
                    case 9:
                        darDeBajaLibro();
                        break;
                    case 10:
                        darDeBajaAutor();
                        break;
                    case 11:
                        darDeBajaEditorial();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        continuar = false;
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        scanner.close();
    }

    private static void crearLibro() throws Exception {
        // Solicitar datos del libro
        System.out.print("Introduce el ISBN: ");
        Long isbn = scanner.nextLong();

        System.out.print("Introduce el título: ");
        String titulo = scanner.nextLine();

        System.out.print("Introduce el año: ");
        int anio = scanner.nextInt();

        System.out.print("Introduce el número de ejemplares: ");
        int ejemplares = scanner.nextInt();

        System.out.print("¿Está dado de alta? (true/false): ");
        boolean alta = scanner.nextBoolean();

        // Solicitar datos del autor
        scanner.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Introduce el nombre del autor: ");
        String autorNombre = scanner.nextLine();

        // Crear un objeto Autor (suponiendo que existe una clase Autor con un
        // constructor adecuado)
        Autor autor = autorServicio.buscarAutorPorNombre(autorNombre);

        // Solicitar datos de la editorial
        System.out.print("Introduce el nombre de la editorial: ");
        String editorialNombre = scanner.nextLine();

        // Crear un objeto Editorial (suponiendo que existe una clase Editorial con un
        // constructor adecuado)
        Editorial editorial = editorialServicio.buscarEditorialPorNombre(editorialNombre);

        libroServicio.crearLibro(isbn, titulo, anio, ejemplares, alta, autor, editorial);
    }

    private static void darDeBajaEditorial() throws Exception {
        System.out.println("Ingrese el nombre de la editorial:");
        String nombre = scanner.nextLine();
        editorialServicio.darDeBajaEditorial(nombre);
    }

    private static void darDeBajaAutor() throws Exception {
        System.out.println("Ingrese el nombre del autor:");
        String nombre = scanner.nextLine();
        autorServicio.darDeBajaAutor(nombre);
    }

    private static void darDeBajaLibro() throws Exception {
        System.out.println("Ingrese el ISBN del libro:");
        Long isbn = scanner.nextLong();
        libroServicio.darDeBajaLibro(isbn);
    }

    private static void buscarLibrosPorEditorial() throws Exception {
        System.out.println("Ingrese nombre de editorial:");
        String nombre = scanner.nextLine();
        editorialServicio.buscarEditorialPorNombre(nombre);
    }

    private static void buscarLibrosPorAutor() throws Exception {
        System.out.println("Ingrese nombre de autor:");
        String nombre = scanner.nextLine();
        libroServicio.buscarLibrosPorNombreDeAutor(nombre);
    }

    private static void buscarLibroPorTitulo() throws Exception {
        System.out.println("Ingrese titulo del libro:");
        String titulo = scanner.nextLine();
        libroServicio.buscarLibroPorTitulo(titulo);
    }

    private static void buscarLibroPorIsbn() throws Exception {
        System.out.println("Ingrese ISBN del libro:");
        Long isbn = scanner.nextLong();
        libroServicio.buscarLibroPorIsbn(isbn);
    }

    private static void buscarAutorPorNombre() throws Exception {
        System.out.println("Ingrese nombre del autor:");
        String nombre = scanner.nextLine();
        autorServicio.buscarAutorPorNombre(nombre);
    }

    private static void añadirEditorial() throws Exception {
        System.out.print("Introduce el nombre de la editorial: ");
        String nombre = scanner.nextLine();

        System.out.print("¿Está la editorial dada de alta? (true/false): ");
        boolean alta = scanner.nextBoolean();

        editorialServicio.crearEditorial(nombre, alta);
    }

    private static void añadirAutor() throws Exception {
        System.out.print("Introduce el nombre de la autor: ");
        String nombre = scanner.nextLine();

        System.out.print("¿Está la autor dada de alta? (true/false): ");
        boolean alta = scanner.nextBoolean();

        autorServicio.crearAutor(nombre, alta);
    }

    private static void mostrarMenu() {
        System.out.println("------ Menú ------");
        System.out.println("1. Añadir libro");
        System.out.println("2. Añadir autor");
        System.out.println("3. Añadir editorial");
        System.out.println("4. Buscar autor por nombre");
        System.out.println("5. Buscar libro por ISBN");
        System.out.println("6. Buscar libro por título");
        System.out.println("7. Buscar libros por autor");
        System.out.println("8. Buscar libros por editorial");
        System.out.println("9. Dar de baja libro");
        System.out.println("10. Dar de baja autor");
        System.out.println("11. Dar de baja editorial");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

}
