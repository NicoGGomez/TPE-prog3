package src.Clases;

public class Paquete {
    private int id;
    private String codigo;
    private int pesoKg;
    private boolean contieneAlimentos;
    private int urgencia;
    
    public Paquete(int id, String codigo, int pesoKg, boolean contieneAlimentos, int urgencia){
        this.id = id;
        this.codigo = codigo;
        this.pesoKg = pesoKg;
        this.contieneAlimentos = contieneAlimentos;
        this.urgencia = urgencia;
    }

    @Override
    public String toString() {
        return "Paquete {\n" +
                "\tid = " + id + "\n" +
                "\tcodigo = '" + codigo + "'\n" +
                "\tpeso = " + pesoKg + "\n" +
                "\tcontieneAlimentos = " + contieneAlimentos + "\n" +
                "\turgencia = " + urgencia + "\n" +
                "}";
    }
    
    public boolean getContieneAlimentos(){
        return contieneAlimentos;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getId() {
        return id;
    }
    
    public int getPesoKg() {
        return pesoKg;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setContieneAlimentos(boolean contieneAlimentos) {
        this.contieneAlimentos = contieneAlimentos;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setPesoKg(int pesoKg) {
        this.pesoKg = pesoKg;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }
    
}
