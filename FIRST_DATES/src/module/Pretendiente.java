package module;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pretendiente extends Persona {

	private Genero generoBuscado;
	private ArrayList<String> coleccionCitas = new ArrayList<>();
	
	public void Pretendiente() {
		
	}

	public Pretendiente(String dni, String nombre, LocalDate fechaNac, Genero genero, String localidad,
			Genero generoBuscado, ArrayList<String> coleccionCitas) {
		super(dni, nombre, fechaNac, genero, localidad);
		this.generoBuscado = generoBuscado;
		this.coleccionCitas = coleccionCitas;
	}

	@Override
	public String toString() {
		return "Pretendiente [generoBuscado=" + generoBuscado + ", coleccionCitas=" + coleccionCitas + "]";
	}

	public ArrayList<String> getColeccionCitas() {
		return coleccionCitas;
	}

	public void setColeccionCitas(ArrayList<String> coleccionCitas) {
		this.coleccionCitas = coleccionCitas;
	}

	public Genero getGeneroBuscado() {
		return generoBuscado;
	}

	public void setGeneroBuscado(Genero generoBuscado) {
		this.generoBuscado = generoBuscado;
	}

	
}
