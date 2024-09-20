package application;

import entities.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        //Criando cias aereas
        CompanhiaAerea gol = new CompanhiaAerea("GOL", 1,"GOL",3454);

        //Criando aeroporto
        Aeroporto aeroporto = new Aeroporto("Confins", "CNF", "Confins","MG", "Brasil");

        // Criando voos para a primeira passagem
        Voo voo1 = new Voo("AA254", gol, aeroporto,aeroporto,30,1000,2000,3000,LocalDateTime.now(), LocalDateTime.now());
        Voo voo2 = new Voo("BB200", gol, aeroporto,aeroporto,30,1000,2000,3000,LocalDateTime.now(), LocalDateTime.now());

        // Criando listas de voos para as passagens
        ArrayList<Voo> voos1 = new ArrayList<>();
        voos1.add(voo1);
        voos1.add(voo2);

        // Criando passagens
        Passagem passagem1 = new Passagem(voo1,"AA254","BRL",TipoTarifa.BASICA,100,200, voos1);
        Passagem passagem2 = new Passagem(voo2,"BB200","BRL",TipoTarifa.BASICA,100,200, voos1);

        // Criando uma lista de passagens
        ArrayList<Passagem> passagens = new ArrayList<>();
        passagens.add(passagem1);
        passagens.add(passagem2);

        // Criando um viajante
        Viajante viajante = new Viajante("Carlos", "Santos", "12345678900");

        // Criando uma compra com as passagens e o viajante
        Compra compra = new Compra(viajante,passagens,TipoTarifa.BASICA,"BRL");

        // Emitindo o bilhete com base na compra
        Bilhete bilhete = Bilhete.emitirBilhete(compra);

        // Imprimindo o bilhete
        bilhete.imprimirBilhete();
    }
}
