package ejercicio2;

import java.time.LocalDate;

public class PrincipalBiblioteca {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║     SISTEMA DE BIBLIOTECAS DIGITALES          ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        
        // Crear recursos digitales
        Ebook ebook = new Ebook(
            "Cien años de soledad",
            "Gabriel García Márquez",
            LocalDate.of(1967, 5, 30),
            417,
            "EPUB"
        );
        
        Audiolibro audiolibro = new Audiolibro(
            "El Quijote",
            "Miguel de Cervantes",
            LocalDate.of(1605, 1, 16),
            2340,
            "Juan Pérez"
        );
        
        VideoEducativo video = new VideoEducativo(
            "Introducción a la Programación en Java",
            "Universidad Tecnológica",
            LocalDate.of(2023, 9, 15),
            120,
            "Informática",
            "1080p"
        );
        
        System.out.println("\n=== RECURSOS DISPONIBLES ===");
        ebook.mostrarInformacionCompleta();
        audiolibro.mostrarInformacionCompleta();
        video.mostrarInformacionCompleta();
        
        System.out.println("SIMULACIÓN DE PRÉSTAMOS");
        
        ebook.setFechaPrestamo(LocalDate.now().minusDays(5));
        System.out.println("\n✓ Ebook prestado hace 5 días");
        
        audiolibro.setFechaPrestamo(LocalDate.now().minusDays(20));
        System.out.println("✓ Audiolibro prestado hace 20 días (con retraso)");
        
        System.out.println("\n=== ESTADO ACTUAL DE LOS RECURSOS ===");
        ebook.mostrarInformacionCompleta();
        audiolibro.mostrarInformacionCompleta();
        
        System.out.println("RESUMEN DE MULTAS");
        System.out.println("Ebook: " + (ebook.tieneMulta() ? ebook.calcularMulta() + "€" : "Sin multa"));
        System.out.println("Audiolibro: " + (audiolibro.tieneMulta() ? audiolibro.calcularMulta() + "€" : "Sin multa"));
    }
}