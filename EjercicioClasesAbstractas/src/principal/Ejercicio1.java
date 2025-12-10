package principal;
import module.*;

public class PrincipalTransporte {

    public static void main(String[] args) {
        System.out.println("SISTEMA DE TRANSPORTE URBANO MULTIMODAL");
        
        AutobusElectrico autobus = new AutobusElectrico("BUS-001", 80, 45.0, 2.5);
        Tranvia tranvia = new Tranvia("TRAN-001", 120, 35.0, 3.0);
        BarcoTuristico barco = new BarcoTuristico("BOAT-001", 50, 20.0, 5.0);
        
        autobus.mostrarInformacion();
        tranvia.mostrarInformacion();
        barco.mostrarInformacion();
        
        System.out.println(" SIMULACIÓN DE RECORRIDO DE 10 KM");
        
        
        double distancia = 10.0;
        System.out.println("\nAutobús eléctrico: " + (autobus.calcularCostePorKm() * distancia) + "€");
        System.out.println("Tranvía: " + (tranvia.calcularCostePorKm() * distancia) + "€");
        System.out.println("Barco turístico: " + (barco.calcularCostePorKm() * distancia) + "€");
    }
}