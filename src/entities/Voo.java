package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Voo {
    private String codVoo;
    private CompanhiaAerea ciaAerea;
    private Aeroporto aeroportoDeOrigem;
    private Aeroporto aeroportoDeDestino;
    private int capacidade;
    private double tarifaBasica;
    private double tarifaBusiness;
    private double tarifaPremium;
    private LocalDateTime dataHora_chegada;
    private LocalDateTime dataHora_saida;
    private double valorTarifa;;
    private ArrayList<Voo> voos = new ArrayList<>();

    public Voo() {
    }

    public Voo(String codVoo, CompanhiaAerea ciaAerea, Aeroporto aeroportoDeOrigem, Aeroporto aeroportoDeDestino, int capacidade, double tarifaBasica, double tarifaBusiness, double tarifaPremium, LocalDateTime dataHora_chegada, LocalDateTime dataHora_saida) {
        this.codVoo = codVoo;
        this.ciaAerea = ciaAerea;
        this.aeroportoDeOrigem = aeroportoDeOrigem;
        this.aeroportoDeDestino = aeroportoDeDestino;
        this.capacidade = capacidade;
        this.tarifaBasica = tarifaBasica;
        this.tarifaBusiness = tarifaBusiness;
        this.tarifaPremium = tarifaPremium;
        this.dataHora_chegada = dataHora_chegada;
        this.dataHora_saida = dataHora_saida;
    }

    public String getCodVoo() {
        return codVoo;
    }

    public void setCodVoo(String codVoo) {
        this.codVoo = codVoo;
    }

    public Aeroporto getAeroportoDeOrigem() {
        return aeroportoDeOrigem;
    }

    public void setAeroportoDeOrigem(Aeroporto aeroportoDeOrigem) {
        this.aeroportoDeOrigem = aeroportoDeOrigem;
    }

    public Aeroporto getAeroportoDeDestino() {
        return aeroportoDeDestino;
    }

    public void setAeroportoDeDestino(Aeroporto aeroportoDeDestino) {
        this.aeroportoDeDestino = aeroportoDeDestino;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public LocalDateTime getDataHora_chegada() {
        return dataHora_chegada;
    }

    public void setDataHora_chegada(LocalDateTime dataHora_chegada) {
        this.dataHora_chegada = dataHora_chegada;
    }

    public LocalDateTime getDataHora_saida() {
        return dataHora_saida;
    }

    public void setDataHora_saida(LocalDateTime dataHora_saida) {
        this.dataHora_saida = dataHora_saida;
    }

    public double getTarifaBasica() {
        return tarifaBasica;
    }

    public void setTarifaBasica(double tarifaBasica) {
        this.tarifaBasica = tarifaBasica;
    }

    public double getTarifaBusiness() {
        return tarifaBusiness;
    }

    public void setTarifaBusiness(double tarifaBusiness) {
        this.tarifaBusiness = tarifaBusiness;
    }

    public double getTarifaPremium() {
        return tarifaPremium;
    }

    public void setTarifaPremium(double tarifaPremium) {
        this.tarifaPremium = tarifaPremium;
    }

    public double getValorTarifa() {
        return valorTarifa;
    }

    public void setValorTarifa(double valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    public double calcularTarifaTotal(TipoTarifa tipoTarifa) {

        switch (tipoTarifa) {
            case BASICA:
                valorTarifa = tarifaBasica;
                break;
            case BUSINESS:
                valorTarifa = tarifaBusiness;
                break;
            case PREMIUM:
                valorTarifa = tarifaPremium;
                break;
        }
        return valorTarifa;
    }

    public Voo buscarVoo(String codVoo) {
        for (Voo v : voos) {
            if (v.getCodVoo().equalsIgnoreCase(codVoo)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "aeroportoDeOrigem=" + aeroportoDeOrigem +
                ", aeroportoDeDestino=" + aeroportoDeDestino +
                '}';
    }
}
