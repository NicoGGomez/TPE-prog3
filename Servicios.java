import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Clases.Camion;
import Clases.Paquete;

public class Servicios {
    private HashMap<String, Camion> camiones = new HashMap<>();
    private HashMap<String, Paquete> paquetes = new HashMap<>();

    // complejidad: O(c + p)
    public Servicios(String pathCamiones, String pathPaquetes){
        cargarInformacion(pathCamiones, pathPaquetes);
    }

    // complejidad: búsqueda directa por código O(1)
    public Paquete servicio1(String codigoPaquete) { 
        return paquetes.get(codigoPaquete);
    }
    
    // complejidad: necesito inspeccionar todos los paquetes O(p)
    public List<Paquete> servicio2(boolean contieneAlimentos) {

        List<Paquete> resultado = new ArrayList<>();

        for (Paquete p : paquetes.values()) {
            if (p.getContieneAlimentos() == contieneAlimentos) {
                resultado.add(p);
            }
        }

        return resultado;
    }
    
    // complejidad: necesito verificar la urgencia de cada paquete O(p)
    public List<Paquete> servicio3(int urgenciaMinima, int urgenciaMaxima) {

        List<Paquete> resultado = new ArrayList<>();

        for (Paquete p : paquetes.values()) {
            if (p.getUrgencia() >= urgenciaMinima &&
                p.getUrgencia() <= urgenciaMaxima) {

                resultado.add(p);
            }
        }

        return resultado;
    }

    private void cargarInformacion(String pathCamion, String pathPaquetes){
        cargarPaquete(pathPaquetes);
        cargarCamiones(pathCamion);
    }

    private void cargarPaquete(String path){
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                int id = Integer.parseInt(datos[0]);
                String codigo = datos[1];
                int peso = Integer.parseInt(datos[2]);
                boolean alimentos = datos[3].equals("1");
                int urgencia = Integer.parseInt(datos[4]);

                Paquete p = new Paquete(id, codigo, peso, alimentos, urgencia);

                paquetes.put(codigo, p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarCamiones(String path){
            try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                int id = Integer.parseInt(datos[0]);
                String patente = datos[1];
                boolean refrigerado = datos[2].equals("1");
                int capacidadKg = Integer.parseInt(datos[3]);

                Camion c = new Camion(id, patente, refrigerado, capacidadKg);

                camiones.put(patente, c);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
