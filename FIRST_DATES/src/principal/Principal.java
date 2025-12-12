package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import module.Cita;
import module.Empleado;
import module.Genero;
import module.Persona;
import module.Pretendiente;
import module.Util;
import module.Utilidades;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Persona> personas = new TreeMap<>();
		ArrayList<Cita> citas = new ArrayList<>();
		
	    int opcion;
			boolean opMenu = true;
			String menu = "1.- Introduce un nuevo Empleado o Pretendiente.\n" +"2.- Gestion Cita a un pretendiente\n"+ "3.- Listado citas exitosas\n" +"4.- Salir del programa";

			while (opMenu) {
				do {
					
					System.out.println(menu);
					opcion = Util.leerInt("Elige una opcion:\n");
					if (opcion > 4 || opcion < 1) {
						System.out.println("Tienes que introducir un numero del 1 al 5.\n");
					}
				} while (opcion > 4 || opcion < 1);

				switch (opcion) {
				case 1:
	                altaPersona(personas);
					break;
				case 2:
					gestionDeCitas(citas, personas);
					break;
				case 3:
					listarCitasExitosas(personas, citas);
					break;
				case 4:
					System.out.println("Saliendo del programa.");
					opMenu = false;
					break;
				}
			}
		
	}

	private static void listarCitasExitosas(Map<String,Persona> personas, ArrayList<Cita> citas) {
		try {
			System.out.println("LISTADO DE CITAS EXITOSAS");
			Map<String, Integer> contadorPorLocalidad = new TreeMap<>();
			for (Cita cita : citas) {
				if (cita.isResultadoCita()) {
					Persona p1 = personas.get(cita.getDniPretendiente1());
					if (p1 != null) {
						String localidad1 = p1.getLocalidad();

						Integer contador = contadorPorLocalidad.get(localidad1);
						if(contador == null) {
							contadorPorLocalidad.put(localidad1, 1);
						} else {
							contadorPorLocalidad.put(localidad1, contador +1);
						}
					}
					Persona p2 = personas.get(cita.getDniPretendiente2());
					if (p2 != null) {
						String localidad2 = p2.getLocalidad();

						Integer contador = contadorPorLocalidad.get(localidad2);
						if (contador == null) {
							contadorPorLocalidad.put(localidad2, 1);
						} else {
							contadorPorLocalidad.put(localidad2, contador +1);
						}
					}
				}

				if (contadorPorLocalidad.isEmpty()) {
					System.out.println("No hay citas exitosas registradas.");
					return;
				}

				System.out.println("LOCALIDAD CITAS EXITOSAS");

				for (Map.Entry<String, Integer> entry : contadorPorLocalidad.entrySet()) {
    				System.out.println("Localidad: " + entry.getKey() + " : " + entry.getValue());
				}

			}

			


		} catch (Exception e) {
			System.out.println("Erro al hacer la lista de citas:" +e.getMessage());
		}
	}

	private static void gestionDeCitas(ArrayList<Cita> citas, Map<String,Persona> personas) {
		try {
        System.out.println("GESTIÓN DE CITA");
        
        String dni = Utilidades.introducirCadena("Introduce el DNI del pretendiente:");
        
        Persona p = personas.get(dni);
        
        if (p == null) {
            System.out.println("No existe ninguna persona con ese DNI.");
            return;
        }
        
        if (!(p instanceof Pretendiente)) {
            System.out.println("Esa persona no es un pretendiente.");
            return;
        }
        
        Pretendiente pretendiente = (Pretendiente) p;
        
        mostrarInfoPretendiente(pretendiente);
        
        
        boolean salir = false;
        while (!salir) {
            System.out.println("\n SUBMENÚ ");
            System.out.println("1. Establecer nueva cita");
            System.out.println("2. Evaluar cita");
            System.out.println("3. Volver al menú principal");
            
            int opcion = Utilidades.leerInt("Elige una opción:");
            
            switch (opcion) {
                case 1:
                    establecerNuevaCita(pretendiente, personas, citas);
                    break;
                case 2:
                    evaluarCita(pretendiente);
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        
    } catch (Exception e) {
        System.out.println("Error inesperado: " + e.getMessage());
        e.printStackTrace();
    }
}

	private static void mostrarInfoPretendiente(Pretendiente pret) {
		System.out.println("INFORMACION DEL PRETENDIENTE");
		System.out.println("Nombre: " + pret.getNombre() +"\n"+ 
						"Edad" + pret.calcularEdad() + " años" +
						"Localidad: " + pret.getLocalidad() + "\n"+
						"Género: " + pret.getGenero()+"\n"+
						"Busca: " + pret.getGeneroBuscado()+"\n");
		
		
		System.out.println("CITAS ANTERIORES");
		if (pret.getColeccionCitas().isEmpty()) {
			System.out.println("No tiene citas registradas.");
		} else {
			for (Cita c : pret.getColeccionCitas()) {
				String otroDni = c.getDniPretendiente1().equals(pret.getDni()) ? c.getDniPretendiente2() : c.getDniPretendiente1();
				System.out.println("Fecha: " + c.getFechaCita() + " | DNI pareja: " + otroDni + " | Resultado: " + (c.isResultadoCita() ? "Exitosa" : "No exitosa"));
			}
		}
	}


	private static void establecerNuevaCita(Pretendiente solicitante, Map<String, Persona> personas, ArrayList<Cita> citas) {
		try {
			System.out.println("\n CREAR NUEVA CITA");
			
			System.out.println("\nPretendientes disponibles que coinciden con la busqueda:");
			ArrayList<Pretendiente> compatibles = new ArrayList<>();
			
			for (Persona p : personas.values()) {
				if (p instanceof Pretendiente) {
					Pretendiente pret = (Pretendiente) p;
					
					if (!pret.getDni().equals(solicitante.getDni()) && 
						pret.getGenero() == solicitante.getGeneroBuscado()) {
						compatibles.add(pret);
						System.out.println("DNI: " + pret.getDni() + " | Nombre: " + pret.getNombre() + 
										" | Edad: " + pret.calcularEdad() + " | Localidad: " + pret.getLocalidad());
					}
				}
			}
			
			if (compatibles.isEmpty()) {
				System.out.println("No hay pretendientes compatibles disponibles.");
				return;
			}
			
			String dniElegido = Utilidades.introducirCadena("\nIntroduce el DNI del pretendiente con quien deseas la cita:");
			
			Pretendiente elegido = null;
			for (Pretendiente pret : compatibles) {
				if (pret.getDni().equals(dniElegido)) {
					elegido = pret;
					break;
				}
			}
			
			if (elegido == null) {
				System.out.println("El DNI introducido no está en la lista de pretendientes compatibles.");
				return;
			}
			
			System.out.println("Introduce la fecha de la cita (dd/mm/yyyy):");
			LocalDate fechaCita = Util.leerFechaDMA();
			
			int idCita = citas.size() + 1;
			Cita nuevaCita = new Cita(idCita, solicitante.getDni(), elegido.getDni(), fechaCita, false);
			
			citas.add(nuevaCita);
			
			solicitante.getColeccionCitas().add(nuevaCita);
			elegido.getColeccionCitas().add(nuevaCita);
			
			System.out.println("La cita se ha creado correctamente con ID: " + idCita);
			System.out.println(" Entre: " + solicitante.getNombre() + " y " + elegido.getNombre());
			System.out.println(" Fecha: " + fechaCita);
			
		} catch (Exception e) {
			System.out.println("Error al configurar la cita: " + e.getMessage());
		}
	}


	private static void evaluarCita(Pretendiente pretendiente) {
		try {
			System.out.println("\n EVALUAR CITA");
			
			if (pretendiente.getColeccionCitas().isEmpty()) {
				System.out.println("Este pretendiente no tiene citas registradas.");
				return;
			}
			
		
			System.out.println("Introduce la fecha de la cita a evaluar (dd/mm/yyyy):");
			LocalDate fechaBuscada = Util.leerFechaDMA();
			
			
			Cita citaEncontrada = null;
			for (Cita c : pretendiente.getColeccionCitas()) {
				if (c.getFechaCita().equals(fechaBuscada)) {
					citaEncontrada = c;
					break;
				}
			}
			
			if (citaEncontrada == null) {
				System.out.println("No existe ninguna cita en esa fecha.");
				return;
			}
			
			int resultado = Util.leerInt("¿Fue exitosa la cita? (1=Sí, 2=No):");
			
			while (resultado != 1 && resultado != 2) {
				System.out.println("Opción inválida. Introduce 1 o 2.");
				resultado = Util.leerInt("¿Fue exitosa la cita? (1=Sí, 2=No):");
			}
			
			boolean exitosa = (resultado == 1);
			
			citaEncontrada.setResultadoCita(exitosa);
			
			System.out.println("La cita se ha evuluado sin problemas.");
			System.out.println("  Resultado: " + (exitosa ? "Exitosa" : "No exitosa"));
			
		} catch (Exception e) {
			System.out.println("Error al evaluar la cita: " + e.getMessage());
		}
	}

	

	private static void altaPersona(Map<String,Persona> personas) {

		Genero g;
		Empleado e;
		
		boolean dniExiste = false;
		System.out.println("ALTA A PERSONAS");
		int tipo = Util.leerInt("1.- EMPLEADO\n" + "2.- PRETENDIENTE");
		
		String dni = Util.introducirCadena("Introduce el DNI de la persona:");
		
		
		for (Persona p: personas.values()) {
			if (p.getDni().equals(dni)) {
				dniExiste = true;
			}
		}
		
		if (dniExiste) {
			System.out.println("Ya se ha registrado una persona con ese dni.");
			
			return;
		}
		
		String nombre = Utilidades.introducirCadena("Introducir el nombre");
			System.out.println("Introduce la fecha de nacimiento (dd/mm/yyyy):");
			LocalDate fechaNac = Util.leerFechaDMA();
			String genero = Util.introducirCadena("Introduce el genero (Mujer, Hombre, Otro):");
			while (genero.equals("Hombre") &&!genero.equals("Mujer") &&!genero.equals("Otro")) {
				System.out.println("Tiene que ser Hombre, Mujer u Otro.");
				genero = Util.introducirCadena();
			}
			
			if (genero.equals("Hombre")) {
				g = Genero.Hombre;
			} else if (genero.equals("Mujer")) {
				g = Genero.Mujer;
			} else {
				g = Genero.Otro;
			}

			String localidad = Util.introducirCadena("Introduce tu localidad:");

		if (tipo == 1) {
			
			String cargo = Util.introducirCadena("Introduce el cargo del empleado:");
			
			LocalDate fechaAlta = LocalDate.now();

			Empleado nuevoEmpleado = new Empleado (dni, nombre, fechaNac, g, localidad, cargo, fechaAlta);

			personas.put(dni,nuevoEmpleado);
			
		} else if (tipo == 2) {
			
			Genero gB = null;
			String generoABuscar = Utilidades.introducirCadena("Introduce el genero que esta buscando (Mujer, Hombre, Otro):");
			while (!generoABuscar.equals("Hombre") && !generoABuscar.equals("Mujer") && !generoABuscar.equals("Otro")) {
   				System.out.println("Tiene que ser Hombre, Mujer u Otro.");
    			generoABuscar = Util.introducirCadena("Introduce el genero que esta buscando (Mujer, Hombre, Otro):");
}
			if (generoABuscar.equals("Hombre")) {
				gB = Genero.Hombre;
			} else if (generoABuscar.equals("Mujer")) {
				gB = Genero.Mujer;
			} else {
				gB = Genero.Otro;
			}

			Pretendiente nuevoPretendiente = new Pretendiente (dni, nombre, fechaNac, g, localidad, gB, new ArrayList());

			personas.put(dni, nuevoPretendiente);

		}
		
		
	}

}
