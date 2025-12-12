package module;

import java.time.LocalDate;

public class Cita {

	private int idCita;
	private String dniPretendiente1;
	private String dniPretendiente2;
	private LocalDate fechaCita;
	private boolean resultadoCita;
	
	public Cita() {
		
	}	

	public Cita(int idCita, String dniPretendiente1, String dniPretendiente2, LocalDate fechaCita,
			boolean resultadoCita) {
		this.idCita = idCita;
		this.dniPretendiente1 = dniPretendiente1;
		this.dniPretendiente2 = dniPretendiente2;
		this.fechaCita = fechaCita;
		this.resultadoCita = resultadoCita;
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", dniPretendiente1=" + dniPretendiente1 + ", dniPretendiente2="
				+ dniPretendiente2 + ", fechaCita=" + fechaCita + ", resultadoCita=" + resultadoCita + "]";
	}

	public boolean isResultadoCita() {
		return resultadoCita;
	}

	public void setResultadoCita(boolean resultadoCita) {
		this.resultadoCita = resultadoCita;
	}

    public int getIdCita() {
        return idCita;
    }

    public String getDniPretendiente1() {
        return dniPretendiente1;
    }

    public String getDniPretendiente2() {
        return dniPretendiente2;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public void setDniPretendiente1(String dniPretendiente1) {
        this.dniPretendiente1 = dniPretendiente1;
    }

    public void setDniPretendiente2(String dniPretendiente2) {
        this.dniPretendiente2 = dniPretendiente2;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }
}
