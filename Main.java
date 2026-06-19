public class Main {
    
    public static void main(String[] args) {
        
        // PARTE 1 

        Servicios s = new Servicios("csv/Camiones.csv", "csv/Paquetes.csv");

        System.out.println("1.1. " + s.servicio1("P001") + "\n");

        System.out.println("1.2. " + s.servicio2(true) + "\n");

        System.out.println("1.3. " + s.servicio3(50,100) + "\n");

        // PARTE 2 

        Backtracking bt = new Backtracking(s.getCamiones(), s.getPaquetes());

        Solucion solucion = bt.resolver();

        System.out.println("2.1 " + solucion);

    }

}
