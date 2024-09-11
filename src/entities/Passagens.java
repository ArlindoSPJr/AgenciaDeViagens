package entities;

import java.time.LocalDateTime;

public class Passagens {
    private static final double taxaAgencia = 0.02; //Taxa a definir
    private LocalDateTime data_hora;
    private String horario;
    private CompanhiaAerea ciaAerea;
    private double valorTarifaBasica;
    private double valorTarifaBusiness;
    private double valorTarifaPremium;
    private String moeda;

    public Passagens() {
    }

    public Passagens(LocalDateTime data_hora, String horario, CompanhiaAerea ciaAerea, double valorTarifaBasica,
            double valorTarifaBusiness, double valorTarifaPremium, String moeda) {
        this.data_hora = data_hora;
        this.horario = horario;
        this.ciaAerea = ciaAerea;
        this.valorTarifaBasica = valorTarifaBasica;
        this.valorTarifaBusiness = valorTarifaBusiness;
        this.valorTarifaPremium = valorTarifaPremium;
        this.moeda = moeda;
    }

    public static double getTaxaagencia() {
        return taxaAgencia;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    
    
}
