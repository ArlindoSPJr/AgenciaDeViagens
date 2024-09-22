package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class CompanhiaAerea {
    private String nome;
    private int codigo;
    private String razaoSocial;
    private int cnpj;
    private ArrayList<Passagem> passagens = new ArrayList<>();
    private ArrayList<CompanhiaAerea> ciasAereas = new ArrayList<>();

    public CompanhiaAerea() {}

    public CompanhiaAerea(String nome, int codigo, String razaoSocial, int cnpj) {
        this.nome = nome;
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.ciasAereas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }


    public ArrayList<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(ArrayList<Passagem> passagens) {
        this.passagens = passagens;
    }

    public ArrayList<CompanhiaAerea> getCiasAereas() {
        return ciasAereas;
    }

    public void setCiasAereas(ArrayList<CompanhiaAerea> ciasAereas) {
        this.ciasAereas = ciasAereas;
    }

    public void  cadastrarCompanhiaAerea(ArrayList<CompanhiaAerea> ciasAereas) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome da Companhia Aérea: ");
        String nome = sc.nextLine();

        System.out.println("Digite o código da Companhia Aérea: ");
        int codigo = sc.nextInt();

        System.out.println("Digite a razão social da Companhia Aérea: ");
        sc.nextLine();  // Consumir a linha
        String razaoSocial = sc.nextLine();

        System.out.println("Digite o CNPJ da Companhia Aérea: ");
        int cnpj = sc.nextInt();

        // Criar e retornar a nova instância da Companhia Aérea
        CompanhiaAerea novaCia = new CompanhiaAerea(nome, codigo, razaoSocial, cnpj);
        ciasAereas.add(novaCia);


    }

    // Método para listar todas as companhias aéreas
    public void listarCompanhiasAereas(ArrayList<CompanhiaAerea> ciasAereas) {
        if (ciasAereas.isEmpty()) {
            System.out.println("Nenhuma companhia aérea cadastrada.");
        } else {
            System.out.println("Lista de companhias aéreas cadastradas:");
            for (CompanhiaAerea cia : ciasAereas) {
                System.out.println(cia);
            }
        }
    }

    @Override
    public String toString() {
        return "CompanhiaAerea{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj=" + cnpj +
                '}';
    }
}
