package module;

import java.util.Map;

public class Trabajador extends Persona {
	
	private String usuario;
	private String contraseña;
	private Cargo cargo;
	
	public Trabajador() {
		
	}

	@Override
	public String toString() {
		return "Trabajador [usuario=" + usuario + ", contraseña=" + contraseña + ", cargo=" + cargo + "]";
	}
	
	@Override
	public void visualizar() {
	
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
