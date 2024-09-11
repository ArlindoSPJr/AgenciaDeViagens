package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Passagens {
    private static final double taxaAgencia = 0.02; //Taxa a definir
    private LocalDateTime data_hora;
    private String horario;
    private CompanhiaAerea ciaAerea;
    private double valorTarifaBasica;
    private double valorTarifaBusiness;
    private double valorTarifaPremium;
    private String moeda;
    private ArrayList<Voo> voos = new ArrayList<>();

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
        this.voos = new ArrayList<>(); // Inicializa a lista de voos no construtor
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

    public ArrayList<Voo> getVoos() {
        return voos;
    }

    public void setVoos(ArrayList<Voo> voos) {
        this.voos = voos;
    }

    public void addVoo(Voo voo) {
        this.voos.add(voo);
    }

    public int calcQuantidadeVoos() {
        int contadorVoo = 0;
        if (voos != null) {
            contadorVoo = voos.size();
            System.out.println("Total de voos: " + contadorVoo);
        } else {
            System.out.println("Nenhum voo encontrado.");
        }
        return contadorVoo;
    }

    public double calcTarifaTotal(){
        double totalTarifas = 0;
        if (voos != null) {
            for (Voo voo : voos) {
                totalTarifas += voo.getTarifa();
            }
        }
        double totalComTaxa = totalTarifas + (totalTarifas * taxaAgencia);
        System.out.println("Tarifa total (com taxa): " + totalComTaxa);
        return totalComTaxa;
    }

    public Bilhete emitirBilhete(Cliente cliente, Voo voo){
        if (!voos.contains(voo)){
            System.out.println("Erro: o voo não faz parte desta passagem.");
            return null;
        }
        if (voo.getAeroportoDeDestino().getPais().equalsIgnoreCase("Brasil") &&
                voo.getAeroportoDeOrigem().getPais().equalsIgnoreCase("Brasil")){
                //Siginica que o voo é domestico
            return new Bilhete(cliente, this, voo);
        } else {
            //Voo internacional
            return new Bilhete(cliente,this, voo);
        }
    }
}
