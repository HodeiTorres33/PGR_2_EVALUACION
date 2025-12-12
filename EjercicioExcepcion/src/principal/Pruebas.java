package principal;

import exception.DniInvalidoException;
import exception.NotaFueraDeRango;
import module.Alumno;
import module.Util;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno a = null;
		String nombre = Util.introducirCadena("Introduce el nombre:");
		
		try {
			String dni = Util.introducirCadena("Introduce el dni:");
			throw new DniInvalidoException("El dni introducido no es válido.");
		} catch (DniInvalidoException e) {
			System.out.println("Error: " +e.getMessage());
			
		}
		
		try {
			int nota = Util.leerInt("Introduce la nota:");
			System.out.println("Nota valida:" +nota);
			throw new NotaFueraDeRango ("La nota esta fuera del rango determinado (0-10).");
		} catch (NotaFueraDeRango e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println(a.toString());
	}
	
	
	
	
	
	

}
