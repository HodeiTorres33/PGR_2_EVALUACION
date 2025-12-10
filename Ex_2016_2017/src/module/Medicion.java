package module;

import java.time.LocalDate;

public class Medicion {
    private LocalDate fecha;
    private float peso;

    public Medicion(LocalDate fecha, float peso) {
        this.fecha = fecha;
        this.peso = peso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public float getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return fecha.toString() + "   " + peso;
    }
}
