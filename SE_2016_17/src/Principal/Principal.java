package Principal;

import clases.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

    private static ArrayList<Persona> personas = new ArrayList<>();
    private static DateTimeFormatter fechaForma = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        int opcion;
		boolean opMenu = true;
		String menu = "1.- Dar de alta\n" +"2.- Listado de clientes\n" +"3.-Añadir medicion de un cliente y ver evolucion" + "4.Estadisticas de clientes(IMC)\n" +"5.- Salir del programa\n";

		while (opMenu) {
			do {
				System.out.println(menu);
				System.out.println("Elige una opcion:\n");
				opcion = Util2.leerInt();
				if (opcion > 5 || opcion < 1) {
					System.out.println("Tienes que introducir un numero del 1 al 5.\n");
				}
			} while (opcion > 5 || opcion < 1);

			switch (opcion) {
			case 1:
                altaPersona();
				break;
			case 2:
				listadoClientes();
				break;
			case 3:
				añadirMedicionYEvolucion();
				break;
			case 4:
				estadisticasGordis();
				break;
			case 5:
				System.out.println("Saliendo del programa.");
				opMenu = false;
				break;
			}
		}

    }

    public static void altaPersona() {
        System.out.println("ALTA DE PERSONA");
        System.out.println("1.- Cliente");
        System.out.println("2.- Empleado");
        System.out.println("¿A quien quieres dar de alta?");

        int tipo = Util2.leerInt();

        System.out.println("Nombre:");
        String nombre = Util2.introducirCadena();

        System.out.println("Fecha de nacimiento (dd-MM-yyyy): ");
        LocalDate fechaNacimiento = LocalDate.parse(Util2.leerFecha(), fechaForma);

        if (tipo==1) {
            System.out.println("Altura en metro (1.72):");
            float altura = Util2.leerFloat();
            Cliente cliente = new Cliente(nombre, fechaNacimiento, null, altura);
/* revisar altura antes */
            System.out.println("Cliente creado con codigo: " +cliente.getCodigo());

            boolean continuar = true;
            while(continuar) {
                System.out.println("Fecha de medicion (dd-MM-yyyy): ");
                LocalDate fechaMedicion = LocalDate.parse(Util2.leerFecha(), fechaForma);
                System.out.println("Peso en kg: ");
                float peso = Util2.leerFloat();
                cliente.agregarMedicion(new Medicion(fechaMedicion, peso));

                System.out.println("¿Deseas añadir otra medicion? (s/n):");
                String respuesta = Util2.introducirCadena();
                continuar = respuesta.equals("s");
            }

            personas.add(cliente);

            System.out.println("Cliente registrado exitosamente.");

        } else if (tipo == 2) {
               System.out.println("Fecha de alta en la empresa (dd-MM-yyyy): ");
               LocalDate fechaAlta = LocalDate.parse(Util2.leerFecha(), fechaForma);
               Empleado empleado = new Empleado(nombre, fechaNacimiento, fechaAlta);
               personas.add(empleado);
               System.out.println("Empleado registrado correctamente.");

        } else {
            System.out.println("Opcion no valida.");
        }
    }

    private static void listadoClientes() {
        System.out.println("LISTADO DE CLIENTES");

        ArrayList<Cliente> clientes = obtenerClientes();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println("\n" + cliente);
        }
    }

    private static void añadirMedicionYEvolucion() {
        System.out.println("\n AÑADIR MEDICIÓN Y VER EVOLUCIÓN");
        System.out.print("Nombre del cliente: ");
        String nombre = Util2.introducirCadena();

        Cliente cliente = buscarCliente(nombre);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Informacion del cliente:");
        System.out.println(cliente);
        cliente.mostrarMediciones();

        System.out.println("Nueva medicion:");
        System.out.print("Fecha de medicion (dd-MM-yyyy): ");
        LocalDate fechaMedicion = LocalDate.parse(Util2.leerFecha(), fechaForma);
        System.out.print("Peso en kg: ");
        float peso = Util2.leerFloat();
        cliente.agregarMedicion(new Medicion(fechaMedicion, peso));

        System.out.println("Estadisticas y Evolucion:");

        float evolucion = cliente.calcularEvolucion();

        if (cliente.getMediciones().size() > 1) {
            System.out.printf("Evolución: %.2f kg ", evolucion);
            if (evolucion > 0) {
                System.out.println("(ha aumentado de peso)");
                System.out.println("💡 Comentario: Intenta reducir las calorías y aumentar la actividad física.");
            } else if (evolucion < 0) {
                System.out.println("(ha perdido peso)");
                System.out.println("💡 Comentario: ¡Excelente progreso! Continúa con tus hábitos saludables.");
            } else {
                System.out.println("(peso estable)");
                System.out.println("💡 Comentario: Tu peso se mantiene estable.");
            }
    }

    try {
            float imc = cliente.calcularIMC();
            System.out.printf("IMC actual: %.2f (%s)\n", imc, Cliente.obtenerClasificacioneIMC(imc));
        } catch (ArithmeticException e) {
            System.out.println("Error al calcular IMC: " + e.getMessage());
        }

    }

    private static void estadisticasGordis() {
        System.out.println("ESTADISTICAS DE CLIENTES POR IMC");

        ArrayList<Cliente> clientes = obtenerClientes();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        
        
        /*
        Map<String, Integer> contadores = new HashMap<>();

        for (Cliente cliente : clientes) {
            try {
                float imc = cliente.calcularIMC();
                if (imc != -1) {
                    String clasificacion = Cliente.obtenerClasificacioneIMC(imc);
                    contadores.put(clasificacion, contadores.getOrDefault(clasificacion, 0) + 1);
                }
            } catch (ArithmeticException e) {
            }
        }
        */
        
        
/*
        Map<String, Integer> ordenado = contadores.entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new
            ));
*/

        System.out.println("\n┌────────────────────────────────────┬─────────────────┐");
        System.out.println("│ Clasificación                      │ Nº de clientes  │");
        System.out.println("├────────────────────────────────────┼─────────────────┤");
        
        for (Map.Entry<String, Integer> entry : ordenado.entrySet()) {
            System.out.printf("│ %-34s │ %-15d │%n", entry.getKey(), entry.getValue());
        }
        
        System.out.println("└────────────────────────────────────┴─────────────────┘");
    }

    /* METODOS NO PRINCIPALES */

    private static ArrayList<Cliente> obtenerClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (Persona p : personas) {
            if (p instanceof Cliente) {
                clientes.add((Cliente) p);
            }
        }
        return clientes;
    }

    private static Cliente buscarCliente(String nombre) {
        for (Persona p : personas) {
            if (p instanceof Cliente && p.getNombre().equalsIgnoreCase(nombre)) {
                return (Cliente) p;
            }
        }
        return null;
    }

}
