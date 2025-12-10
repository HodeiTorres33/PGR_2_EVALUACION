package clases;

import java.time.LocalDate;

public class Medicion {

    private LocalDate fecha;
    private float peso;

    public Medicion (LocalDate fecha, float peso) {
        this.fecha = fecha;
        this.peso = peso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public float getPeso() {
        return peso;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Medicion [fecha=" + fecha + ", peso=" + peso + "]";
    }
}
