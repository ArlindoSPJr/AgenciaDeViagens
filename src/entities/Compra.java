package entities;

import java.util.ArrayList;


public class Compra {
    private Viajante viajante;
    private ArrayList<Passagem> passagens = new ArrayList<>();
    private ArrayList<Voo> voos = new ArrayList<>();
    private TipoTarifa tipoTarifa;
    private double valorTotal;
    private String tipoMoeda;
    private static final double taxaAgencia = 0.02; //Taxa a definir

    public Compra() {}

    public Compra(Viajante viajante, ArrayList<Passagem> passagens, TipoTarifa tipoTarifa, String tipoMoeda) {
        this.viajante = viajante;
        this.passagens = passagens;
        this.tipoTarifa = tipoTarifa;
        this.tipoMoeda = tipoMoeda;
    }

    public Viajante getViajante() {
        return viajante;
    }

    public void setViajante(Viajante viajante) {
        this.viajante = viajante;
    }


    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public TipoTarifa getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(TipoTarifa tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    public String getTipoMoeda() {
        return tipoMoeda;
    }

    public void setTipoMoeda(String tipoMoeda) {
        this.tipoMoeda = tipoMoeda;
    }

    public ArrayList<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(ArrayList<Passagem> passagens) {
        this.passagens = passagens;
    }

    public ArrayList<Voo> getVoos() {
        return voos;
    }

    public void setVoos(ArrayList<Voo> voos) {
        this.voos = voos;
    }


    public double calcularValorTotal(){
        double valorTotal = 0;
        for (Voo v : voos){
            valorTotal += v.calcularTarifaTotal(tipoTarifa);
        }
        return valorTotal;
    }

    public double calcRemuneracaoAgencia(){
        double valorTotal = calcularValorTotal();
        return valorTotal * taxaAgencia;
    }

    public Bilhete emitirBilhete( Voo voo){
        double valorTotal = calcularValorTotal();
        return new Bilhete(viajante.getNomeCompleto(), viajante.getDocumento(), passagens, valorTotal, tipoMoeda);
    }
}
