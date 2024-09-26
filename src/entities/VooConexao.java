package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class VooConexao extends Voo{
    private Aeroporto aeroportoIntermediario;
    private LocalDateTime dataHora_conexao;


    public VooConexao() {
    }


    public VooConexao(String codVoo, CompanhiaAerea ciaAerea, Aeroporto aeroportoDeOrigem, Aeroporto aeroportoDeDestino,int capacidade, double tarifaBasica, double tarifaBusiness, 
                      double tarifaPremium,LocalDateTime dataHora_chegada, LocalDateTime dataHora_saida, Aeroporto aeroportoIntermediario, LocalDateTime dataHora_conexao) {
        
        super(codVoo, ciaAerea, aeroportoDeOrigem, aeroportoDeDestino, capacidade, tarifaBasica, tarifaBusiness,tarifaPremium, dataHora_chegada, dataHora_saida);
        this.aeroportoIntermediario = aeroportoIntermediario;
        this.dataHora_conexao = dataHora_conexao;
    }

    public Aeroporto getAeroportoIntermediario() {
        return this.aeroportoIntermediario;
    }

    public void setAeroportoIntermediario(Aeroporto aeroportoIntermediario) {
        this.aeroportoIntermediario = aeroportoIntermediario;
    }

    public LocalDateTime getDataHora_conexao() {
        return this.dataHora_conexao;
    }

    public void setDataHora_conexao(LocalDateTime dataHora_conexao) {
        this.dataHora_conexao = dataHora_conexao;
    }

    @Override
    public void cadastrarVoo(ArrayList<CompanhiaAerea> ciasAereas, ArrayList<Aeroporto> aeroportos, ArrayList<Voo> voos) {
        Scanner scanner = new Scanner(System.in);


        if (ciasAereas.isEmpty()) {
            System.out.println("Nenhuma companhia aérea disponível. Cadastre uma companhia antes de criar um voo.");
            return;
        }


        if (aeroportos.isEmpty()) {
            System.out.println("Nenhum aeroporto disponível. Cadastre um aeroporto antes de criar um voo.");
            return;
        }


        System.out.println("Digite o código do voo no formato XX9999 (Duas letras e dois números):");
        String codVoo = scanner.nextLine();
        if (!verificaCodigoVoo(codVoo)){
            System.out.println("Codigo de voo digitado no formato inválido!");
            return;
        }


        System.out.println("Companhias Aéreas Disponíveis:");
        for (int i = 0; i < ciasAereas.size(); i++) {
            System.out.println((i + 1) + ". " + ciasAereas.get(i).getNome());
        }
        System.out.println("Escolha uma companhia aérea (digite o número correspondente):");
        int escolhaCompanhia = scanner.nextInt();
        scanner.nextLine();

        if (escolhaCompanhia < 1 || escolhaCompanhia > ciasAereas.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        CompanhiaAerea ciaEscolhida = ciasAereas.get(escolhaCompanhia - 1);


        System.out.println("Aeroportos Disponíveis (Origem):");
        for (int i = 0; i < aeroportos.size(); i++) {
            System.out.println((i + 1) + ". " + aeroportos.get(i).getNome());
        }
        System.out.println("Escolha o aeroporto de origem (digite o número correspondente):");
        int escolhaOrigem = scanner.nextInt();
        scanner.nextLine();
        if (escolhaOrigem < 1 || escolhaOrigem > aeroportos.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Aeroporto aeroportoDeOrigem = aeroportos.get(escolhaOrigem - 1);


        System.out.println("Aeroportos Disponíveis (Intermediário):");
        for (int i = 0; i < aeroportos.size(); i++) {
            System.out.println((i + 1) + ". " + aeroportos.get(i).getNome());
        }
        System.out.println("Escolha o aeroporto de intermediário (digite o número correspondente):");
        int escolhaIntermediario = scanner.nextInt();
        scanner.nextLine();  

        if (escolhaIntermediario < 1 || escolhaIntermediario > aeroportos.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Aeroporto aeroportoIntermediario = aeroportos.get(escolhaIntermediario - 1);


        System.out.println("Aeroportos Disponíveis (Destino):");
        for (int i = 0; i < aeroportos.size(); i++) {
            System.out.println((i + 1) + ". " + aeroportos.get(i).getNome());
        }
        System.out.println("Escolha o aeroporto de destino (digite o número correspondente):");
        int escolhaDestino = scanner.nextInt();
        scanner.nextLine();

        if (escolhaDestino < 1 || escolhaDestino > aeroportos.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Aeroporto aeroportoDeDestino = aeroportos.get(escolhaDestino - 1);

        if (aeroportoDeOrigem.equals(aeroportoIntermediario)) {
            System.out.println("O aeroporto de origem não pode ser igual ao aeroporto intermediário. Operação cancelada.");
            return;
        }
        
        if (aeroportoIntermediario.equals(aeroportoDeDestino)) {
            System.out.println("O aeroporto intermediário não pode ser igual ao aeroporto de destino. Operação cancelada.");
            return;
        }
        
        if (aeroportoDeDestino.equals(aeroportoIntermediario)) {
            System.out.println("O aeroporto de destino não pode ser igual ao aeroporto intermediário. Operação cancelada.");
            return;
        }


        System.out.println("Digite a capacidade do voo:");
        int capacidade = scanner.nextInt();

        System.out.println("Digite a tarifa básica do voo:");
        double tarifaBasica = scanner.nextDouble();

        System.out.println("Digite a tarifa business do voo:");
        double tarifaBusiness = scanner.nextDouble();

        System.out.println("Digite a tarifa premium do voo:");
        double tarifaPremium = scanner.nextDouble();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


        System.out.println("Digite a data e hora de saída (formato: DD/MM/AAAA HH:MM):");
        scanner.nextLine();
        LocalDateTime dataHora_saida = LocalDateTime.parse(scanner.nextLine(), formatter);

        System.out.println("Digite a data e hora do fim da conexão(formato: DD/MM/AAAA HH:MM):");
        LocalDateTime dataHora_conexao = LocalDateTime.parse(scanner.nextLine(), formatter);

        if (dataHora_conexao.isBefore(dataHora_saida)) {
            System.out.println("A data e hora da conexão não podem ser antes da data e hora de saída do voo de ida. Operação cancelada.");
            return;  
        }

        System.out.println("Digite a data e hora de chegada no destino final (formato: DD/MM/AAAA HH:MM):");
        LocalDateTime dataHora_chegada = LocalDateTime.parse(scanner.nextLine(), formatter);

        if (dataHora_chegada.isBefore(dataHora_conexao)) {
            System.out.println("A data e hora de chegada no destino final não podem ser antes da data e hora do fim da conexão. Operação cancelada.");
            return;  
        }

        // Criar o novo voo
        VooConexao novoVoo = new VooConexao(codVoo, ciaEscolhida, aeroportoDeOrigem, aeroportoDeDestino, capacidade, tarifaBasica, tarifaBusiness, tarifaPremium, dataHora_chegada, dataHora_saida, aeroportoIntermediario,dataHora_conexao);

        // Adicionar o voo à lista de voos
        voos.add(novoVoo);

        System.out.println("Voo cadastrado com sucesso! Código do Voo: " + codVoo);

    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Formatando as datas
        String dataChegadaFormatada = dataHora_chegada.format(formatter);
        String dataSaidaFormatada = dataHora_saida.format(formatter);
        String dataConexaoFormatada = dataHora_conexao.format(formatter);
    
        return  "Tipo de voo: COM CONEXÃO" + '\n' +
                "CodVoo= " + codVoo + '\n' +
                "CiaAerea= " + ciaAerea + '\n' +
                "Aeroporto De Origem= " + aeroportoDeOrigem + '\n' +
                "Aeroporto Intermediário = " + aeroportoIntermediario + '\n' +
                "Aeroporto De Destino= " + aeroportoDeDestino + '\n' +
                "Capacidade= " + capacidade + '\n' +
                "Tarifa Basica= " + tarifaBasica + '\n' +
                "Tarifa Business= " + tarifaBusiness + '\n' +
                "Tarifa Premium= " + tarifaPremium + '\n' +
                "Data/Hora saída= " + dataSaidaFormatada + '\n' +
                "Data/Hora fim conexão= " + dataConexaoFormatada + '\n' +
                "Data/Hora chegada= " + dataChegadaFormatada;
    }


}
