package ejercicio3;

public class PrincipalJuego {

    public static void main(String[] args) {
        System.out.println("SIMULACIÓN DE JUEGO DE ESTRATEGIA");
        
        // Crear unidades
        SoldadoTerrestre soldado = new SoldadoTerrestre("Soldado Raso", 100, 25, 10);
        Tanque tanque = new Tanque("Tanque Pesado", 200, 40, 25);
        Helicoptero helicoptero = new Helicoptero("Apache", 150, 35, 5);
        DragonVolador dragon = new DragonVolador("Fénix Rojo", 300, 50, 15);
        
        // Mostrar información inicial
        System.out.println("\n═══ UNIDADES CREADAS ═══");
        soldado.mostrarInformacion();
        tanque.mostrarInformacion();
        helicoptero.mostrarInformacion();
        dragon.mostrarInformacion();
        
        System.out.println("BATALLA 1: Soldado vs Tanque");
        soldado.atacar(tanque);
        tanque.atacar(soldado);
        
        System.out.println("BATALLA 2: Tanque - Modo Asedio");
        tanque.usarHabilidad(soldado);
        
        System.out.println("BATALLA 3: Helicóptero vs Dragón");
        helicoptero.atacar(dragon);
        dragon.atacar(helicoptero);
        
        System.out.println("BATALLA 4: Dragón - Aliento de Fuego");
        dragon.usarHabilidad(helicoptero);
        
        System.out.println("BATALLA 5: Helicóptero - Disparo Misil");
        if (helicoptero.estaViva()) {
            helicoptero.usarHabilidad(dragon);
        }
        
        System.out.println("BATALLA FINAL: Dragón vs Tanque");
        dragon.atacar(tanque);
        if (tanque.estaViva()) {
            tanque.usarHabilidad(dragon);
        }
        
        System.out.println("RESUMEN FINAL");
        System.out.println("\n" + soldado.getNombre() + ": " + 
            (soldado.estaViva() ? "Vivo  (Vida: " + soldado.getVida() + ")" : "Muerto "));
        System.out.println(tanque.getNombre() + ": " + 
            (tanque.estaViva() ? "Operativo  (Vida: " + tanque.getVida() + ")" : "Destruido "));
        System.out.println(helicoptero.getNombre() + ": " + 
            (helicoptero.estaViva() ? "En vuelo  (Vida: " + helicoptero.getVida() + ")" : "Derribado "));
        System.out.println(dragon.getNombre() + ": " + 
            (dragon.estaViva() ? "Volando  (Vida: " + dragon.getVida() + ")" : "Abatido "));
    }
}