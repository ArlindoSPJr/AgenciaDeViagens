package entities;

public class Usuario {
    private String username;
    private String senha;
    private Funcionario funcionario;

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

//    public boolean login(String username, String senha){}
}
