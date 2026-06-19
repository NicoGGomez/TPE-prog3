import java.util.ArrayList;
import java.util.HashMap;

import Clases.Camion;
import Clases.Paquete;

public class Solucion {

    private HashMap<Camion, ArrayList<Paquete>> asignaciones;
    private int pesoNoAsignado;

    public Solucion() {
        this.asignaciones = new HashMap<>();
        this.pesoNoAsignado = Integer.MAX_VALUE;
    }

    public HashMap<Camion, ArrayList<Paquete>> getAsignaciones() {
        return asignaciones;
    }

    public int getPesoNoAsignado() {
        return pesoNoAsignado;
    }

    public void setPesoNoAsignado(int pesoNoAsignado) {
        this.pesoNoAsignado = pesoNoAsignado;
    }

    @Override
    public String toString() {
        return "Solución obtenida: cada camión con los paquetes asignados. Peso no asignado: " + this.getPesoNoAsignado() + " kg. Métrica para analizar el costo de la solución (cantidad de estados generados).";
    }

}