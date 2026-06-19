
/*
 
Explicacion de estrategia

 * Se recorren los paquetes uno por uno.
 * Para cada paquete se prueban todos los camiones
 * compatibles y también la posibilidad de no asignarlo.
 * Se exploran todas las combinaciones válidas y se
 * conserva la solución con menor peso no asignado.

*/

import java.util.ArrayList;
import java.util.HashMap;

import Clases.Camion;
import Clases.Paquete;

public class Backtrack {

    private ArrayList<Camion> camiones;
    private ArrayList<Paquete> paquetes;
    
    private Solucion mejorSolucion;
    private int estadosGenerados;

    public Backtrack(ArrayList<Camion> camiones, ArrayList<Paquete> paquetes) {
        this.camiones = camiones;
        this.paquetes = paquetes;

        this.mejorSolucion = new Solucion();
        this.estadosGenerados = 0;
    }

    public Solucion resolver() {

        HashMap<Camion, ArrayList<Paquete>> actual = new HashMap<>();

        for (Camion c : camiones) {
            actual.put(c, new ArrayList<>());
        }

        backtracking(0, actual, 0);

        return mejorSolucion;
    }

    private void backtracking(int indicePaquete, HashMap<Camion, ArrayList<Paquete>> actual, int pesoNoAsignado) {

        estadosGenerados++;

        if (indicePaquete == paquetes.size()) {

            if (pesoNoAsignado < mejorSolucion.getPesoNoAsignado()) {

                mejorSolucion.setPesoNoAsignado(pesoNoAsignado);

                // copiar solución
            }

            return;
        }

        Paquete p = paquetes.get(indicePaquete);

        for (Camion c : camiones) {

            if (puedeAsignarse(p, c, actual)) {

                actual.get(c).add(p);

                backtracking(
                    indicePaquete + 1,
                    actual,
                    pesoNoAsignado
                );

                actual.get(c).remove(p);
            }
        }

        // opción: no asignarlo
        backtracking(
            indicePaquete + 1,
            actual,
            pesoNoAsignado + p.getPesoKg()
        );
    }

    private boolean puedeAsignarse(Paquete p, Camion c, HashMap<Camion, ArrayList<Paquete>> actual) {

        if (p.getContieneAlimentos() && !c.getRefrigerado()) {
            return false;
        }

        int pesoActual = 0;

        for (Paquete paq : actual.get(c)) {
            pesoActual += paq.getPesoKg();
        }

        return pesoActual + p.getPesoKg()
                <= c.getCapacidadKg();
    }
    
}
