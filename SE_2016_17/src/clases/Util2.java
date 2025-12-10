package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util2 {

	public static String introducirCadena(){
		 String cadena="";
		 InputStreamReader entrada =new InputStreamReader(System.in);
		 BufferedReader teclado= new BufferedReader(entrada);
		try {
			cadena=teclado.readLine();
		} catch (IOException e) {
			System.out.println("Error en la entrada de datos");
		}
		 return cadena;
	}

	
	public static char leerChar(){
		boolean error=false;
		String letra;
		
		do{
			error=false;
			letra=introducirCadena();
			if(letra.length()!=1){
				System.out.println("Error, introduce solo un carácter: ");
				error=true;
			}
			
		}while(error);
		return letra.charAt(0);
	}

	
	
	public static int leerInt(){
	    int num = 0;
	    boolean error;
	    do {
	        error = false;
	        try {
	            num = Integer.parseInt(introducirCadena());
	            if (num < 0) {
	                System.out.println("Error: no se permiten números negativos. Introduce un número positivo.");
	                error = true;
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Error al introducir el número. Introduce un número sin decimales.");
	            error = true;
	        }
	    } while (error);
	    return num;
	}

	public static float leerFloat(){
	    float num = 0;
	    boolean error;
	    do {
	        error = false;
	        try {
	            num = Float.parseFloat(introducirCadena());
	            if (num < 0) {
	                System.out.println("Error: no se permiten números negativos. Introduce un número positivo.");
	                error = true;
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Error al introducir el número. Introduce un número (puede llevar decimales, Ejemplo 5.3):");
	            error = true;
	        }
	    } while (error);
	    return num;
	}

	public static double leerDouble() {
	    double fNumero = 0;
	    boolean ok;
	    do {
	        ok = true;
	        try {
	            fNumero = Double.parseDouble(introducirCadena());
	            if (fNumero < 0) {
	                System.out.println("Error: no se permiten números negativos. Introduce un número positivo.");
	                ok = false;
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Error al introducir el número. Introduce un número (puede llevar decimales, Ejemplo 5.3):");
	            ok = false;
	        }
	    } while (!ok);
	    return fNumero;
	}

	public static String leerFecha(){
		String fecha = "";
		boolean error;
		do {
			error = false;
			fecha = introducirCadena();
			if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
				System.out.println("Error: introduce la fecha en formato DD/MM/YYYY");
				error = true;
			} else {
				String[] partes = fecha.split("/");
				int dia = Integer.parseInt(partes[0]);
				int mes = Integer.parseInt(partes[1]);
				int anio = Integer.parseInt(partes[2]);
				
				if (mes < 1 || mes > 12) {
					System.out.println("Error: el mes debe estar entre 01 y 12");
					error = true;
				} else if (dia < 1 || dia > 31) {
					System.out.println("Error: el día debe estar entre 01 y 31");
					error = true;
				} else if (anio < 1900 || anio > 2100) {
					System.out.println("Error: el año debe estar entre 1900 y 2100");
					error = true;
				}
			}
		} while (error);
		return fecha;
	}
	
		
}