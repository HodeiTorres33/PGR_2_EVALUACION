package principal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import module.*;

public class Principal {

    public static void main(String[] args) {

        List<Socio> listaSocios = new ArrayList<>();

        boolean seguir = true;
        while (seguir) {
            mostrarMenu();
            int opcion = Util2.leerInt();
            switch (opcion) {
                case 0:
                    opcion0_introducir(listaSocios);
                    break;
                case 1:
                    opcion1_visualizarTodos(listaSocios);
                    break;
                case 2:
                    opcion2_visualizarBibliotecarios(listaSocios);
                    break;
                case 3:
                    opcion3_bibliotecariosPorSeccion(listaSocios);
                    break;
                case 4:
                    opcion4_buscarPorNombre(listaSocios);
                    break;
                case 5:
                    opcion5_filtrarPorCuota(listaSocios);
                    break;
                case 6:
                    opcion6_bibliotecariosPorAnios(listaSocios);
                    break;
                case 7:
                    opcion7_darDeBaja(listaSocios);
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    seguir = false;
                    break;
                default:
                    System.out.println("Opción no válida. Introduce 0..8");
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        System.out.println("MENÚ de la aplicación");
        System.out.println("0. Introducir datos de socios y/o bibliotecarios");
        System.out.println("1. Visualizar todos los datos (con cuota final)");
        System.out.println("2. Visualizar únicamente los bibliotecarios");
        System.out.println("3. Visualizar bibliotecarios de una sección concreta");
        System.out.println("4. Buscar por nombre o parte del nombre");
        System.out.println("5. Introducir una cuota mensual y mostrar socios con cuota final >=");
        System.out.println("6. Introducir un número de años y mostrar bibliotecarios con ese tiempo o más");
        System.out.println("7. Dar de baja a un socio/bibliotecario por DNI");
        System.out.println("8. Salir");
        System.out.print("Elige opción: ");
    }

   
    public static void opcion0_introducir(List<Socio> lista) {
        System.out.print("Introduce DNI: ");
        String dni = Util2.introducirCadena();

        
        for (Socio s : lista) {
            if (s.getDni().equalsIgnoreCase(dni)) {
                System.out.println("ERROR: ya existe una persona con ese DNI.");
                return;
            }
        }

        System.out.print("Nombre completo: ");
        String nombre = Util2.introducirCadena();

        int mes;
        do {
            System.out.print("Mes de alta (1-12): ");
            mes = Util2.leerInt();
            if (mes < 1 || mes > 12) System.out.println("Mes inválido (1..12).");
        } while (mes < 1 || mes > 12);

        System.out.print("Año de alta: ");
        int anyo = Util2.leerInt();

        int limite;
        do {
            System.out.print("Número de libros que puede solicitar a la vez (0.." + Socio.LIMITE_LIBROS + "): ");
            limite = Util2.leerInt();
            if (limite < 0 || limite > Socio.LIMITE_LIBROS) System.out.println("Número fuera de rango.");
        } while (limite < 0 || limite > Socio.LIMITE_LIBROS);

        System.out.print("¿Es bibliotecario? (S/N): ");
        String esBib = Util2.introducirCadena().trim().toUpperCase();

        if (esBib.equals("S")) {
            System.out.print("Nombre de la sección: ");
            String seccion = Util2.introducirCadena();
            Bibliotecario b = new Bibliotecario(dni, nombre, mes, anyo, limite, seccion);
            lista.add(b);
            System.out.printf("Bibliotecario añadido. Cuota final: %.2f€\n", b.calcularCuotaFinal());
        } else {
            Socio s = new Socio(dni, nombre, mes, anyo, limite);
            lista.add(s);
            System.out.printf("Socio añadido. Cuota final: %.2f€\n", s.calcularCuotaFinal());
        }
    }

    
    public static void opcion1_visualizarTodos(List<Socio> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay socios registrados.");
            return;
        }
        System.out.println("Todos los socios (incluye bibliotecarios):");
        for (Socio s : lista) {
            System.out.println(s.toString());
        }
    }

    
    public static void opcion2_visualizarBibliotecarios(List<Socio> lista) {
        boolean any = false;
        for (Socio s : lista) {
            if (s instanceof Bibliotecario) {
                if (!any) {
                    System.out.println("Bibliotecarios:");
                    any = true;
                }
                System.out.println(s.toString());
            }
        }
        if (!any) System.out.println("No hay bibliotecarios registrados.");
    }

    
    public static void opcion3_bibliotecariosPorSeccion(List<Socio> lista) {
        System.out.print("Introduce sección: ");
        String seccion = Util2.introducirCadena();
        boolean any = false;
        for (Socio s : lista) {
            if (s instanceof Bibliotecario) {
                Bibliotecario b = (Bibliotecario) s;
                if (b.getSeccion().equalsIgnoreCase(seccion)) {
                    if (!any) {
                        System.out.println("Bibliotecario/s de la sección " + seccion + ":");
                        any = true;
                    }
                    System.out.println(" - " + b.getNombreCompleto());
                }
            }
        }
        if (!any) System.out.println("No hay bibliotecarios en esa sección.");
    }

    
    public static void opcion4_buscarPorNombre(List<Socio> lista) {
        System.out.print("Introduce nombre o parte del nombre: ");
        String q = Util2.introducirCadena().toLowerCase();
        boolean found = false;
        for (Socio s : lista) {
            if (s.getNombreCompleto().toLowerCase().contains(q)) {
                found = true;
                System.out.println("DNI: " + s.getDni());
                System.out.println("Años en la biblioteca: " + s.calcularAniosEnBiblioteca());
                System.out.println("¿Es bibliotecario?: " + (s instanceof Bibliotecario ? "Sí" : "No"));
                System.out.println("-----");
            }
        }
        if (!found) System.out.println("No se encontraron coincidencias.");
    }

   
    public static void opcion5_filtrarPorCuota(List<Socio> lista) {
        System.out.print("Introduce cuota mensual (valor): ");
        double cuota = Util2.leerDouble();
        boolean any = false;
        for (Socio s : lista) {
            if (s.calcularCuotaFinal() >= cuota) {
                if (!any) {
                    System.out.println("Socios con cuota final >= " + cuota + "€:");
                    any = true;
                }
                System.out.printf("%s | %.2f€ | %s\n",
                        s.getNombreCompleto(),
                        s.calcularCuotaFinal(),
                        (s instanceof Bibliotecario ? "Bibliotecario" : "Socio"));
            }
        }
        if (!any) System.out.println("No se encontraron socios con cuota final igual o superior.");
    }

    
    public static void opcion6_bibliotecariosPorAnios(List<Socio> lista) {
        System.out.print("Introduce número de años mínimo: ");
        int años = Util2.leerInt();
        boolean any = false;
        for (Socio s : lista) {
            if (s instanceof Bibliotecario && s.calcularAniosEnBiblioteca() >= años) {
                if (!any) {
                    System.out.println("Bibliotecarios con " + años + " años o más:");
                    any = true;
                }
                Bibliotecario b = (Bibliotecario) s;
                System.out.println(b.getNombreCompleto() + " | Años: " + b.calcularAniosEnBiblioteca() + " | Sección: " + b.getSeccion());
            }
        }
        if (!any) System.out.println("No se encontraron bibliotecarios con ese tiempo o más.");
    }

    
    public static void opcion7_darDeBaja(List<Socio> lista) {
        System.out.print("Introduce DNI a dar de baja: ");
        String dni = Util2.introducirCadena();
        Iterator<Socio> it = lista.iterator();
        while (it.hasNext()) {
            Socio s = it.next();
            if (s.getDni().equalsIgnoreCase(dni)) {
                it.remove();
                System.out.println("Persona con DNI " + dni + " dada de baja correctamente.");
                return;
            }
        }
        System.out.println("ERROR: no existe una persona con ese DNI.");
    }
}
