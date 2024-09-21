package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

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
    private double valorTarifa;
    private ArrayList<Voo> voos = new ArrayList<>();
    private ArrayList<CompanhiaAerea> ciasAereas = new ArrayList<>();
    private ArrayList<Aeroporto> aeroportos = new ArrayList<>();

    public Voo() {
    }

    public Voo(String codVoo, CompanhiaAerea ciaAerea, Aeroporto aeroportoDeOrigem, Aeroporto aeroportoDeDestino, int capacidade, double tarifaBasica, double tarifaBusiness, double tarifaPremium, LocalDateTime dataHora_chegada, LocalDateTime dataHora_saida) {
        this.codVoo = codVoo;
        this.ciaAerea = ciaAerea;
        this.aeroportoDeDestino = aeroportoDeDestino;
        this.aeroportoDeOrigem = aeroportoDeOrigem;
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
                valorTarifa = this.tarifaBasica;
                break;
            case BUSINESS:
                valorTarifa = this.tarifaBusiness;
                break;
            case PREMIUM:
                valorTarifa = this.tarifaPremium;
                break;
        }
        return valorTarifa;
    }


    public void cadastrarVoo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do voo:");
        String codVoo = scanner.nextLine();

        ArrayList<CompanhiaAerea> companhiaAereasCadastradas = this.ciaAerea.getCiasAereas();

        // Apresentar as companhias aéreas disponíveis
        System.out.println("Companhias Aéreas Disponíveis:");
        for (CompanhiaAerea ca : companhiaAereasCadastradas){
            System.out.println(ca.getCiasAereas());
        }

        // Escolher uma companhia aérea pelo índice
        System.out.println("Escolha uma companhia aérea (digite o número correspondente):");
        int escolhaCompanhia = scanner.nextInt();
        scanner.nextLine();  // Consumir a linha após o número

        // Verifica se a escolha é válida
        if (escolhaCompanhia < 1 || escolhaCompanhia > companhiaAereasCadastradas.size()) {
            System.out.println("Escolha inválida. Operação cancelada.");
            return;
        }

        CompanhiaAerea ciaAereaEscolhida = companhiaAereasCadastradas.get(escolhaCompanhia);

        // Apresentar os aeroportos disponíveis
        System.out.println("Aeroportos Disponíveis:");
        for (int i = 0; i < aeroportos.size(); i++) {
            System.out.println((i + 1) + ". " + aeroportos.get(i));
        }

        // Escolher o aeroporto de origem pelo índice
        System.out.println("Escolha o aeroporto de origem (digite o número correspondente):");
        int escolhaOrigem = scanner.nextInt();
        scanner.nextLine();  // Consumir a linha

        // Verificar a escolha do aeroporto de origem
        if (escolhaOrigem < 1 || escolhaOrigem > aeroportos.size()) {
            System.out.println("Escolha inválida. Operação cancelada.");
            return;
        }

        Aeroporto aeroportoDeOrigem = aeroportos.get(escolhaOrigem - 1);

        // Escolher o aeroporto de destino pelo índice
        System.out.println("Escolha o aeroporto de destino (digite o número correspondente):");
        int escolhaDestino = scanner.nextInt();
        scanner.nextLine();  // Consumir a linha

        // Verificar a escolha do aeroporto de destino
        if (escolhaDestino < 1 || escolhaDestino > aeroportos.size()) {
            System.out.println("Escolha inválida. Operação cancelada.");
            return;
        }

        Aeroporto aeroportoDeDestino = aeroportos.get(escolhaDestino - 1);

        // Verificar se o aeroporto de origem é diferente do de destino
        if (aeroportoDeOrigem.equals(aeroportoDeDestino)) {
            System.out.println("O aeroporto de origem e destino não podem ser iguais. Operação cancelada.");
            return;
        }

        // Continuar a entrada dos outros dados do voo
        System.out.println("Digite a capacidade:");
        int capacidade = scanner.nextInt();

        System.out.println("Digite a tarifa básica:");
        double tarifaBasica = scanner.nextDouble();

        System.out.println("Digite a tarifa business:");
        double tarifaBusiness = scanner.nextDouble();

        System.out.println("Digite a tarifa premium:");
        double tarifaPremium = scanner.nextDouble();

        System.out.println("Digite a data e hora de saída (no formato: AAAA-MM-DDTHH:MM):");
        LocalDateTime dataHora_saida = LocalDateTime.parse(scanner.next());

        System.out.println("Digite a data e hora de chegada (no formato: AAAA-MM-DDTHH:MM):");
        LocalDateTime dataHora_chegada = LocalDateTime.parse(scanner.next());

        // Criar novo voo
        Voo novoVoo = new Voo(codVoo, ciaAereaEscolhida, aeroportoDeOrigem, aeroportoDeDestino, capacidade,
                tarifaBasica, tarifaBusiness, tarifaPremium, dataHora_chegada, dataHora_saida);

        // Adicionar o voo à lista
        voos.add(novoVoo);

        System.out.println("Voo cadastrado com sucesso: " + novoVoo);
    }

    public Voo buscarVoo(String codVoo) {
        for (Voo v : voos) {
            if (v.getCodVoo().equalsIgnoreCase(codVoo)) {
                return v;
            }
        }
        return null;
    }

    public void listarVoos() {
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo cadastrado.");
        } else {
            System.out.println("Lista de voos cadastrados:");
            for (Voo v : voos) {
                System.out.println(v);
            }
        }
    }


    @Override
    public String toString() {
        return "Voo{" +
                "codVoo='" + codVoo + '\'' +
                ", ciaAerea=" + ciaAerea +
                ", aeroportoDeOrigem=" + aeroportoDeOrigem +
                ", aeroportoDeDestino=" + aeroportoDeDestino +
                ", capacidade=" + capacidade +
                ", tarifaBasica=" + tarifaBasica +
                ", tarifaBusiness=" + tarifaBusiness +
                ", tarifaPremium=" + tarifaPremium +
                ", dataHora_chegada=" + dataHora_chegada +
                ", dataHora_saida=" + dataHora_saida +
                '}';
    }
}
