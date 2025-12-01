package modelo;

public class Asignatura {
	
	private String nombre;
	private String curso;
	private int alumMatriculados;
	private int numSuspensos;
	
	public Asignatura() {
		
	}
	
	public double porcentajeAprobados() {
		double porcentajeAprobados = 0;
		if (numSuspensos <= alumMatriculados) {
			porcentajeAprobados = ((double)(alumMatriculados - numSuspensos) / alumMatriculados) * 100;
			return porcentajeAprobados;
		}
		return porcentajeAprobados;
	}
	
	public int obtenerNumeroAprobados() {
		int aprobados = 0;
		if (alumMatriculados > numSuspensos) {
			aprobados = alumMatriculados - numSuspensos;
		}
		return aprobados;
	}
	

	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", curso=" + curso + ", alumMatriculados=" + alumMatriculados
				+ ", numSuspensos=" + numSuspensos + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAlumMatriculados() {
		return alumMatriculados;
	}

	public void setAlumMatriculados(int alumMatriculados) {
		this.alumMatriculados = alumMatriculados;
	}

	public int getNumSuspensos() {
		return numSuspensos;
	}

	public void setNumSuspensos(int numSuspensos) {
		this.numSuspensos = numSuspensos;
	}
	
	
}
