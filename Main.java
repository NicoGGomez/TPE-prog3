

public class Main {
    
    public static void main(String[] args) {
        
        Servicios s = new Servicios("csv/Camiones.csv", "csv/Paquetes.csv");

        System.out.println("1." + s.servicio1("P001") + "\n");

        System.out.println("2." + s.servicio2(true) + "\n");

        System.out.println("3." + s.servicio3(50,100) + "\n");

    }

}
