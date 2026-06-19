import java.util.ArrayList;
import java.util.HashMap;

import Clases.Camion;
import Clases.Paquete;

public class Backtracking {

    private ArrayList<Camion> camiones;
    private ArrayList<Paquete> paquetes;

    private Solucion mejorSolucion;
    private int estadosGenerados;

    public Backtracking(ArrayList<Camion> camiones, ArrayList<Paquete> paquetes){
        this.camiones = camiones;
        this.paquetes = paquetes;
        this.mejorSolucion = new Solucion();
        this.estadosGenerados = 0;
    }

    public Solucion resolver(){

        HashMap<Camion, ArrayList<Paquete>> respuesta = new HashMap<>();

        for (Camion c : camiones) {
            respuesta.put(c, new ArrayList<>());
        }

        backtracking(0, respuesta, 0);
        
        mejorSolucion.setEstadosGenerados(estadosGenerados);

        return mejorSolucion;
        
    }

    private void backtracking(int indicePaquete, HashMap<Camion, ArrayList<Paquete>> actual, int pesoNoAsignado) {
        
        estadosGenerados++;

        if (pesoNoAsignado >= mejorSolucion.getPesoNoAsignado())
            return;


        if (indicePaquete == paquetes.size()) {
            
            if (pesoNoAsignado < mejorSolucion.getPesoNoAsignado()) {
                mejorSolucion.setPesoNoAsignado(pesoNoAsignado);
                mejorSolucion.setAsignaciones(copiar(actual));
            }
            return;

        }

        Paquete p = paquetes.get(indicePaquete);

        for (Camion c : camiones) {
            
            if (puedeAsignarse(p, c, actual)){
                actual.get(c).add(p);

                backtracking(indicePaquete + 1, actual, pesoNoAsignado);

                actual.get(c).remove(p);
            }

        }

        backtracking(indicePaquete + 1, actual, pesoNoAsignado + p.getPesoKg());

    }

    private boolean puedeAsignarse(Paquete p, Camion c, HashMap<Camion, ArrayList<Paquete>> actual){

        if (p.getContieneAlimentos() && !c.getRefrigerado()) 
            return false;

        int pesoActual = 0;

        for (Paquete pack : actual.get(c)) {
            pesoActual += pack.getPesoKg();
        }

        return pesoActual +p.getPesoKg() <= c.getCapacidadKg();

    }

    private HashMap<Camion, ArrayList<Paquete>> copiar(HashMap<Camion, ArrayList<Paquete>> original) {

        HashMap<Camion, ArrayList<Paquete>> copia = new HashMap<>();

        for (Camion c : original.keySet()) {
            copia.put(c, new ArrayList<>(original.get(c)));
        }

        return copia;
    }

}
