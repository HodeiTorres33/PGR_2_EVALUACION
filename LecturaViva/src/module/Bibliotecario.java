package module;

public class Bibliotecario extends Socio {

    public static final int PLUS_BIBLIOTECARIO = 30;

    private String seccion;

    public Bibliotecario(String dni, String nombreCompleto, int mesAlta, int anyoAlta, int limiteLibrosPermitidos, String seccion) {
        super(dni, nombreCompleto, mesAlta, anyoAlta, limiteLibrosPermitidos);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    
    @Override
    public double calcularCuotaFinal() {
        return super.calcularCuotaFinal() + PLUS_BIBLIOTECARIO;
    }

    @Override
    public String toString() {
        return String.format("%s | Bibliotecario (Sección: %s) | Cuota final: %.2f€",
                super.toString(), seccion, calcularCuotaFinal());
    }
}
