package principal;

import java.util.ArrayList;
import java.util.Scanner;

import module.Persona;
import module.Utilidades;

public class Principal {

	
	public static void main(String[] args) {
		
		
		String menu = "1.- Alta de cliente / empleado.\n"
				+ "2.- Lista de empleado.\n"
				+ "3.- Añadir medicion a cliente y ver evolucion. \n"
				+ "4.- Estadisticas.\n"
				+ "5.- Salir.\n"
				+ "INTRODUCE UNA OPCION:";
		
		int opcion = Utilidades.leerInt(menu);
		
		
		switch (opcion) {
		case 1: alta(); break;
		case 2: listadoEmpleado(); break;
		case 4: añadirMediciones(); break;
		case 5: estadisticas(); break;
		}
	}

	private static void estadisticas() {
		// TODO Auto-generated method stub
		
	}

	private static void añadirMediciones() {
		// TODO Auto-generated method stub
		
	}

	private static void listadoEmpleado() {
		// TODO Auto-generated method stub
		
	}

	private static void alta() {
		
	}

}
