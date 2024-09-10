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
}
