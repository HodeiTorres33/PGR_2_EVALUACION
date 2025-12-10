package principal;

import java.util.ArrayList;
import module.*;

public class Principal {

    private static LigaSports liga = new LigaSports();

    public static void main(String[] args) {
        
        boolean salir = false;
        
        while (!salir) {
            mostrarMenu();
            System.out.print("\nELIGE UNA OPCIÓN: ");
            int opcion = Util2.leerInt();
            System.out.println();
            
            switch (opcion) {
                case 1:
                    añadirCompetidor();
                    break;
                case 2:
                    listarCompetidores();
                    break;
                case 3:
                    actualizarCompetidor();
                    break;
                case 4:
                    eliminarCompetidor();
                    break;
                case 5:
                    eliminarVariosCompetidores();
                    break;
                case 6:
                    registrarPartidas();
                    break;
                case 7:
                    listarPartidas();
                    break;
                case 8:
                    actualizarPartidas();
                    break;
                case 9:
                    eliminarRegistroPartidas();
                    break;
                case 10:
                    compararRegistros();
                    break;
                case 11:
                    pruebaCompleta();
                    break;
                case 12:
                    salir = true;
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
            
            if (!salir) {
                System.out.println("\nPresiona Enter para continuar...");
                Util2.introducirCadena();
            }
        }
    }
    
    private static void mostrarMenu() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║     GESTIÓN LIGA ESPORTS              ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║  GESTIÓN DE COMPETIDORES              ║");
        System.out.println("║  1. Añadir competidor                 ║");
        System.out.println("║  2. Listar competidores               ║");
        System.out.println("║  3. Actualizar competidor             ║");
        System.out.println("║  4. Eliminar competidor               ║");
        System.out.println("║  5. Eliminar varios competidores      ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║  GESTIÓN DE PARTIDAS                  ║");
        System.out.println("║  6. Registrar partidas ganadas        ║");
        System.out.println("║  7. Listar partidas ganadas           ║");
        System.out.println("║  8. Actualizar partidas               ║");
        System.out.println("║  9. Eliminar registro de partidas     ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║  10. Comparar registros (Iterator)    ║");
        System.out.println("║  11. Ejecutar prueba completa         ║");
        System.out.println("║  12. Salir                            ║");
        System.out.println("╚═══════════════════════════════════════╝");
    }
    
    
    private static void añadirCompetidor() {
        System.out.print("Introduce el nombre del competidor: ");
        String nombre = Util2.introducirCadena();
        liga.añadirCompetidor(nombre);
    }
    
    private static void listarCompetidores() {
        liga.listarCompetidores();
    }
    
    private static void actualizarCompetidor() {
        System.out.print("Introduce el nombre actual del competidor: ");
        String antiguo = Util2.introducirCadena();
        System.out.print("Introduce el nuevo nombre: ");
        String nuevo = Util2.introducirCadena();
        liga.actualizarCompetidor(antiguo, nuevo);
    }
    
    private static void eliminarCompetidor() {
        System.out.print("Introduce el nombre del competidor a eliminar: ");
        String nombre = Util2.introducirCadena();
        liga.eliminarCompetidor(nombre);
    }
    
    private static void eliminarVariosCompetidores() {
        System.out.print("¿Cuántos competidores quieres eliminar? ");
        int cantidad = Util2.leerInt();
        
        ArrayList<String> nombres = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Nombre " + (i + 1) + ": ");
            nombres.add(Util2.introducirCadena());
        }
        
        liga.eliminarCompetidores(nombres);
    }
    
    
    private static void registrarPartidas() {
        System.out.print("Introduce el nombre del competidor: ");
        String competidor = Util2.introducirCadena();
        System.out.print("Introduce el número de partidas ganadas: ");
        int partidas = Util2.leerInt();
        liga.registrarPartidas(competidor, partidas);
    }
    
    private static void listarPartidas() {
        liga.listarPartidas();
    }
    
    private static void actualizarPartidas() {
        System.out.print("Introduce el nombre del competidor: ");
        String competidor = Util2.introducirCadena();
        System.out.print("Introduce el nuevo número de partidas: ");
        int partidas = Util2.leerInt();
        liga.actualizarPartidas(competidor, partidas);
    }
    
    private static void eliminarRegistroPartidas() {
        System.out.print("Introduce el nombre del competidor: ");
        String competidor = Util2.introducirCadena();
        liga.eliminarRegistro(competidor);
    }
    
    
    private static void compararRegistros() {
        boolean resultado = liga.compararRegistros();
        System.out.println("\nResultado: " + resultado);
    }
    
    
    private static void pruebaCompleta() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║    EJECUTANDO PRUEBA COMPLETA         ║");
        System.out.println("╚════════════════════════════════════════╝\n");
        
        System.out.println("--- 1. Añadiendo competidores ---");
        liga.añadirCompetidor("Faker");
        liga.añadirCompetidor("Caps");
        liga.añadirCompetidor("Perkz");
        liga.añadirCompetidor("Rekkles");
        liga.añadirCompetidor("TheShy");
        
        System.out.println("\n--- 2. Listando competidores ---");
        liga.listarCompetidores();
        
        System.out.println("\n--- 3. Registrando partidas ---");
        liga.registrarPartidas("Faker", 150);
        liga.registrarPartidas("Caps", 120);
        liga.registrarPartidas("Perkz", 95);
        
        System.out.println("\n--- 4. Listando partidas ---");
        liga.listarPartidas();
        
        System.out.println("\n--- 5. Comparando registros (debe ser FALSE) ---");
        boolean resultado1 = liga.compararRegistros();
        System.out.println("Resultado: " + resultado1);
        
        System.out.println("\n--- 6. Completando registros ---");
        liga.registrarPartidas("Rekkles", 80);
        liga.registrarPartidas("TheShy", 110);
        
        System.out.println("\n--- 7. Comparando registros (debe ser TRUE) ---");
        boolean resultado2 = liga.compararRegistros();
        System.out.println("Resultado: " + resultado2);
        
        System.out.println("\n--- 8. Actualizando competidor ---");
        liga.actualizarCompetidor("Faker", "Faker T1");
        
        System.out.println("\n--- 9. Actualizando partidas ---");
        liga.actualizarPartidas("Caps", 135);
        
        System.out.println("\n--- 10. Eliminando varios competidores ---");
        ArrayList<String> aEliminar = new ArrayList<>();
        aEliminar.add("Perkz");
        aEliminar.add("Rekkles");
        liga.eliminarCompetidores(aEliminar);
        
        System.out.println("\n--- 11. Estado final ---");
        liga.listarCompetidores();
        liga.listarPartidas();
        
        System.out.println("\n✓ Prueba completa finalizada con éxito");
    }
}