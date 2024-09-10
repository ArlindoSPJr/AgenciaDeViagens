package entities;

public class CompanhiaAerea {
    private String nome;
    private int codigo;
    private String razaoSocial;
    private int cnpj;
    private double valorPrimeiraBagagem;
    private double valorBagagemAdicional;

    public CompanhiaAerea() {}

    public CompanhiaAerea(String nome, int codigo, String razaoSocial, int cnpj, double valorPrimeiraBagagem, double valorBagagemAdicional) {
        this.nome = nome;
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.valorPrimeiraBagagem = valorPrimeiraBagagem;
        this.valorBagagemAdicional = valorBagagemAdicional;
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

    public double getValorPrimeiraBagagem() {
        return valorPrimeiraBagagem;
    }

    public void setValorPrimeiraBagagem(double valorPrimeiraBagagem) {
        this.valorPrimeiraBagagem = valorPrimeiraBagagem;
    }

    public double getValorBagagemAdicional() {
        return valorBagagemAdicional;
    }

    public void setValorBagagemAdicional(double valorBagagemAdicional) {
        this.valorBagagemAdicional = valorBagagemAdicional;
    }
}
