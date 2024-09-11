package entities;

import java.time.LocalDateTime;

public class Voo {
    private int codVoo;
    private Aeroporto aeroportoDeOrigem;
    private Aeroporto aeroportoDeDestino;
    private int capacidade;
    private LocalDateTime dataHora_chegada;
    private LocalDateTime dataHora_saida;

    public Voo(){}

    public Voo(int codVoo, Aeroporto aeroportoDeOrigem, Aeroporto aeroportoDeDestino, int capacidade,
            LocalDateTime dataHora_chegada, LocalDateTime dataHora_saida) {
        this.codVoo = codVoo;
        this.aeroportoDeOrigem = aeroportoDeOrigem;
        this.aeroportoDeDestino = aeroportoDeDestino;
        this.capacidade = capacidade;
        this.dataHora_chegada = dataHora_chegada;
        this.dataHora_saida = dataHora_saida;
    }

    public int getCodVoo() {
        return codVoo;
    }

    public void setCodVoo(int codVoo) {
        this.codVoo = codVoo;
    }

    public Aeroporto getAeroportoDeOrigem() {
        return aeroportoDeOrigem;
    }

    public void setAeroportoDeOrigem(Aeroporto aeroportoDeOrigem) {
        this.aeroportoDeOrigem = aeroportoDeOrigem;
    }

    public Aeroporto getAeroportoDeDestino() {
        return aeroportoDeDestino;
    }

    public void setAeroportoDeDestino(Aeroporto aeroportoDeDestino) {
        this.aeroportoDeDestino = aeroportoDeDestino;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public LocalDateTime getDataHora_chegada() {
        return dataHora_chegada;
    }

    public void setDataHora_chegada(LocalDateTime dataHora_chegada) {
        this.dataHora_chegada = dataHora_chegada;
    }

    public LocalDateTime getDataHora_saida() {
        return dataHora_saida;
    }

    public void setDataHora_saida(LocalDateTime dataHora_saida) {
        this.dataHora_saida = dataHora_saida;
    }

    


}
