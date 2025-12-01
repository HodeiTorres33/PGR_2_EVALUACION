package principal;

import modelo.Asignatura;

public class ejercicioExamen2324 {

    public static void main(String[] args) {
        
        Asignatura[] clases = new Asignatura[4];
            
        int cont = 0;
        int opcion;
        boolean opMenu = true;
        String menu = "1.- Introducir asignaturas\n"
                + "2.- Mostrar porcentaje de aprobados.\n"
                + "3.- Ordenar las asignaturas por numero de aprobados.\n"
                + "4.- Modificar datos de una asignaturas concreta.\n"
                + "5.- Mostrar todas las asignaturas\n"
                + "6.- Salir del programa.";
            
        while (opMenu) {
            do {
                System.out.println(menu);
                System.out.println("¿Que quieres hacer?\n");
                opcion = Util2.leerInt();
                if (opcion > 6 || opcion < 1) {
                    System.out.println("Tienes que introducir un numero del 1 al 6.\n");
                }
            } while (opcion > 6 || opcion < 1);
            
            switch (opcion) {
            case 1:
                cont = introducirAsignatura(clases, cont);
                break;
            case 2:
                mostrarPorcentajeAprobados(clases, cont);
                break;
            case 3:
                ordenarAsignaturasAprobados(clases, cont);
                break;
            case 4:
                modificarDatosAsignatura(clases, cont);
                break;
            case 5:
                mostrarAsignaturas(clases, cont);
                break;
            case 6:
                System.out.println("Saliendo del programa.");
                opMenu = false;
                break;
            }
        }
    }
    
    private static int introducirAsignatura(Asignatura[] clases, int cont) {
        boolean correcto = false;
        if (cont >= clases.length) {
            System.out.println("Error: No se pueden añadir más asignaturas. Limite del cupo alcanzado.");
            return cont;
        }
        
        // IMPORTANTE: Instanciar el objeto antes de usarlo
        clases[cont] = new Asignatura();
        
        do {
            System.out.println("Introduce el nombre de la asignatura:");
            String nombre = Util2.introducirCadena();
            
            correcto = true;
            for (int i = 0; i < cont; i++) {
                if (clases[i].getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("Error: Ya existe una asignatura con ese nombre.");
                    correcto = false;
                    break;
                }
            }
            
            if (correcto) {
                clases[cont].setNombre(nombre);
            }
        } while (!correcto);
        
        System.out.println("Introduce el curso de la asignatura:");
        clases[cont].setCurso(Util2.introducirCadena());        
        
        System.out.println("Introduce el numero de matriculados de la asignatura:");
        clases[cont].setAlumMatriculados(Util2.leerInt());
        
        int suspensos;
        do {
            System.out.println("Introduce el numero de suspensos de la asignatura:");
            suspensos = Util2.leerInt();
            
            if (suspensos > clases[cont].getAlumMatriculados()) {
                System.out.println("No se puede tener mas suspensos que alumnos matriculados.");
                correcto = false;
            } else {
                correcto = true;
                clases[cont].setNumSuspensos(suspensos);
            }
            
        } while (!correcto);
        
        System.out.println("La asignatura ha sido introducida correctamente.");
        cont++;
        return cont;
    }

    private static void mostrarAsignaturas(Asignatura[] clases, int cont) {
        if (cont == 0) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }
        
        System.out.println("\n=== LISTADO DE ASIGNATURAS ===");
        for (int i = 0; i < cont; i++) {  // Solo hasta cont, no todo el array
            System.out.println((i+1) + ". " + clases[i].toString());
        }
        System.out.println();
    }

    private static void modificarDatosAsignatura(Asignatura[] clases, int cont) {
        if (cont == 0) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }    
        
        mostrarAsignaturas(clases, cont);
        System.out.println("Introduce el numero de la asignatura a modificar (1-" + cont + "):");
        int indice = Util2.leerInt() - 1;
        
        if (indice < 0 || indice >= cont) {
            System.out.println("Indice invalido.");
            return;
        }
        
        System.out.println("Modificando: " + clases[indice].getNombre());
        
        System.out.println("Nuevo nombre (Enter para mantener actual):");
        String nuevoNombre = Util2.introducirCadena();
        if (!nuevoNombre.trim().isEmpty()) {
            clases[indice].setNombre(nuevoNombre);
        }
        
        System.out.println("Nuevo curso (Enter para mantener actual):");
        String nuevoCurso = Util2.introducirCadena();
        if (!nuevoCurso.trim().isEmpty()) {
            clases[indice].setCurso(nuevoCurso);
        }
        
        System.out.println("Nuevo numero de matriculados (-1 para mantener actual):");
        int nuevosMat = Util2.leerInt();
        if (nuevosMat >= 0) {
            clases[indice].setAlumMatriculados(nuevosMat);
        }
        
        System.out.println("Nuevo numero de suspensos (-1 para mantener actual):");
        int nuevosSusp = Util2.leerInt();
        if (nuevosSusp >= 0 && nuevosSusp <= clases[indice].getAlumMatriculados()) {
            clases[indice].setNumSuspensos(nuevosSusp);
        }
        
        System.out.println("Asignatura modificada correctamente.");
    }

    private static void ordenarAsignaturasAprobados(Asignatura[] clases, int cont) {
        if (cont == 0) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }    
        
        // Ordenamiento burbuja por numero de aprobados (descendente)
        for (int i = 0; i < cont - 1; i++) {
            for (int j = 0; j < cont - i - 1; j++) {
                if (clases[j].obtenerNumeroAprobados() < clases[j+1].obtenerNumeroAprobados()) {
                    Asignatura temp = clases[j];
                    clases[j] = clases[j+1];
                    clases[j+1] = temp;
                }
            }
        }
        
        System.out.println("Asignaturas ordenadas por numero de aprobados (mayor a menor):");
        mostrarAsignaturas(clases, cont);
    }

    private static void mostrarPorcentajeAprobados(Asignatura[] clases, int cont) {
        if (cont == 0) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }
        
        mostrarAsignaturas(clases, cont);
        System.out.println("Introduce el numero de la asignatura (1-" + cont + "):");
        int indice = Util2.leerInt() - 1;
        
        if (indice < 0 || indice >= cont) {
            System.out.println("Indice invalido.");
            return;
        }
        
        System.out.println("\nAsignatura: " + clases[indice].getNombre());
        System.out.println("Porcentaje de aprobados: " + 
                          String.format("%.2f", clases[indice].porcentajeAprobados()) + "%"); //Hace que el numero tenga 2 decimales.
        System.out.println("Numero de aprobados: " + clases[indice].obtenerNumeroAprobados());
        System.out.println();
    }
}