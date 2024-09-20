package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Passagem {
    private Voo voo;
    private String codVoo;
    private String moeda;
    private TipoTarifa tipoTarifa;
    private double valorPrimeiraBagagem;
    private double valorBagagemAdicional;
    private ArrayList<Voo> voos = new ArrayList<>();
    private ArrayList<Passagem> passagens = new ArrayList<>();

    public Passagem() {
    }

    public Passagem(Voo voo, String codVoo, String moeda, TipoTarifa tipoTarifa, double valorPrimeiraBagagem, double valorBagagemAdicional, ArrayList<Voo> voos) {
        this.voo = voo;
        this.codVoo = codVoo;
        this.moeda = moeda;
        this.tipoTarifa = tipoTarifa;
        this.valorPrimeiraBagagem = valorPrimeiraBagagem;
        this.valorBagagemAdicional = valorBagagemAdicional;
        this.voos = voos;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }


    public ArrayList<Voo> getVoos() {
        return voos;
    }

    public void setVoos(ArrayList<Voo> voos) {
        this.voos = voos;
    }

    public ArrayList<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(ArrayList<Passagem> passagens) {
        this.passagens = passagens;
    }

    public String getCodVoo() {
        return codVoo;
    }

    public void setCodVoo(String codVoo) {
        this.codVoo = codVoo;
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

    public Passagem buscarPassagem(String codVoo){
        for (Passagem p: passagens){
            if (p.getCodVoo().equalsIgnoreCase(codVoo)){
                return p;
            }
        }
        return null;
    }

    public double calcularTarifaTotalDosVoos() {
        double valorTotal = 0;
        for (Voo v : voos){
            valorTotal += v.calcularTarifaTotal(tipoTarifa);
        }
        return valorTotal;
    }


    public double calcValorBagagem(int qtdBagagens){
        double sum = 0;
        if (qtdBagagens == 1){
            sum = this.valorPrimeiraBagagem;
        } else if (qtdBagagens > 1) {
            sum = this.valorPrimeiraBagagem + (this.valorBagagemAdicional * (qtdBagagens-1));
        }
        return sum;
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Voo voo : voos) {
            valorTotal += voo.getValorTarifa();  // Soma o valor da tarifa de cada voo
        }
        return valorTotal;
    }

    @Override
    public String toString() {
        return  "Código do voo: "
                + codVoo
                + " Origem: "
                + voo.getAeroportoDeOrigem()
                + " Destino: "
                + voo.getAeroportoDeDestino();
    }
}
