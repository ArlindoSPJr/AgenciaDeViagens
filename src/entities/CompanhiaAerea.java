package entities;

import java.util.ArrayList;

public class CompanhiaAerea {
    private String nome;
    private int codigo;
    private String razaoSocial;
    private int cnpj;
    private ArrayList<Passagem> passagens = new ArrayList<>();
    private ArrayList<CompanhiaAerea> ciasAereas = new ArrayList<>();

    public CompanhiaAerea() {}

    public CompanhiaAerea(String nome, int codigo, String razaoSocial, int cnpj) {
        this.nome = nome;
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }


    public ArrayList<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(ArrayList<Passagem> passagens) {
        this.passagens = passagens;
    }

    public ArrayList<CompanhiaAerea> getCiasAereas() {
        return ciasAereas;
    }

    public void setCiasAereas(ArrayList<CompanhiaAerea> ciasAereas) {
        this.ciasAereas = ciasAereas;
    }

    public CompanhiaAerea buscarCompanhiaAerea(int codigo){
        for (CompanhiaAerea ciaAerea : ciasAereas){
            if (ciaAerea.getCodigo() == codigo){
                return ciaAerea;
            }
        }
        return null;
    }
}
