package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Viajante {
    private String nome;
    private String ultimoSobrenome;
    private String documento;
    private ArrayList<Bilhete> bilhetes;
    private ArrayList<Viajante> viajantes = new ArrayList<>();

    public Viajante() {
    }

    public Viajante(String nome, String ultimoSobrenome, String documento) {
        this.nome = nome;
        this.ultimoSobrenome = ultimoSobrenome;
        this.documento = documento;
    }
    public String getNomeCompleto() {
        return nome + " " + ultimoSobrenome;
    }

    public String getUltimoSobrenome() {
        return ultimoSobrenome;
    }

    public void setUltimoSobrenome(String ultimoSobrenome) {
        this.ultimoSobrenome = ultimoSobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public ArrayList<Viajante> getViajantes() {
        return viajantes;
    }

    public void setViajantes(ArrayList<Viajante> viajantes) {
        this.viajantes = viajantes;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void cadastrarViajante(ArrayList<Viajante> viajantes){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do viajante: ");
        String nome = sc.nextLine();

        System.out.println("Digite o ultimo sobrenome do viajante: ");
        String ultimoSobrenome = sc.nextLine();

        System.out.println("Digite o documento do viajante: ");
        String documento = sc.nextLine();

        Viajante novoViajante = new Viajante(nome, ultimoSobrenome, documento);

        viajantes.add(novoViajante);

        System.out.println("Viajante cadastrado com sucesso: " + novoViajante);
    }

    public void listarViajantes(ArrayList<Viajante> viajantes) {
        if (viajantes.isEmpty()) {
            System.out.println("Nenhum viajante cadastrado.");
        } else {
            System.out.println("Lista de viajantes:");
            for (Viajante v : viajantes) {
                System.out.println(v);
            }
        }
    }

    @Override
    public String toString() {
        return "Viajante{" +
                "nome='" + nome + '\'' +
                ", ultimoSobrenome='" + ultimoSobrenome + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }
}
