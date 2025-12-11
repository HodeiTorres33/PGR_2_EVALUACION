package module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LigaSports {

    private ArrayList<String> competidores;
    private HashMap<String, Integer> partidasGanadas;
    
    public LigaSports() {
        this.competidores = new ArrayList<>();
        this.partidasGanadas = new HashMap<>();
    }

    
    public void añadirCompetidor(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return;
        }
        if (competidores.contains(nombre)) {
            System.out.println("El competidor '" + nombre + "' ya está registrado.");
        } else {
            competidores.add(nombre);
            System.out.println("Competidor '" + nombre + "' añadido correctamente.");
        }
    }
    
    
    public void listarCompetidores() {
        if (competidores.isEmpty()) {
            System.out.println("No hay competidores registrados.");
        } else {
            System.out.println("\n=== LISTA DE COMPETIDORES ===");
            for (int i = 0; i < competidores.size(); i++) {
                System.out.println((i + 1) + ". " + competidores.get(i));
            }
            System.out.println("Total: " + competidores.size() + " competidores");
        }
    }
    
    
    public void actualizarCompetidor(String antiguo, String nuevo) {
        if (nuevo == null || nuevo.trim().isEmpty()) {
            System.out.println("Error: El nuevo nombre no puede estar vacío.");
            return;
        }
        
        int index = competidores.indexOf(antiguo);
        if (index != -1) {
            competidores.set(index, nuevo);
            
            if (partidasGanadas.containsKey(antiguo)) {
                Integer partidas = partidasGanadas.remove(antiguo);
                partidasGanadas.put(nuevo, partidas);
            }
            
            System.out.println("Competidor actualizado: '" + antiguo + "' → '" + nuevo + "'");
        } else {
            System.out.println("El competidor '" + antiguo + "' no existe.");
        }
    }
    
    
    public void eliminarCompetidor(String nombre) {
        if (competidores.remove(nombre)) {
            partidasGanadas.remove(nombre); 
            System.out.println("Competidor '" + nombre + "' eliminado correctamente.");
        } else {
            System.out.println("El competidor '" + nombre + "' no existe.");
        }
    }
    
    
    public void eliminarCompetidores(ArrayList<String> nombres) {
        if (nombres == null || nombres.isEmpty()) {
            System.out.println("No se proporcionaron nombres para eliminar.");
            return;
        }
        
        int eliminados = 0;
        for (String nombre : nombres) {
            if (competidores.remove(nombre)) {
                partidasGanadas.remove(nombre);
                eliminados++;
                System.out.println("  - '" + nombre + "' eliminado.");
            }
        }
        
        System.out.println("Total eliminados: " + eliminados + " de " + nombres.size());
    }

   
    public void registrarPartidas(String competidor, int cantidad) {
        if (cantidad < 0) {
            System.out.println("Error: La cantidad de partidas no puede ser negativa.");
            return;
        }
        
        partidasGanadas.put(competidor, cantidad);
        System.out.println("Registradas " + cantidad + " partidas para '" + competidor + "'.");
    }
    
    
    public void listarPartidas() {
        if (partidasGanadas.isEmpty()) {
            System.out.println("No hay registros de partidas ganadas.");
        } else {
            System.out.println("\n=== PARTIDAS GANADAS ===");
            for (Map.Entry<String, Integer> entry : partidasGanadas.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " partidas");
            }
        }
    }
    
    
    public void actualizarPartidas(String competidor, int nuevasPartidas) {
        if (nuevasPartidas < 0) {
            System.out.println("Error: La cantidad de partidas no puede ser negativa.");
            return;
        }
        
        if (partidasGanadas.containsKey(competidor)) {
            int antiguas = partidasGanadas.get(competidor);
            partidasGanadas.put(competidor, nuevasPartidas);
            System.out.println("Partidas de '" + competidor + "' actualizadas: " + 
                             antiguas + " → " + nuevasPartidas);
        } else {
            System.out.println("El competidor '" + competidor + "' no tiene registros de partidas.");
        }
    }
    
    
    public void eliminarRegistro(String competidor) {
        if (partidasGanadas.remove(competidor) != null) {
            System.out.println("Registro de partidas de '" + competidor + "' eliminado.");
        } else {
            System.out.println("El competidor '" + competidor + "' no tiene registros de partidas.");
        }
    }

    
    public boolean compararRegistros() {
        System.out.println("\n=== COMPARANDO REGISTROS ===");
        
        Iterator<String> iteradorCompetidores = competidores.iterator();
        
        boolean todosRegistrados = true;
        ArrayList<String> faltantes = new ArrayList<>();
        
        while (iteradorCompetidores.hasNext()) {
            String competidor = iteradorCompetidores.next();
            
            Iterator<String> iteradorHashMap = partidasGanadas.keySet().iterator();
            boolean encontrado = false;
            
            while (iteradorHashMap.hasNext()) {
                String clave = iteradorHashMap.next();
                if (clave.equals(competidor)) {
                    encontrado = true;
                    break;
                }
            }
            
            if (!encontrado) {
                todosRegistrados = false;
                faltantes.add(competidor);
            }
        }
        
        if (todosRegistrados) {
            System.out.println("Todos los competidores tienen registros de partidas.");
        } else {
            System.out.println("Los siguientes competidores NO tienen registros de partidas:");
            for (String faltante : faltantes) {
                System.out.println("  - " + faltante);
            }
        }
        
        return todosRegistrados;
    }

    
    public ArrayList<String> getCompetidores() {
        return competidores;
    }

    public void setCompetidores(ArrayList<String> competidores) {
        this.competidores = competidores;
    }

    public HashMap<String, Integer> getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(HashMap<String, Integer> partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    @Override
    public String toString() {
        return "LigaEsports [competidores=" + competidores + ", partidasGanadas=" + partidasGanadas + "]";
    }
}