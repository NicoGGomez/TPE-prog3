import src.algoritmos.Backtracking;
import src.algoritmos.Greedy;
import src.servicios.Servicios;
import src.solucion.Solucion;

public class Main {
    
    public static void main(String[] args) {
        
        // PARTE 1 

        System.out.println("\n===== PARTE 1 =====");

        Servicios s = new Servicios("csv/Camiones.csv", "csv/Paquetes.csv");

        System.out.println("1.1. paquete asociado: " + s.servicio1("P001") + "\n");

        System.out.println("1.2. lista: " + s.servicio2(true) + "\n");

        System.out.println("1.3. lista: " + s.servicio3(50,100) + "\n");

        // PARTE 2 

        System.out.println("\n===== PARTE 2 =====");

        System.out.println("\n===== BACKTRACKING =====");

        Backtracking bt = new Backtracking(s.getCamiones(), s.getPaquetes());

        Solucion solucionBacktracking = bt.resolver();

        System.out.println("2.1 " + solucionBacktracking);

        System.out.println("\n===== GREEDY =====");

        Greedy greedy = new Greedy(s.getCamiones(), s.getPaquetes());

        Solucion solucionGreedy = greedy.resolver();

        System.out.println("2.2 " + solucionGreedy);

    }

}
