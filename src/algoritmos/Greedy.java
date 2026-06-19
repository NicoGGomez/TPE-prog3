package src.algoritmos;

/*
 
Explicacion de estrategia:

El algoritmo utiliza una estrategia voraz para asignar paquetes a camiones.

Primero, ordena los paquetes de mayor a menor peso. Luego, recorre cada paquete e intenta asignarlo al primer camión disponible que cumpla con las restricciones de capacidad y refrigeración.

Si un camión puede transportar el paquete, se asigna inmediatamente; si no, se prueba con el siguiente. Si ningún camión puede tomarlo, el paquete queda sin asignar y su peso se acumula como “no asignado”.

La decisión es local en cada paso, sin reevaluar asignaciones anteriores, lo que caracteriza la estrategia greedy.

*/

import java.util.ArrayList;
import java.util.HashMap;

import src.Clases.Camion;
import src.Clases.Paquete;
import src.solucion.Solucion;

public class Greedy {
    
    private ArrayList<Camion> camiones;
    private ArrayList<Paquete> paquetes;

    private int candidatosConsiderados;

    public Greedy(ArrayList<Camion> camiones, ArrayList<Paquete> paquetes) {
        this.camiones = camiones;
        this.paquetes = paquetes;
        this.candidatosConsiderados = 0;
    }

    public Solucion resolver() {

        Solucion solucion = new Solucion();

        HashMap<Camion, ArrayList<Paquete>> asignaciones = new HashMap<>();

        for (Camion c : camiones) {
            asignaciones.put(c, new ArrayList<>());
        }

        ArrayList<Paquete> copiaPaquetes = new ArrayList<>(paquetes);

        for (int i = 0; i < copiaPaquetes.size() - 1; i++) {
            for (int j = i + 1; j < copiaPaquetes.size(); j++) {

                if (copiaPaquetes.get(j).getPesoKg() >
                    copiaPaquetes.get(i).getPesoKg()) {

                    Paquete aux = copiaPaquetes.get(i);
                    copiaPaquetes.set(i, copiaPaquetes.get(j));
                    copiaPaquetes.set(j, aux);
                }
            }
        }

        int pesoNoAsignado = 0;

        for (Paquete p : copiaPaquetes) {

            Camion mejorCamion = null;

            for (Camion c : camiones) {

                candidatosConsiderados++;

                if (puedeAsignarse(p, c, asignaciones)) {
                    mejorCamion = c;
                    break;
                }
            }

            if (mejorCamion != null) {
                asignaciones.get(mejorCamion).add(p);
            } else {
                pesoNoAsignado += p.getPesoKg();
            }
        }

        solucion.setAsignaciones(asignaciones);
        solucion.setPesoNoAsignado(pesoNoAsignado);
        solucion.setCandidatosConsiderados(candidatosConsiderados);

        return solucion;
    }

    private boolean puedeAsignarse(Paquete p, Camion c, HashMap<Camion, ArrayList<Paquete>> asignaciones) {

        if (p.getContieneAlimentos() && !c.getRefrigerado())
            return false;

        int pesoActual = 0;

        for (Paquete pack : asignaciones.get(c)) {
            pesoActual += pack.getPesoKg();
        }

        return pesoActual + p.getPesoKg() <= c.getCapacidadKg();
    }

}
