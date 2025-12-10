package module;

import java.time.LocalDate;

public class Empleado extends Persona {
    private LocalDate fechaAlta;

    public Empleado(String nombre, LocalDate fechaNacimiento, LocalDate fechaAlta) {
        super(nombre, fechaNacimiento);
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
}
