package entities;

public class Bilhete {
    private Cliente cliente;
    private Passagens passagens;

    public Bilhete() {
    }

    public Bilhete(Cliente cliente, Passagens passagens) {
        this.cliente = cliente;
        this.passagens = passagens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Passagens getPassagens() {
        return passagens;
    }

    public void setPassagens(Passagens passagens) {
        this.passagens = passagens;
    }

    
}
