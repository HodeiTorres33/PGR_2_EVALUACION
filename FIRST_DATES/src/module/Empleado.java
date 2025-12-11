package module;

import java.time.LocalDate;
import module.*;

public class Empleado extends Persona {

	private String cargo;
	private LocalDate fechaAlta;
	
	public Empleado(String dni, String nombre, LocalDate fechaNac, Genero genero, String localidad) {
		super(dni, nombre, fechaNac, genero, localidad);
	}
	
	public Empleado(String dni, String nombre, LocalDate fechaNac, Genero genero, String localidad, String cargo,
			LocalDate fechaAlta) {
		super(dni, nombre, fechaNac, genero, localidad);
		this.cargo = cargo;
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return "Empleado [cargo=" + cargo + ", fechaAlta=" + fechaAlta + "]";
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public LocalDate fechaHoy() {
		return this.fechaAlta = LocalDate.now();
	}

}
