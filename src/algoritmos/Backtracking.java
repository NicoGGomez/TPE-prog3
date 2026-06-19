package src.algoritmos;

/*
 
Explicacion de estrategia:

El algoritmo utiliza backtracking para explorar todas las posibles asignaciones de paquetes a camiones y quedarse con la mejor solución.

Recorre los paquetes uno por uno y, para cada uno, prueba dos opciones: asignarlo a algún camión válido (respetando capacidad y refrigeración) o no asignarlo. En cada paso se genera un nuevo estado del problema.

Si la solución parcial ya tiene un peso no asignado mayor o igual al de la mejor solución encontrada, se podan ramas para optimizar la búsqueda. Al llegar al final de los paquetes, se actualiza la mejor solución si se obtuvo un menor peso no asignado.

Además, se cuentan los estados generados para medir el costo computacional del algoritmo.

*/ 

import java.util.ArrayList;
import java.util.HashMap;

import src.Clases.Camion;
import src.Clases.Paquete;
import src.solucion.Solucion;

public class Backtracking {

    private ArrayList<Camion> camiones;
    private ArrayList<Paquete> paquetes;

    private Solucion mejorSolucion;
    private int estadosGenerados;

    public Backtracking(ArrayList<Camion> camiones, ArrayList<Paquete> paquetes){
        this.camiones = camiones;
        this.paquetes = paquetes;
        this.mejorSolucion = new Solucion();
        this.mejorSolucion.setPesoNoAsignado(Integer.MAX_VALUE);
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
