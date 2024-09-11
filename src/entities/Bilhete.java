package entities;

public class Bilhete {
    private Cliente cliente;
    private Passagens passagens;
    private Voo voo;


    public Bilhete(Cliente cliente, Passagens passagens, Voo voo) {
        this.cliente = cliente;
        this.passagens = passagens;
        this.voo = voo;
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

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    @Override
    public String toString() {
        return "Bilhete ->" +
                "cliente=" + cliente +
                ", passagens=" + passagens +
                ", voo=" + voo;
    }
}
