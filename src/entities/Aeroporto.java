package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Aeroporto {
    private String nome;
    private String sigla;
    private String cidade;
    private String estado;
    private String pais;
    private ArrayList<Voo> voos;
    private ArrayList<Aeroporto> aeroportos = new ArrayList<>();

    public Aeroporto() {}

    public Aeroporto(String nome, String sigla, String cidade, String estado, String pais) {
        this.nome = nome;
        this.sigla = sigla;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<Voo> getVoos() {
        return voos;
    }

    public void setVoos(ArrayList<Voo> voos) {
        this.voos = voos;
    }

    public ArrayList<Aeroporto> getAeroportos() {
        return aeroportos;
    }

    public void setAeroportos(ArrayList<Aeroporto> aeroportos) {
        this.aeroportos = aeroportos;
    }

    public void cadastrarAeroporto(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite a Sigla: ");
        String sigla = sc.nextLine();

        System.out.println("Digite a cidade: ");
        String cidade = sc.nextLine();

        System.out.println("Digite o estado: ");
        String estado = sc.nextLine();

        System.out.println("Digite o pa[is: ");
        String pais = sc.nextLine();

        Aeroporto novoAeroporto = new Aeroporto(nome, sigla, cidade, estado, pais);

        aeroportos.add(novoAeroporto);

        System.out.println("Aeroporto cadastrado com sucesso! " + novoAeroporto);
    }

    public void listarAeroporto() {
        if (aeroportos.isEmpty()) {
            System.out.println("Nenhum aeroporto cadastrado.");
        } else {
            System.out.println("Lista de aeroportos:");
            for (Aeroporto a : aeroportos) {
                System.out.println(a);
            }
        }
    }

    @Override
    public String toString() {
        return "Aeroporto{" +
                "nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
