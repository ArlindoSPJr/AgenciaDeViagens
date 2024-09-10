package entities;

import java.util.Date;

public class Passagens {
    private static final double taxaAgencia = 0.02; //Taxa a definir
    private String aeroportoDeOrigem;
    private String getAeroportoDeDestino;
    private Date data;
    private String horario;
    private String codVoo;
    private CompanhiaAerea ciaAerea;
    private double valorTarifaBasica;
    private double valorTarifaBusiness;
    private double valorTarifaPremium;
    private double valorPrimeiraBagagem;
    private double valorPrimeiraAdicional;
    private String moeda;

    public Passagens() {
    }

    public Passagens(String aeroportoDeOrigem, String getAeroportoDeDestino, Date data, String horario, String codVoo, CompanhiaAerea ciaAerea, double valorTarifaBasica, double valorTarifaBusiness, double valorTarifaPremium, double valorPrimeiraBagagem, double valorPrimeiraAdicional, String moeda) {
        this.aeroportoDeOrigem = aeroportoDeOrigem;
        this.getAeroportoDeDestino = getAeroportoDeDestino;
        this.data = data;
        this.horario = horario;
        this.codVoo = codVoo;
        this.ciaAerea = ciaAerea;
        this.valorTarifaBasica = valorTarifaBasica;
        this.valorTarifaBusiness = valorTarifaBusiness;
        this.valorTarifaPremium = valorTarifaPremium;
        this.valorPrimeiraBagagem = valorPrimeiraBagagem;
        this.valorPrimeiraAdicional = valorPrimeiraAdicional;
        this.moeda = moeda;
    }

    public String getAeroportoDeOrigem() {
        return aeroportoDeOrigem;
    }

    public void setAeroportoDeOrigem(String aeroportoDeOrigem) {
        this.aeroportoDeOrigem = aeroportoDeOrigem;
    }

    public String getGetAeroportoDeDestino() {
        return getAeroportoDeDestino;
    }

    public void setGetAeroportoDeDestino(String getAeroportoDeDestino) {
        this.getAeroportoDeDestino = getAeroportoDeDestino;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCodVoo() {
        return codVoo;
    }

    public void setCodVoo(String codVoo) {
        this.codVoo = codVoo;
    }

    public CompanhiaAerea getCiaAerea() {
        return ciaAerea;
    }

    public void setCiaAerea(CompanhiaAerea ciaAerea) {
        this.ciaAerea = ciaAerea;
    }

    public double getValorTarifaBasica() {
        return valorTarifaBasica;
    }

    public void setValorTarifaBasica(double valorTarifaBasica) {
        this.valorTarifaBasica = valorTarifaBasica;
    }

    public double getValorTarifaBusiness() {
        return valorTarifaBusiness;
    }

    public void setValorTarifaBusiness(double valorTarifaBusiness) {
        this.valorTarifaBusiness = valorTarifaBusiness;
    }

    public double getValorTarifaPremium() {
        return valorTarifaPremium;
    }

    public void setValorTarifaPremium(double valorTarifaPremium) {
        this.valorTarifaPremium = valorTarifaPremium;
    }

    public double getValorPrimeiraBagagem() {
        return valorPrimeiraBagagem;
    }

    public void setValorPrimeiraBagagem(double valorPrimeiraBagagem) {
        this.valorPrimeiraBagagem = valorPrimeiraBagagem;
    }

    public double getValorPrimeiraAdicional() {
        return valorPrimeiraAdicional;
    }

    public void setValorPrimeiraAdicional(double valorPrimeiraAdicional) {
        this.valorPrimeiraAdicional = valorPrimeiraAdicional;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }
}
