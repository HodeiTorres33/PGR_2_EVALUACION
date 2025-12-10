package module;

public abstract class Transporte {
    protected String identificador;
    protected int capacidadMaxima;
    protected double velocidadMedia;
    
    public Transporte(String identificador, int capacidadMaxima, double velocidadMedia) {
        this.identificador = identificador;
        this.capacidadMaxima = capacidadMaxima;
        this.velocidadMedia = velocidadMedia;
    }
    
    // Método abstracto que cada tipo de transporte implementará
    public abstract double calcularCostePorKm();
    
    public void mostrarInformacion() {
        System.out.println("ID: " + identificador);
        System.out.println("Capacidad Máxima: " + capacidadMaxima + " personas");
        System.out.println("Velocidad Media: " + velocidadMedia + " km/h");
        System.out.println("Coste por km: " + calcularCostePorKm() + "€");
    }

    public String getIdentificador() {
        return identificador;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getVelocidadMedia() {
        return velocidadMedia;
    }
}