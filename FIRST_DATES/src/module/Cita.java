package module;

import java.time.LocalDate;

public class Cita {

	private String dniPretendiente;
	private LocalDate fechaCita;
	private boolean resultadoCita;
	
	public void Cita() {
		
	}

	public Cita(String dniPretendiente, boolean resultadoCita) {
		super();
		this.dniPretendiente = dniPretendiente;
		this.resultadoCita = resultadoCita;
	}

	@Override
	public String toString() {
		return "Cita [dniPretendiente=" + dniPretendiente + ", resultadoCita=" + resultadoCita + "]";
	}

	public String getDniPretendiente() {
		return dniPretendiente;
	}

	public void setDniPretendiente(String dniPretendiente) {
		this.dniPretendiente = dniPretendiente;
	}

	public boolean isResultadoCita() {
		return resultadoCita;
	}

	public void setResultadoCita(boolean resultadoCita) {
		this.resultadoCita = resultadoCita;
	}
}
