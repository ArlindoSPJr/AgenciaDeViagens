package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String username;
    private String senha;
    private Funcionario funcionario;
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void cadastrarUsuaario(ArrayList<Usuario> usuarios, ArrayList<Funcionario> funcionarios) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira seu cpf de funcionario: ");
        String cpf = sc.nextLine();
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                System.out.println("Acessando sistema...");

                System.out.println("Digite seu username que deseja criar: ");
                String username = sc.nextLine();

                System.out.println("Digite sua senha que deseja criar: ");
                String senha = sc.nextLine();

                Usuario usuarioNovo = new Usuario(username, senha);
                usuarios.add(usuarioNovo);

                System.out.println("Usuario cadastrado com sucesso! ");
            } else {
                System.out.println("Funcionario inexistente! ");
            }
        }

    }

    public boolean fazerLogin(ArrayList<Usuario> usuarios) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu usernamw: ");
        String username = sc.nextLine();

        System.out.println("Digite sua senha: ");
        String senha = sc.nextLine();

        for (Usuario u : usuarios) {
            if (u.getUsername().equals(username) && u.getSenha().equals(senha)) {
                System.out.println("Usuario logado!");
                return true;
            }
        }
        System.out.println("Usuario inexistente!");
        return false;
    }
}
