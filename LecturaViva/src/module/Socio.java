package module;

import java.time.LocalDate;

public class Socio extends Persona {

    public static final int CUOTA_BASE = 12;      
    public static final int LIMITE_LIBROS = 10;   
    public static final int DESCUENTO_ANTIGUEDAD = 2; 

    private final int mesAlta;    
    private final int anyoAlta;
    private int limiteLibrosPermitidos; 

    public Socio(String dni, String nombreCompleto, int mesAlta, int anyoAlta, int limiteLibrosPermitidos) {
        super(dni, nombreCompleto);
        this.mesAlta = mesAlta;
        this.anyoAlta = anyoAlta;
        this.limiteLibrosPermitidos = limiteLibrosPermitidos;
    }

    
    public int calcularAniosEnBiblioteca() {
        LocalDate hoy = LocalDate.now();
        int años = hoy.getYear() - this.anyoAlta;
        if (hoy.getMonthValue() < this.mesAlta) {
            años--;
        }
        return Math.max(años, 0);
    }

    
    public double calcularCuotaFinal() {
        double cuota = CUOTA_BASE;
        if (limiteLibrosPermitidos > 3) {
            cuota += (limiteLibrosPermitidos - 3);
        }
        if (calcularAniosEnBiblioteca() >= 8) {
            cuota -= DESCUENTO_ANTIGUEDAD;
        }
        if (cuota < 0) cuota = 0;
        return cuota;
    }

    public int getMesAlta() {
        return mesAlta;
    }

    public int getAnyoAlta() {
        return anyoAlta;
    }

    public int getLimiteLibrosPermitidos() {
        return limiteLibrosPermitidos;
    }

    public void setLimiteLibrosPermitidos(int limiteLibrosPermitidos) {
        this.limiteLibrosPermitidos = limiteLibrosPermitidos;
    }

    @Override
    public String toString() {
        return String.format(
            "Biblioteca: %s | DNI: %s | Nombre: %s | Alta: %02d/%d | Límite libros: %d | Cuota final: %.2f€",
            Persona.NOMBRE_BIBLIOTECA,
            getDni(),
            getNombreCompleto(),
            mesAlta,
            anyoAlta,
            limiteLibrosPermitidos,
            calcularCuotaFinal()
        );
    }
}
