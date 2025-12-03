package module;

import java.time.LocalDate;

public class Entrenamiento {
	private String cod;
	private LocalDate fecha;
	private String nombre;
	private int repeticiones;
	
	public Entrenamiento() {
		this.fecha = LocalDate.now();
	}
	
	public Entrenamiento(String cod, LocalDate fecha, String nombre, int repeticiones) {
		this.cod = cod;
		this.fecha = fecha;
		this.nombre = nombre;
		this.repeticiones = repeticiones;
	}

	@Override
	public String toString() {
		return "Entrenamiento [cod=" + cod + ", fecha=" + fecha + ", nombre=" + nombre + ", repeticiones="
				+ repeticiones + "]";
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}
}