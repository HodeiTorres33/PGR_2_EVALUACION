package principal;

import java.time.LocalDate;
import module.Cliente;
import module.Util2;


public class Principal {

	public static void main(String[] args) {
		
		System.out.println("========================================");
		System.out.println("  GIMNASIO TARTANGA - GESTIÓN CLIENTE  ");
		System.out.println("========================================\n");
		
		Cliente cliente1 = new Cliente("12345678A", "Jon Etxebarria", LocalDate.of(2024, 1, 15));
		
		cliente1.añadirEntrenamiento(LocalDate.of(2024, 11, 1), "Sentadillas", 50);
		cliente1.añadirEntrenamiento(LocalDate.of(2024, 11, 3), "Press de banca", 30);
		cliente1.añadirEntrenamiento(LocalDate.of(2024, 11, 5), "Dominadas", 15);
		
		System.out.println("1. VISUALIZACIÓN INICIAL DEL CLIENTE:");
		cliente1.visualizar();
		
		cliente1.modificarFechasEntrenamientos();
		
		System.out.println("2. VISUALIZACIÓN DESPUÉS DE MODIFICAR LAS FECHAS:");
		cliente1.visualizar();
		
		System.out.println("Proceso completado con éxito.");
	}
}