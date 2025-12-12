package principal;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import excepcion.NivelAccesoTarjeta;
import module.Tarjeta;
import module.Util;

public class Principal {

	public static void main(String[] args) throws NivelAccesoTarjeta {
		// TODO Auto-generated method stub
		
		Map<String, Tarjeta> tarjetas = new TreeMap<>();
		
		System.out.println("     MENU     \n" + "1.- Registrar tarjetas RFID\n" +"2.- Verificar acceso\n" + "3.- Revocar una tarjeta\n"+"4.- Mostrar todas las tarjetas\n" +"5.-Salir");
		
		int opcion = Util.leerInt("Elige una opcion:");
		switch(opcion) {
		case 1:
			
			registrarTarjeta(tarjetas);
			break;
		case 2:
			
			break;	
		}
		
	}

	private static void registrarTarjeta(Map<String, Tarjeta> tarjetas) throws NivelAccesoTarjeta {
		// TODO Auto-generated method stub
		String codigo = Util.introducirCadena("Introduce el codigo de la tarjeta");
		
		Tarjeta tarjeta= tarjetas.get(codigo);
		if (tarjeta!=null) {
			System.out.println("Ya existe una tarjeta con el mismo codigo.");
			return;
		}
		/*for (Tarjeta t : tarjetas.values()) {
			if (codigo.equals(tarjetas.get(codigo))) {
				System.out.println("Ya existe una tarjeta con el mismo codigo.");
				return;
			}
		}*/
		
		String nombre = Util.introducirCadena("Introduce el nombre del empleado:");
		
		/*for (Tarjeta t: tarjetas.values()) {
			if (nombre.equals(t))
		}*/
		
		String departamento = Util.introducirCadena("Introduce el nombre del departamento");
		
		
		int nivelAcceso = Util.leerInt("Introduce el nivel de la tarjeta");
		try {
			Tarjeta nuevaTarjeta = new Tarjeta (codigo, nombre, departamento, nivelAcceso);
			tarjetas.put(codigo, nuevaTarjeta);
		} catch (NivelAccesoTarjeta e) {
			System.out.println("Error: " +e.getMessage());
		}
		
		
		}

}
