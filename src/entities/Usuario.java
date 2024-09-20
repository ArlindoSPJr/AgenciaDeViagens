package entities;

import java.util.ArrayList;

public class Usuario {
    private String username;
    private String senha;
    private Funcionario funcionario;
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Usuario() {}

    public Usuario(String username, String senha, Funcionario funcionario) {
        this.username = username;
        this.senha = senha;
        this.funcionario = funcionario;
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

    public boolean fazerLogin(String username, String senha){
        for (Usuario u : usuarios){
            if (u.getUsername().equals(username) && u.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
}
