import java.util.ArrayList;
import java.util.HashMap;

import Clases.Camion;
import Clases.Paquete;

public class Solucion {

    private HashMap<Camion, ArrayList<Paquete>> asignaciones;
    private int pesoNoAsignado;
    private int estadosGenerados;

    public Solucion() {
        this.asignaciones = new HashMap<>();
        this.pesoNoAsignado = Integer.MAX_VALUE;
        this.estadosGenerados = 0; 
    }

    public int getEstadosGenerados() {
        return estadosGenerados;
    }

    public void setEstadosGenerados(int estadosGenerados) {
        this.estadosGenerados = estadosGenerados;
    }

    public HashMap<Camion, ArrayList<Paquete>> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(HashMap<Camion, ArrayList<Paquete>> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public int getPesoNoAsignado() {
        return pesoNoAsignado;
    }

    public void setPesoNoAsignado(int pesoNoAsignado) {
        this.pesoNoAsignado = pesoNoAsignado;
    }

    @Override
    public String toString() {

        String resultado = "Solución obtenida:\n";

        for (Camion c : asignaciones.keySet()) {
            resultado += c + " -> " + asignaciones.get(c) + "\n";
        }

        resultado += "\nPeso no asignado: "
                + pesoNoAsignado + " kg";

        resultado += "\nCantidad de estados generados: "
                + estadosGenerados;

        return resultado;
    }

}