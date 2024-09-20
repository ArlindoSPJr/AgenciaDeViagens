package entities;

import java.util.ArrayList;

public class Viajante {
    private String nome;
    private String ultimoSobrenome;
    private String documento;
    private ArrayList<Bilhete> bilhetes;
    private ArrayList<Viajante> viajantes = new ArrayList<>();

    public Viajante() {
    }

    public Viajante(String nome, String ultimoSobrenome, String documento) {
        this.nome = nome;
        this.ultimoSobrenome = ultimoSobrenome;
        this.documento = documento;
    }
    public String getNomeCompleto() {
        return nome + " " + ultimoSobrenome;
    }

    public String getUltimoSobrenome() {
        return ultimoSobrenome;
    }

    public void setUltimoSobrenome(String ultimoSobrenome) {
        this.ultimoSobrenome = ultimoSobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public ArrayList<Viajante> getViajantes() {
        return viajantes;
    }

    public void setViajantes(ArrayList<Viajante> viajantes) {
        this.viajantes = viajantes;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Viajante buscarViajantes(String documento){
        for (Viajante v : viajantes){
            if (v.getDocumento().equalsIgnoreCase(documento)){
                return v;
            }
        }
        return null;
    }
}
