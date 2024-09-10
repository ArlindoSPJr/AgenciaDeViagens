package entities;

public class Cliente {
    private String nome;
    private String ultimoSobrenome;
    private String documento;

    public Cliente() {
    }

    public Cliente(String nome, String ultimoSobrenome, String documento) {
        this.nome = nome;
        this.ultimoSobrenome = ultimoSobrenome;
        this.documento = documento;
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

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
