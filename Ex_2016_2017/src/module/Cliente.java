package module;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Persona {
    private String codigo;
    private float altura;
    private ArrayList<Medicion> mediciones;

    public Cliente(String nombre, LocalDate fechaNacimiento, float altura) {
        super(nombre, fechaNacimiento);
        this.altura = altura;
        this.codigo = generarCodigo();
        this.mediciones = new ArrayList<>();
    }

    private String generarCodigo() {
        String letras = nombre.substring(0,2).toUpperCase();
        String anio = String.valueOf(fechaNacimiento.getYear()).substring(2);
        return letras + "-" + anio;
    }

    public void addMedicion(Medicion m) {
        mediciones.add(m);
    }

    public ArrayList<Medicion> getMediciones() {
        return mediciones;
    }

    public String getCodigo() {
        return codigo;
    }

    public float getAltura() {
        return altura;
    }

    public float getUltimoPeso() {
        if (mediciones.isEmpty()) return 0;
        return mediciones.get(mediciones.size()-1).getPeso();
    }

    public float calcularIMC() {
        try {
            return getUltimoPeso() / (altura * altura);
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}
