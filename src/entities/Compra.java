package entities;

import java.util.ArrayList;
import java.util.Scanner;


public class Compra {
    private Viajante viajante;
    private ArrayList<Compra> compras = new ArrayList<>();
    private ArrayList<Passagem> passagens = new ArrayList<>();
    private ArrayList<Voo> voos = new ArrayList<>();
    private String tipoTarifa;
    private double valorTotal;
    private String tipoMoeda;
    private static final double taxaAgencia = 0.02; //Taxa a definir

    public Compra() {
    }

    public Compra(Viajante viajante, ArrayList<Passagem> passagens, String tipoTarifa, String tipoMoeda) {
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

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(String tipoTarifa) {
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

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public double calcularValorTotal(ArrayList<Passagem> passagens, Viajante viajante, ArrayList<Voo> voos) {
        double valorTotalPassagens = 0;

        for (Passagem p : passagens) {
            // Verifica se a passagem pertence ao viajante
            if (p.getViajante().equals(viajante)) {
                valorTotalPassagens += p.calcularTarifaTotalDosVoos(voos, passagens, viajante);
            }
        }

        return valorTotalPassagens;
    }

    public double calcRemuneracaoAgencia(ArrayList<Passagem> passagens, Viajante viajante, ArrayList<Voo> voos) {

        double valorTotal = calcularValorTotal(passagens, viajante, voos);

        // Calcula a remuneração da agência com base na taxa
        return valorTotal * taxaAgencia;
    }

    public void comprarPassagem(ArrayList<Passagem> passagensDisponiveis, Viajante viajante) {
        if (viajante == null || viajante.getNomeCompleto() == null) {
            System.out.println("Erro: O viajante ou seus dados (nome e sobrenome) são inválidos.");
            return;
        }

        if (passagensDisponiveis == null || passagensDisponiveis.isEmpty()) {
            System.out.println("Não há passagens disponíveis.");
            return;
        }

        System.out.println("Passagens disponíveis:");
        for (int i = 0; i < passagensDisponiveis.size(); i++) {
            Passagem p = passagensDisponiveis.get(i);
            System.out.println((i + 1) + ". Voo: " + p.getVoo().getCodVoo() + " | Preço: " + p.getValorTarifa() + " | Destino: " + p.getVoo().getAeroportoDeDestino());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha o número da passagem que deseja comprar: ");
        int escolha = scanner.nextInt();

        if (escolha < 1 || escolha > passagensDisponiveis.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Passagem passagemEscolhida = passagensDisponiveis.get(escolha - 1);

        // Associar o viajante à passagem
        passagemEscolhida.setViajante(viajante);

        Voo voo = passagemEscolhida.getVoo();
        voo.setViajante(viajante);  // Também associa ao voo, se necessário

        System.out.println("Passagem comprada com sucesso para o viajante: " + passagemEscolhida.getViajante().getNomeCompleto() +
                " no voo: " + voo.getCodVoo() + " com destino a " + voo.getAeroportoDeDestino());

        scanner.close();
    }

    public Bilhete emitirBilhete(ArrayList<Compra> compras, Passagem passagem, ArrayList<Voo> voos, Viajante viajante) {
        double valorTotal = 0;
        for (Compra c : compras) {
            valorTotal += c.calcularValorTotal(c.getPassagens(), viajante, voos); // Acumula o valor total de todas as compras
        }
        this.tipoMoeda = passagem.getMoeda(); // Define a moeda da passagem

        // Retorna o bilhete com os detalhes do viajante e a passagem
        return new Bilhete(viajante.getNomeCompleto(), viajante.getDocumento(), passagens, valorTotal, tipoMoeda);
    }
}
