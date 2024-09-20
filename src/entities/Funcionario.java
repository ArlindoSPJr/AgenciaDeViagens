package entities;

import java.util.ArrayList;

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

    public Funcionario buscarFuncionario(String cpf){
        for (Funcionario f : funcionarios){
            if (f.getCpf().equals(cpf)){
                return f;
            }
        }
        return null;
    }
}
