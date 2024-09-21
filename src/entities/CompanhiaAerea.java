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

   public void cadastrarCompanhiaAerea(){
       Scanner sc = new Scanner(System.in);

       System.out.println("Digite o nome da Companhia Aerea: ");
       String nome = sc.nextLine();

       System.out.println("Digite o codigo da Companhia Aerea: ");
       int codigo = sc.nextInt();

       System.out.println("Digite a razão social da Companhia Aerea: ");
       sc.nextLine();
       String razaoSocial = sc.nextLine();

       System.out.println("Digite o cnpj da Companhia Aerea: ");
       int cnpj = sc.nextInt();

       CompanhiaAerea novaCiaAerea = new CompanhiaAerea(nome, codigo, razaoSocial, cnpj);

       ciasAereas.add(novaCiaAerea);

       System.out.println("Companhia Aerea cadastrada com sucesso: " + novaCiaAerea);
   }

   public void listarCompanhiasAereas(){
       if (ciasAereas.isEmpty()) {
           System.out.println("Nenhum companhia aerea cadastrado.");
       } else {
           System.out.println("Lista de companhias aereas:");
           for (CompanhiaAerea ca : ciasAereas) {
               System.out.println(ca);
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
