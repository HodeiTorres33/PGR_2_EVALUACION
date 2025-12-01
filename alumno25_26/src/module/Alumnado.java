package module;
import java.time.LocalDate;
import java.time.Period;

public class Alumnado {

    private String nif;
    private String nombre;
    private LocalDate fechaNac;
    private Ciclo ciclo;
    private boolean repetidor;

    public Alumnado() {
    }

    public Alumnado(String nif, String nombre, LocalDate fechaNac, Ciclo ciclo, boolean repetidor) {
        this.nif = nif;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.ciclo = ciclo; 
        this.repetidor = repetidor;
    }

    @Override
    public String toString() {
        return "Alumnado [nif=" + nif + ", nombre=" + nombre + ", fechaNac=" + fechaNac + 
               ", edad=" + calcularEdad() + ", ciclo=" + ciclo + ", repetidor=" + repetidor + "]";
    }

    public int calcularEdad() {
        return Period.between(fechaNac, LocalDate.now()).getYears();
    }

    // Getters y Setters
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isRepetidor() {
        return repetidor;
    }

    public void setRepetidor(boolean repetidor) {
        this.repetidor = repetidor;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
}