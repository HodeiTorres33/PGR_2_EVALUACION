package module;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pretendiente extends Persona {

	private Genero generoBuscado;
	public ArrayList<Cita> coleccionCitas = new ArrayList<>();

	public Pretendiente(String dni, String nombre, LocalDate fechaNac, Genero genero, String localidad) {
		super(dni, nombre, fechaNac, genero, localidad);
	}
	

	public Pretendiente(String dni, String nombre, LocalDate fechaNac, Genero genero, String localidad,
			Genero generoBuscado, ArrayList<Cita> coleccionCitas) {
		super(dni, nombre, fechaNac, genero, localidad);
		this.generoBuscado = generoBuscado;
		this.coleccionCitas = coleccionCitas;
	}

	@Override
	public String toString() {
		return "Pretendiente [generoBuscado=" + generoBuscado + ", coleccionCitas=" + coleccionCitas + "]";
	}

	public ArrayList<Cita> getColeccionCitas() {
		return coleccionCitas;
	}

	public void setColeccionCitas(ArrayList<Cita> coleccionCitas) {
		this.coleccionCitas = coleccionCitas;
	}

	public Genero getGeneroBuscado() {
		return generoBuscado;
	}

	public void setGeneroBuscado(Genero generoBuscado) {
		this.generoBuscado = generoBuscado;
	}

	
}
