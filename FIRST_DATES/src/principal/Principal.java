package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import module.Cita;
import module.Empleado;
import module.Genero;
import module.Persona;
import module.Util;
import module.Utilidades;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Persona> personas = new TreeMap<>();
		ArrayList<Cita> cita = new ArrayList<>();
		
	    int opcion;
			boolean opMenu = true;
			String menu = "1.- Introduce un nuevo Empleado o Pretendiente.\n" +"2.- Gestion Cita a un pretendiente\n"+ "3.- Listado citas exitosas\n" +"4.- Salir del programa";

			while (opMenu) {
				do {
					
					System.out.println(menu);
					opcion = Utilidades.leerInt("Elige una opcion:\n");
					if (opcion > 4 || opcion < 1) {
						System.out.println("Tienes que introducir un numero del 1 al 5.\n");
					}
				} while (opcion > 4 || opcion < 1);

				switch (opcion) {
				case 1:
	                altaPersona(personas);
					break;
				case 2:
					
					break;
				case 3:
					break;
				case 4:
					System.out.println("Saliendo del programa.");
					opMenu = false;
					break;
				}
			}
		
	}

	private static void altaPersona(Map<String,Persona> personas) {

		Genero g;
		
		boolean dniExiste = false;
		System.out.println("ALTA A PERSONAS");
		int tipo = Util.leerInt("1.- EMPLEADO\n" + "2.- PRETENDIENTE");
		
		String dni = Utilidades.introducirCadena("Introduce el DNI de la persona:");
		
		
		for (Persona p: personas.values()) {
			if (p.getDni().equals(dni)) {
				dniExiste = true;
			}
		}
		
		if (dniExiste) {
			System.out.println("Ya se ha registrado una person con ese dni.");
			return;
		}
		
		if (tipo == 1) {
			String nombre = Utilidades.introducirCadena("Introducir el nombre");
			System.out.println("Introduce la fecha de nacimiento (dd/mm/yyyy):");
			LocalDate fechaNac = Util.leerFechaDMA();
			String genero = Util.introducirCadena("Introduce el genero (Hombre o Mujer):");
			while (genero.equals("Hombre") &&!genero.equals("Mujer")) {
				System.out.println("Tiene que ser hombre o mujer.");
				genero = Util.introducirCadena();
			}
			
			if (genero.equals("Hombre")) {
				g = Genero.Hombre;
			} else if (genero.equals("Mujer")) {
				g = Genero.Mujer;
			}
			
			String localidad = Util.introducirCadena("Introduce tu localidad:");
			
			String cargo = Util.introducirCadena("Introduce el cargo del empleado:");
			
			LocalDate fechaAlta = e.fechaHoy();
			
		}
		
		
	}
	
	

}
