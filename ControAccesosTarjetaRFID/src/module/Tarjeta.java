package module;

import excepcion.NivelAccesoTarjeta;

public class Tarjeta  {

	private String codigo;
	private String nombre;
	private String departamento;
	private int nivelAcceso;
	
	/*  ESTO ES UN METODO PARA EL MAIN Y QUE FUNCIONA LA EXCEPCION  */
	public void NivelAccesoTarjeta (int nivelAcceso) throws NivelAccesoTarjeta {
		if (nivelAcceso < 1 || nivelAcceso > 5) {
			throw new NivelAccesoTarjeta ("El nivel de acceso de la tarjeta no esta bien definido.");
		}
	}
	
	public Tarjeta(String codigo, String nombre, String departamento, int nivelAcceso) throws NivelAccesoTarjeta {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.departamento = departamento;
		this.nivelAcceso = nivelAcceso;
		NivelAccesoTarjeta(nivelAcceso);
	}
	@Override
	public String toString() {
		return "Tarjeta [codigo=" + codigo + ", nombre=" + nombre + ", departamento=" + departamento + ", nivelAcceso="
				+ nivelAcceso + "]";
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public int getNivelAcceso() {
		return nivelAcceso;
	}
	public void setNivelAcceso(int nivelAcceso) {
		this.nivelAcceso = nivelAcceso;
	}
	
	
	
	
}
