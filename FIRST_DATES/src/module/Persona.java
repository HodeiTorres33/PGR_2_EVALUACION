package module;

import java.time.LocalDate;
import java.time.Period;

public abstract class Persona {
	protected String dni;
	protected String nombre;
	protected LocalDate fechaNac;
	protected Genero genero;
	protected String localidad;
	
	public Persona(String dni, String nombre, LocalDate fechaNac, Genero genero, String localidad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.genero = genero;
		this.localidad = localidad;
	}
	public int calcularEdad() {
    return Period.between(this.fechaNac, LocalDate.now()).getYears();
}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
}
