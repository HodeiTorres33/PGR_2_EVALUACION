package module;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cliente extends Persona {
	
	private LocalDate fechaAlta;
	private HashMap<String, Entrenamiento> entrenamientos;
	private static int contadorWOD = 100; // Contador para generar códigos WOD
	
	public Cliente() {
		entrenamientos = new HashMap<>();
	}
	
	public Cliente(String dni, String nombre, LocalDate fechaAlta) {
		super(dni, nombre);
		this.fechaAlta = fechaAlta;
		this.entrenamientos = new HashMap<>();
	}
	
	public void añadirEntrenamiento(LocalDate fecha, String nombre, int repeticiones) {
		String codigo = "WOD-" + contadorWOD;
		contadorWOD++;
		Entrenamiento entrenamiento = new Entrenamiento(codigo, fecha, nombre, repeticiones);
		entrenamientos.put(codigo, entrenamiento);
	}

	@Override
	public void visualizar() {
		System.out.println("\n=== CLIENTE ===");
		System.out.println("DNI: " + dni);
		System.out.println("Nombre: " + nombre);
		System.out.println("Fecha de Alta: " + fechaAlta);
		System.out.println("\n--- ENTRENAMIENTOS ---");
		if (entrenamientos.isEmpty()) {
			System.out.println("No hay entrenamientos registrados.");
		} else {
			for (Map.Entry<String, Entrenamiento> entry : entrenamientos.entrySet()) {
				System.out.println(entry.getValue());
			}
		}
		System.out.println("=================\n");
	}
	
	public void modificarFechasEntrenamientos() {
		System.out.println("Modificando fechas de entrenamientos (añadiendo 1 día)...\n");
		Iterator<Map.Entry<String, Entrenamiento>> iterator = entrenamientos.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Map.Entry<String, Entrenamiento> entry = iterator.next();
			Entrenamiento entrenamiento = entry.getValue();
			entrenamiento.setFecha(entrenamiento.getFecha().plusDays(1));
		}
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public HashMap<String, Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}

	public void setEntrenamientos(HashMap<String, Entrenamiento> entrenamientos) {
		this.entrenamientos = entrenamientos;
	}
}