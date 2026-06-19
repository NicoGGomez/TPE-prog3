import java.util.ArrayList;
import java.util.HashMap;

import Clases.Camion;
import Clases.Paquete;

public class Backtracking {

    private ArrayList<Camion> camiones;
    private ArrayList<Paquete> paquetes;

    private HashMap<Camion, ArrayList<Paquete>> mejorSolucion;
    private int mejorPesoNoAsignado;

    public Backtracking(ArrayList<Camion> camiones, ArrayList<Paquete> paquetes){
        this.camiones = camiones;
        this.paquetes = paquetes;
    }

    public HashMap<Camion, ArrayList<Paquete>> resolver(){

        HashMap<Camion, ArrayList<Paquete>> respuesta = new HashMap<>();

        for (Camion c : camiones) {
            respuesta.put(c, new ArrayList<>());
        }

        backtracking(0, respuesta, 0);

        return respuesta;
        
    }

    private void backtracking(int indicePaquete, HashMap<Camion, ArrayList<Paquete>> actual, int pesoNoAsignado) {

        if (pesoNoAsignado >= mejorSolucion.getPesoNoAsignado())
            return;



    }

}
