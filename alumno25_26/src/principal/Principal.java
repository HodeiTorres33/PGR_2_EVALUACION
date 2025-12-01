package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import module.Alumnado;
import module.Ciclo;
import module.Util2;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Alumnado> listaAlumnos = new ArrayList<>();
		int opcion;
		boolean opMenu = true;
		String menu = "1.- Matricular \n" + "2.- Listado \n" + "3.- Listado (info total)\n" + "4.- Modificar datos\n"
				+ "5.- Modificar datos de DAW (edad determinada)\n" + "6.- Dar de baja\n" + "7.- Salir";

		while (opMenu) {
			do {
				System.out.println(menu);
				System.out.println("Elige una opcion:\n");
				opcion = Util2.leerInt();
				if (opcion > 7 || opcion < 1) {
					System.out.println("Tienes que introducir un numero del 1 al 7.\n");
				}
			} while (opcion > 7 || opcion < 1);

			switch (opcion) {
			case 1:
				matricularAlumno(listaAlumnos);
				break;
			case 2:
				if (verificarListaVacia(listaAlumnos)) {
					mostrar(listaAlumnos);
				}
				break;
			case 3:
				if (verificarListaVacia(listaAlumnos)) {
					mostrarPorNif(listaAlumnos);
				}
				break;
			case 4:
				if (verificarListaVacia(listaAlumnos)) {
					modificarDatosAlumno(listaAlumnos);
				}
				break;
			case 5:
				if (verificarListaVacia(listaAlumnos)) {
					modificarCampoRepetidor(listaAlumnos);
				}
				break;
			case 6:
				if (verificarListaVacia(listaAlumnos)) {
					darDeBaja(listaAlumnos);
				}
				break;
			case 7:
				System.out.println("Saliendo del programa.");
				opMenu = false;
				break;
			}
		}
	}

	private static boolean verificarListaVacia(ArrayList<Alumnado> listaAlumnos) {
		if (listaAlumnos.isEmpty()) {
			System.out.println("\n*** AVISO: NO HAY ALUMNOS/AS INTRODUCIDOS ***\n");
			return false;
		}
		return true;
	}

	private static void matricularAlumno(ArrayList<Alumnado> listaAlumnos) {
		boolean continuar = true;

		while (continuar) {
			System.out.print("\nNIF del alumno: ");
			String nif = Util2.introducirCadena();

			int ciclosMatriculados = contarCiclosMatriculados(nif, listaAlumnos);

			if (ciclosMatriculados == 2) {
				System.out.println("Alumno/a ya introducido en ambos ciclos");
			} else {
				System.out.print("Nombre: ");
				String nombre = Util2.introducirCadena();

				System.out.print("Fecha nacimiento (AAAA-MM-DD): ");
				LocalDate fecha = LocalDate.parse(Util2.introducirCadena());

				Ciclo ciclo = null;

				if (ciclosMatriculados == 1) {
					ciclo = obtenerCicloNoMatriculado(nif, listaAlumnos);
					System.out.println("El alumno ya está matriculado en un ciclo. Se matriculará en: " + ciclo);
				} else {
					System.out.print("Ciclo (DAM/DAW): ");
					ciclo = Ciclo.valueOf(Util2.introducirCadena().toUpperCase());
				}

				System.out.print("¿Es repetidor? SI(1) / NO(2): ");
				boolean repetidor;
				int rep = Util2.leerInt();
				if (rep == 1) {
					repetidor = true;
				} else {
					repetidor = false;
				}

				Alumnado nuevoAlumno = new Alumnado(nif, nombre, fecha, ciclo, repetidor);
				listaAlumnos.add(nuevoAlumno);

				System.out.println("Alumno matriculado correctamente");

				System.out.print("\n¿Desea matricular otro alumno? (S/N): ");
				String respuesta = Util2.introducirCadena().toUpperCase();

				if (!respuesta.equalsIgnoreCase("S")) {
					continuar = false;
				}
			}
		}
	}

	private static int contarCiclosMatriculados(String nif, ArrayList<Alumnado> listaAlumnos) {
		int contador = 0;
		for (Alumnado alumno : listaAlumnos) {
			if (alumno.getNif().equals(nif)) {
				contador++;
			}
		}
		return contador;
	}

	private static Ciclo obtenerCicloNoMatriculado(String nif, ArrayList<Alumnado> listaAlumnos) {
		for (Alumnado alumno : listaAlumnos) {
			if (alumno.getNif().equals(nif)) {
				return alumno.getCiclo() == Ciclo.DAM ? Ciclo.DAW : Ciclo.DAM;
			}
		}
		return null;
	}

	private static void mostrar(ArrayList<Alumnado> listaAlumnos) {
		System.out.println("\n--- LISTADO DE ALUMNOS ---");
		for (int i = 0; i < listaAlumnos.size(); i++) {
			System.out.println(listaAlumnos.get(i).toString());
		}
		System.out.println();
	}

	private static void mostrarPorNif(ArrayList<Alumnado> listaAlumnos) {
		System.out.print("\nIntroduce el NIF del alumno: ");
		String nif = Util2.introducirCadena();

		boolean encontrado = false;
		System.out.println("\n--- INFORMACIÓN DEL ALUMNO ---");
		for (Alumnado v : listaAlumnos) {
			if (v.getNif().equals(nif)) {
				System.out.println(v.toString());
				encontrado = true;
			}
		}

		if (!encontrado) {
			System.out.println("ERROR: No se encontró ningún alumno con el NIF: " + nif);
		}
		System.out.println();
	}

	private static void modificarDatosAlumno(ArrayList<Alumnado> listaAlumnos) {
		System.out.print("\nIntroduce el NIF del alumno a modificar: ");
		String nif = Util2.introducirCadena();

		boolean encontrado = false;
		for (Alumnado alumno : listaAlumnos) {
			if (alumno.getNif().equals(nif)) {
				encontrado = true;
				System.out.println("\nDatos actuales: " + alumno.toString());

				System.out.print("\nNuevo nombre (actual: " + alumno.getNombre() + "): ");
				String nuevoNombre = Util2.introducirCadena();
				alumno.setNombre(nuevoNombre);

				System.out.print("Nueva fecha de nacimiento AAAA-MM-DD (actual: " + alumno.getFechaNac() + "): ");
				LocalDate nuevaFecha = LocalDate.parse(Util2.introducirCadena());
				alumno.setFechaNac(nuevaFecha);

				System.out.print("¿Es repetidor? SI(1) / NO(2) (actual: " + alumno.isRepetidor() + "): ");
				int rep = Util2.leerInt();
				alumno.setRepetidor(rep == 1);

				System.out.println("\nDatos modificados correctamente");
				System.out.println("Nuevos datos: " + alumno.toString());
			}
		}

		if (!encontrado) {
			System.out.println("\nERROR: No se encontró ningún alumno con el NIF: " + nif);
		}
		System.out.println();
	}

	private static void modificarCampoRepetidor(ArrayList<Alumnado> listaAlumnos) {
		System.out.print("\nIntroduce la edad de los alumnos de DAW a modificar: ");
		int edad = Util2.leerInt();

		boolean encontrado = false;
		System.out.println("\nAlumnos de DAW con edad " + edad + ":");

		for (Alumnado alumno : listaAlumnos) {
			if (alumno.getCiclo() == Ciclo.DAW && alumno.calcularEdad() == edad) {
				encontrado = true;
				System.out.println(alumno.toString());

				System.out.print("¿Cambiar el estado de repetidor? SI(1) / NO(2): ");
				int rep = Util2.leerInt();
				alumno.setRepetidor(rep == 1);

				System.out.println("Estado actualizado: " + alumno.toString());
			}
		}

		if (!encontrado) {
			System.out.println(
					"ERROR: No se encontraron alumnos de DAW con edad " + edad);
		}
		System.out.println();
	}

	private static void darDeBaja(ArrayList<Alumnado> listaAlumnos) {
		System.out.print("\nIntroduce el NIF del alumno a dar de baja: ");
		String nif = Util2.introducirCadena();

		ArrayList<Alumnado> alumnosAEliminar = new ArrayList<>();

		for (Alumnado alumno : listaAlumnos) {
			if (alumno.getNif().equals(nif)) {
				alumnosAEliminar.add(alumno);
			}
		}

		if (alumnosAEliminar.isEmpty()) {
			System.out.println("\nERROR: No se encontró ningún alumno con el NIF: " + nif);
		} else {
			System.out.println("\n--- ALUMNOS A DAR DE BAJA ---");
			for (Alumnado alumno : alumnosAEliminar) {
				System.out.println(alumno.toString());
			}

			System.out.print("\n¿Confirmar la baja de " + alumnosAEliminar.size() + " registro(s)? (S/N): ");
			String confirmacion = Util2.introducirCadena().toUpperCase();

			if (confirmacion.equalsIgnoreCase("S")) {
				listaAlumnos.removeAll(alumnosAEliminar);
				System.out.println("\nAlumno(s) dado(s) de baja correctamente");
			} else {
				System.out.println("\nOperación cancelada");
			}
		}
		System.out.println();
	}
}