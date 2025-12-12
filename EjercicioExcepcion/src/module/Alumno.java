package module;

import exception.DniInvalidoException;
import exception.NotaFueraDeRango;

public class Alumno {
	
	private String nombre;
	private String dni;
	private int nota;
	
	public void validarNota(int nota) throws NotaFueraDeRango {
		
		if (nota <0 || nota >10) {
			throw new NotaFueraDeRango ("La nota esta fuera del rango determinado (0-10).");
		}
	}
	
	public boolean validarDni(String dni) throws DniInvalidoException {
	    
	    return dni != null && dni.matches("^[0-9]{8}[A-Za-z]$");
	    	
	    }

	public Alumno(String nombre, String dni, int nota) throws DniInvalidoException, NotaFueraDeRango {
		super();
		this.nombre = nombre;
		validarDni(dni);
		this.dni = dni;
		validarNota(nota);
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", dni=" + dni + ", notaMedia=" + nota + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
}
