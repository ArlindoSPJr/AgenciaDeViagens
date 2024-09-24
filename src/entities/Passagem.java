package entities;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Scanner;

public class Passagem {
    private Voo voo;
    private Viajante viajante;
    private String codVoo;
    private String moeda;
    private String tipoTarifa;
    private double valorTarifa;
    private ArrayList<Voo> voos = new ArrayList<>();
    private ArrayList<Passagem> passagens = new ArrayList<>();

    public Passagem() {
    }

    public Passagem(Voo voo, String codVoo, String moeda, String tipoTarifa, double valorTarifa) {
        this.voo = voo;
        this.codVoo = codVoo;
        this.moeda = moeda;
        this.tipoTarifa = tipoTarifa;
        this.valorTarifa = valorTarifa;
    }

    public Viajante getViajante() {
        return viajante;
    }

    public void setViajante(Viajante viajante) {
        this.viajante = viajante;
    }

    public double getValorTarifa() {
        return valorTarifa;
    }

    public void setValorTarifa(double valorTarifa) {
        this.valorTarifa = valorTarifa;
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

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(String tipoTarifa) {
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


    public void cadastrarPassagem(ArrayList<Voo> voos, ArrayList<Passagem> passagens) {
        Scanner sc = new Scanner(System.in);

        // Escolher um voo
        System.out.println("Voos Disponíveis:");
        for (int i = 0; i < voos.size(); i++) {
            System.out.println((i + 1) + ". " + voos.get(i).getCodVoo());
        }
        System.out.println("Escolha um voo (digite o número correspondente):");
        int escolhaVoo = sc.nextInt();
        sc.nextLine();  // Consumir a linha

        if (escolhaVoo < 1 || escolhaVoo > voos.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Voo vooEscolhido = voos.get(escolhaVoo - 1);
        String codVoo = vooEscolhido.getCodVoo();
        String moeda;
        if(vooEscolhido.getAeroportoDeOrigem().getPais().equalsIgnoreCase("brasil") && vooEscolhido.getAeroportoDeDestino().getPais().equalsIgnoreCase("brasil")){
            moeda = "REAL";
        } else{
            moeda = "DOLAR";
        }

        double tarifaBasica = vooEscolhido.getTarifaBasica();
        double tarifaBusiness = vooEscolhido.getTarifaBusiness();
        double tarifaPremium = vooEscolhido.getTarifaPremium();

        // Exibir as opções de tarifas
        System.out.println("Escolha a tarifa desejada: ");
        System.out.println("Básica: $" + tarifaBasica);
        System.out.println("Business: $" + tarifaBusiness);
        System.out.println("Premium: $" + tarifaPremium);

        // Capturar a escolha do usuário
        System.out.println("Digite o tipo de tarifa (basica, business, premium):");
        String tipoTarifa = sc.nextLine().toLowerCase();

        double valorTarifa;

        // Definir o valor da tarifa com base na escolha do cliente
        switch (tipoTarifa) {
            case "basica":
                valorTarifa = tarifaBasica;
                break;
            case "business":
                valorTarifa = tarifaBusiness;
                break;
            case "premium":
                valorTarifa = tarifaPremium;
                break;
            default:
                System.out.println("Tipo de tarifa inválido!");
                return;
        }

        // Criar nova passagem com o valor correto da tarifa
        Passagem novaPassagem = new Passagem(vooEscolhido, codVoo, moeda, tipoTarifa, valorTarifa);

        // Adicionar à lista de passagens
        passagens.add(novaPassagem);

        System.out.println("Passagem cadastrada com sucesso! ");
        System.out.println(novaPassagem); // Exibe a nova passagem criada
    }


    public double calcValorBagagem(ArrayList<Voo> voos, Viajante viajante) {
        double sum = 0;
        for (Voo v : voos) {
            Viajante viajanteDoVoo = v.getViajante(); // Captura o viajante do voo

            if (viajanteDoVoo != null) { // Verifica se o viajante não é nulo
                int qntBagagens = viajanteDoVoo.getQntBagagens(); // Obtém a quantidade de bagagens

                if (qntBagagens == 1) {
                    sum += v.getCiaAerea().getValorPrimeiraBagagem();
                } else if (qntBagagens > 1) {
                    sum += v.getCiaAerea().getValorPrimeiraBagagem() +
                            (v.getCiaAerea().getValorBagagemAdicional() * (qntBagagens - 1));
                }
            } else {
                // Tratamento se o viajante for null
                System.out.println("Viajante está nulo para o voo: " + v);
            }
        }
        return sum;
    }


    public double calcularTarifaTotalDosVoos(ArrayList<Voo> voos, ArrayList<Passagem> passagens, Viajante viajante) {
        double valorTotal = 0;
        double qtdVoos = voos.size();
        double valorBagagens = calcValorBagagem(voos, viajante);
        double valorPassagem = 0;

        for (Passagem p : passagens){
            valorPassagem = p.getValorTarifa();
        }
        valorTotal = valorBagagens + valorPassagem;

        return valorTotal;
    }

    public void listarPassagens(ArrayList<Passagem> passagens) {
        if (passagens.isEmpty()) {
            System.out.println("Nenhuma passagem cadastrada.");
        } else {
            System.out.println("Lista de passagens:");
            for (Passagem p : passagens) {
                System.out.println(p);
            }
        }
    }


    @Override
    public String toString() {
        return  "Voo= " + voo + '\n' +
                "CodVoo= " + codVoo + '\n' +
                "Moeda= " + moeda + '\n' +
                "Tipo Tarifa= " + tipoTarifa + '\n' +
                "Valor Tarifa=" + valorTarifa;
    }
}
