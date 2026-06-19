package Clases;

public class Camion {
    private int id;
    private String patente;
    private boolean refrigerado;
    private int capacidadKg;

    public Camion(int id, String patente, boolean refrigerado, int capacidadKg){
        this.id = id;
        this.patente = patente;
        this.refrigerado = refrigerado;
        this.capacidadKg = capacidadKg;
    }

    public boolean getRefrigerado(){
        return refrigerado;
    }

    public int getCapacidadKg() {
        return capacidadKg;
    }

    public int getId() {
        return id;
    }

    public String getPatente() {
        return patente;
    }

    public void setCapacidadKg(int capacidadKg) {
        this.capacidadKg = capacidadKg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Camion otro = (Camion) obj;

        return patente.equals(otro.patente);
    }

    @Override
    public int hashCode() {
        return patente.hashCode();
    }

    @Override
    public String toString() {
        return patente + " (" + capacidadKg + "kg)";
    }

}
