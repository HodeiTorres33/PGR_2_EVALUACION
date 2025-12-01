package module;

public abstract class Persona {

    public static final String NOMBRE_BIBLIOTECA = "Lectura Viva";

    protected final String dni;
    protected String nombreCompleto;

    public Persona(String dni, String nombreCompleto) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
    }
    
    public abstract double calcularCuotaFinal();

    public String getDni() {
        return dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombreCompleto=" + nombreCompleto + "]";
    }
}
