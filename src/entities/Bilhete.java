package entities;

import java.net.PasswordAuthentication;
import java.util.ArrayList;

public class Bilhete {
    private String nomePassageiro;
    private String documento;
    private ArrayList<Passagem> passagens = new ArrayList<>();
    private double valorTotal;
    private String moeda;

    public Bilhete() {}

    public Bilhete(String nomePassageiro, String documento, ArrayList<Passagem> passagens, double valorTotal, String moeda) {
        this.nomePassageiro = nomePassageiro;
        this.documento = documento;
        this.passagens = passagens;
        this.valorTotal = valorTotal;
        this.moeda = moeda;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }

    public ArrayList<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(ArrayList<Passagem> passagens) {
        this.passagens = passagens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public static Bilhete emitirBilhete(Compra compra){
        String nomePassageiro = compra.getViajante().getNomeCompleto();
        String documento = compra.getViajante().getDocumento();
        ArrayList<Passagem> passagens = compra.getPassagens();
        double valorTotal = compra.calcularValorTotal();
        String moeda = compra.getTipoMoeda();

        return new Bilhete(nomePassageiro, documento, passagens, valorTotal, moeda);
   }

    public void imprimirBilhete() {
        System.out.println("=== Bilhete de Passagem ===");
        System.out.println("Passageiro: " + nomePassageiro);
        System.out.println("Documento: " + documento);
        System.out.println("Passagens: ");
        for (Passagem passagem : passagens) {
            System.out.println("- " + passagem);
        }
        System.out.println("Valor Total: " + valorTotal + " " + moeda);

    }
}
