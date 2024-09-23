package entities;

import java.util.ArrayList;

public class Passagem {
    private Voo voo;
    private String codVoo;
    private String moeda;
    private TipoTarifa tipoTarifa;
    private ArrayList<Voo> voos = new ArrayList<>();
    private ArrayList<Passagem> passagens = new ArrayList<>();

    public Passagem() {
    }

    public Passagem(Voo voo, String codVoo, String moeda, TipoTarifa tipoTarifa) {
        this.voo = voo;
        this.codVoo = codVoo;
        this.moeda = moeda;
        this.tipoTarifa = tipoTarifa;
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


    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public TipoTarifa getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(TipoTarifa tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    public Passagem buscarPassagem(String codVoo) {
        for (Passagem p : passagens) {
            if (p.getCodVoo().equalsIgnoreCase(codVoo)) {
                return p;
            }
        }
        return null;
    }


    public double calcValorBagagem( ArrayList<Voo> voos) {
        double sum = 0;
        for (Voo v : voos) {
            if (v.getViajante().getQntBagagens() == 1) {
                sum = v.getCiaAerea().getValorPrimeiraBagagem();
            } else if (v.getViajante().getQntBagagens() > 1) {
                sum = v.getCiaAerea().getValorPrimeiraBagagem() + (v.getCiaAerea().getValorBagagemAdicional() * (v.getViajante().getQntBagagens() - 1));
            }
        }
        return sum;
    }

    public double calcularTarifaTotalDosVoos(ArrayList<Voo> voos) {
        double valorTotal = 0;
        double valorBagagens = calcValorBagagem(voos);
        for (Voo v : voos) {
            valorTotal += v.calcularTarifaTotal(tipoTarifa);
        }
        return valorTotal + valorBagagens;
    }


    @Override
    public String toString() {
        return "Código do voo: "
                + codVoo
                + " Origem: "
                + voo.getAeroportoDeOrigem()
                + " Destino: "
                + voo.getAeroportoDeDestino()
                + " Data/Hora de saída: "
                + voo.getDataHora_saida();
    }
}
