package entities;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario {
    private String nome;
    private String cpf;
    private String email;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void listarFuncionarios(ArrayList<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("Lista de funcionários:");
            for (Funcionario f : funcionarios) {
                System.out.println(f);
            }
        }
    }

    public void cadastrarFuncionario(ArrayList<Funcionario> funcionarios){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite o cpf: ");
        String cpf = sc.nextLine();

        System.out.println("Digite o email: ");
        String email = sc.nextLine();

        Funcionario novoFuncionario = new Funcionario(nome, cpf, email);

        funcionarios.add(novoFuncionario);

        System.out.println("Funcionario cadastrado com sucesso: " + novoFuncionario);
    }

    @Override
    public String toString() {
        return  "Nome= " + nome + '\n' +
                "CPF= " + cpf + '\n' +
                "Email= " + email;
    }
}
