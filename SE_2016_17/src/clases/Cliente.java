package clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Persona {

    private String codigo;
    private float altura;
    private ArrayList<Medicion> mediciones;

    public Cliente(String nombre, LocalDate fechaNacimiento, String codigo, float altura) {
        super(nombre, fechaNacimiento);
        this.codigo = generarCodigo();
        this.altura = altura;
        this.mediciones = new ArrayList<>();
    }

    private String generarCodigo() {
        String prefijo = nombre.substring(0,Math.min(2, nombre.length())).toUpperCase();
        String año = String.valueOf(fechaNacimiento.getYear()).substring(2);
        return prefijo +"-" +año;
    }

    public void agregarMedicion(Medicion medicion) {
        mediciones.add(medicion);
    }

    public float calcularIMC() throws ArithmeticException {
        if (mediciones.isEmpty()) {
            return -1;
        }

        if (altura <= 0){
            throw new ArithmeticException("La altura debe ser mayor que cero para calcular el IMC.");
        }

        float ultimoPeso = mediciones.get(mediciones.size()-1).getPeso();
        return ultimoPeso / (altura * altura);
    }

    public static String obtenerClasificacioneIMC(float imc) {
        if (imc <16.00) {
            return "infrapeso: Delgadez Severa";
        } else if (imc >=16.00 && imc <16.99) {
            return "infrapeso: Delgadez Moderada";
        } else if (imc >=17.00 && imc <18.49) {
            return "infrapeso: Delgadez Aceptable";
        } else if (imc >=18.50 && imc <24.99) {
            return "peso Normal";
        } else if (imc >=25.00 && imc <29.99) {
            return "sobrepeso";
        } else if (imc >=30.00 && imc <34.99) {
            return "obesidad: Tipo I";
        } else if (imc >=35.00 && imc <39.99) {
            return "obesidad: Tipo II";
        } else {
            return "obesidad: Tipo III";
        }
    }

    public float calcularEvolucion() {
        if (mediciones.size() < 2) {
            return 0;
        }
        float primerPeso = mediciones.get(0).getPeso();
        float ultimoPeso = mediciones.get(mediciones.size() -1).getPeso();
        return ultimoPeso - primerPeso;
    }

    public void mostrarMediciones() {
        System.out.println("Historial de mediciones de " +nombre + ":");
        for (int i = 0; i < mediciones.size(); i++) {
            System.out.println((i+1) + ". " + mediciones.get(i));
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getAltura() {
        return altura;
    }

    public ArrayList<Medicion> getMediciones() {
        return mediciones;
    }

    @Override
    public String toString()  {
        String info = super.toString() + ", Codigo: " + codigo;
        try {
            float imc = calcularIMC();
            if (imc != 1) {
                info += String.format(", IMC: %.2f (%s)", imc, obtenerClasificacioneIMC(imc));
            }
        } catch (ArithmeticException e) {
            info += "IMC: Error (altura cero)";
         }
         return info;
    }

    
}
