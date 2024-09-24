package entities;

import com.sun.source.tree.ReturnTree;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Voo {
    private String codVoo;
    private Viajante viajante;
    private CompanhiaAerea ciaAerea;
    private Aeroporto aeroportoDeOrigem;
    private Aeroporto aeroportoDeDestino;
    private int capacidade;
    private double tarifaBasica;
    private double tarifaBusiness;
    private double tarifaPremium;
    private LocalDateTime dataHora_chegada;
    private LocalDateTime dataHora_saida;
    private String moeda;
    private ArrayList<Voo> voos = new ArrayList<>();
    private ArrayList<CompanhiaAerea> ciasAereas = new ArrayList<>();
    private ArrayList<Aeroporto> aeroportos = new ArrayList<>();


    public Voo() {
    }

    public Voo(String codVoo, CompanhiaAerea ciaAerea, Aeroporto aeroportoDeOrigem, Aeroporto aeroportoDeDestino, int capacidade, double tarifaBasica, double tarifaBusiness, double tarifaPremium, LocalDateTime dataHora_chegada, LocalDateTime dataHora_saida, String moeda) {
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
        this.moeda = moeda;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public CompanhiaAerea getCiaAerea() {
        return ciaAerea;
    }

    public void setCiaAerea(CompanhiaAerea ciaAerea) {
        this.ciaAerea = ciaAerea;
    }

    public Viajante getViajante() {
        return viajante;
    }

    public void setViajante(Viajante viajante) {
        this.viajante = viajante;
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


    public boolean verificaCodigoVoo(String codVoo){
        if (codVoo.length() != 6){
            return false;
        }

        String prefixo = codVoo.substring(0,2);
        String sufixo = codVoo.substring(2,6);

        if (!prefixo.matches("[A-Z]{2}")){
            return false;
        }

        if ((!sufixo.matches("[0-9]{4}"))){
            return false;
        }

        return true;
    }

    public void cadastrarVoo(ArrayList<CompanhiaAerea> ciasAereas, ArrayList<Aeroporto> aeroportos, ArrayList<Voo> voos) {
        Scanner scanner = new Scanner(System.in);

        // Verificar se há companhias aéreas disponíveis
        if (ciasAereas.isEmpty()) {
            System.out.println("Nenhuma companhia aérea disponível. Cadastre uma companhia antes de criar um voo.");
            return;
        }

        // Verificar se há aeroportos disponíveis
        if (aeroportos.isEmpty()) {
            System.out.println("Nenhum aeroporto disponível. Cadastre um aeroporto antes de criar um voo.");
            return;
        }

        // Solicitar o código do voo
        System.out.println("Digite o código do voo no formato XX9999 (Duas letras e dois números):");
        String codVoo = scanner.nextLine();
        if (!verificaCodigoVoo(codVoo)){
            System.out.println("Codigo de voo digitado no formato inválido!");
            return;
        }


        // Escolher uma companhia aérea
        System.out.println("Companhias Aéreas Disponíveis:");
        for (int i = 0; i < ciasAereas.size(); i++) {
            System.out.println((i + 1) + ". " + ciasAereas.get(i).getNome());
        }
        System.out.println("Escolha uma companhia aérea (digite o número correspondente):");
        int escolhaCompanhia = scanner.nextInt();
        scanner.nextLine();  // Consumir a linha

        if (escolhaCompanhia < 1 || escolhaCompanhia > ciasAereas.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        CompanhiaAerea ciaEscolhida = ciasAereas.get(escolhaCompanhia - 1);

        // Escolher o aeroporto de origem
        System.out.println("Aeroportos Disponíveis (Origem):");
        for (int i = 0; i < aeroportos.size(); i++) {
            System.out.println((i + 1) + ". " + aeroportos.get(i).getNome());
        }
        System.out.println("Escolha o aeroporto de origem (digite o número correspondente):");
        int escolhaOrigem = scanner.nextInt();
        scanner.nextLine();  // Consumir a linha

        if (escolhaOrigem < 1 || escolhaOrigem > aeroportos.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Aeroporto aeroportoDeOrigem = aeroportos.get(escolhaOrigem - 1);

        // Escolher o aeroporto de destino
        System.out.println("Aeroportos Disponíveis (Destino):");
        for (int i = 0; i < aeroportos.size(); i++) {
            System.out.println((i + 1) + ". " + aeroportos.get(i).getNome());
        }
        System.out.println("Escolha o aeroporto de destino (digite o número correspondente):");
        int escolhaDestino = scanner.nextInt();
        scanner.nextLine();  // Consumir a linha

        if (escolhaDestino < 1 || escolhaDestino > aeroportos.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Aeroporto aeroportoDeDestino = aeroportos.get(escolhaDestino - 1);

        // Verificar se o aeroporto de origem é diferente do de destino
        if (aeroportoDeOrigem.equals(aeroportoDeDestino)) {
            System.out.println("O aeroporto de origem e destino não podem ser iguais. Operação cancelada.");
            return;
        }

        // Solicitar os outros dados do voo (capacidade, tarifas, horários, etc.)
        System.out.println("Digite a capacidade do voo:");
        int capacidade = scanner.nextInt();

        System.out.println("Digite a tarifa básica do voo:");
        double tarifaBasica = scanner.nextDouble();

        System.out.println("Digite a tarifa business do voo:");
        double tarifaBusiness = scanner.nextDouble();

        System.out.println("Digite a tarifa premium do voo:");
        double tarifaPremium = scanner.nextDouble();

       // Formatar as datas de saída e chegada no formato dd-MM-yyyy HH:mm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Solicitar a data e hora de saída e chegada com o novo formato
        System.out.println("Digite a data e hora de saída (formato: DD/MM/AAAA HH:MM):");
        scanner.nextLine(); // Consumir a quebra de linha
        LocalDateTime dataHora_saida = LocalDateTime.parse(scanner.nextLine(), formatter);

        System.out.println("Digite a data e hora de chegada (formato: DD/MM/AAAA HH:MM):");
        LocalDateTime dataHora_chegada = LocalDateTime.parse(scanner.nextLine(), formatter);

        System.out.println("Digite a moeda para o voo, se o voo for nacional, digite REAL, caso contrario digite DOLAR:");
        scanner.nextLine();
        String moeda = scanner.nextLine();

        // Criar o novo voo
        Voo novoVoo = new Voo(codVoo, ciaEscolhida, aeroportoDeOrigem, aeroportoDeDestino, capacidade,
                tarifaBasica, tarifaBusiness, tarifaPremium, dataHora_chegada, dataHora_saida, moeda);

        // Adicionar o voo à lista de voos
        voos.add(novoVoo);

        System.out.println("Voo cadastrado com sucesso! Código do Voo: " + codVoo);

    }


    public Voo buscarVoo(String codVoo, ArrayList<Voo> voos) {
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Formatando as datas
        String dataChegadaFormatada = dataHora_chegada.format(formatter);
        String dataSaidaFormatada = dataHora_saida.format(formatter);
    
        return "Voo{" +
                "codVoo='" + codVoo + '\'' +
                ", ciaAerea=" + ciaAerea +
                ", aeroportoDeOrigem=" + aeroportoDeOrigem +
                ", aeroportoDeDestino=" + aeroportoDeDestino +
                ", capacidade=" + capacidade +
                ", tarifaBasica=" + tarifaBasica +
                ", tarifaBusiness=" + tarifaBusiness +
                ", tarifaPremium=" + tarifaPremium +
                ", dataHora_saida=" + dataSaidaFormatada +
                ", dataHora_chegada=" + dataChegadaFormatada +
                '}';
    }
}
