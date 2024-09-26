package test;


import entities.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class CompraTest {

    private Compra compra;
    private Viajante viajante;
    private ArrayList<Passagem> passagens;
    private ArrayList<Voo> voos;
    private ArrayList<Compra> compras;
    private CompanhiaAerea ciaAerea;
    private Aeroporto aeroportoOrigem;
    private Aeroporto aeroportoDestino;

    @Before
    public void setUp() {
        viajante = new Viajante("Nome teste", "Ultimo sobrenome", "222333", 2);
        passagens = new ArrayList<>();
        voos = new ArrayList<>();
        compra = new Compra(viajante, passagens, "basica", "REAL");
        compras = new ArrayList<>();
        ciaAerea = new CompanhiaAerea("Nome teste", 1, "Nome teste", 100, 200, 12345);
        aeroportoOrigem = new Aeroporto("CNF", "CNF", "CNF", "MG", "BRASIL");
        aeroportoDestino = new Aeroporto("GRU", "GRU", "GRU", "SP", "BRASIL");
    }

    @Test
    public void testGetViajante() {
        assertEquals(viajante, compra.getViajante());
    }

    @Test
    public void testSetViajante() {
        Viajante novoViajante = new Viajante("Novo Nome", "Novo ulrimo nome", "222555", 5);
        compra.setViajante(novoViajante);
        assertEquals(novoViajante, compra.getViajante());
    }

    @Test
    public void testGetValorTotal() {
        assertEquals(0, compra.getValorTotal());
    }

    @Test
    public void testSetValorTotal() {
        compra.setValorTotal(100.0);
        assertEquals(100.0, compra.getValorTotal());
    }

    @Test
    public void testGetTipoTarifa() {
        assertEquals("basica", compra.getTipoTarifa());
    }

    @Test
    public void testSetTipoTarifa() {
        compra.setTipoTarifa("Premium");
        assertEquals("Premium", compra.getTipoTarifa());
    }

    @Test
    public void testGetTipoMoeda() {
        assertEquals("REAL", compra.getTipoMoeda());
    }

    @Test
    public void testSetTipoMoeda() {
        compra.setTipoMoeda("DOLAR");
        assertEquals("DOLAR", compra.getTipoMoeda());
    }

    @Test
    public void testGetPassagens() {
        assertEquals(passagens, compra.getPassagens());
    }

    @Test
    public void testSetPassagens() {
        ArrayList<Passagem> novasPassagens = new ArrayList<>();
        compra.setPassagens(novasPassagens);
        assertEquals(novasPassagens, compra.getPassagens());
    }

    @Test
    public void testGetVoos() {
        assertEquals(voos, compra.getVoos());
    }

    @Test
    public void testSetVoos() {
        ArrayList<Voo> novosVoos = new ArrayList<>();
        compra.setVoos(novosVoos);
        assertEquals(novosVoos, compra.getVoos());
    }

    @Test
    public void testGetCompras() {
        assertEquals(compras, compra.getCompras());
    }

    @Test
    public void testSetCompras() {
        ArrayList<Compra> novasCompras = new ArrayList<>();
        compra.setCompras(novasCompras);
        assertEquals(novasCompras, compra.getCompras());
    }

    @Test
    public void testCalcularValorTotal() {
        Passagem passagem1 = new Passagem();
        passagem1.setValorTarifa(200);
        passagem1.setViajante(viajante);
        passagens.add(passagem1);

        Voo voo1 = new Voo("XX9999",ciaAerea,aeroportoOrigem,aeroportoDestino,21,100,200,300, LocalDateTime.now(),LocalDateTime.now());
        passagem1.setVoo(voo1);
        voos.add(voo1);

        double resultado = compra.calcularValorTotal(passagens, viajante, voos);
        assertEquals(200.0, resultado);
    }

    @Test
    public void testCalcRemuneracaoAgencia() {
        Passagem passagem1 = new Passagem();
        passagem1.setValorTarifa(200);
        passagem1.setViajante(viajante);
        passagens.add(passagem1);

        Voo voo1 = new Voo("XX9999",ciaAerea,aeroportoOrigem,aeroportoDestino,21,100,200,300,LocalDateTime.now(),LocalDateTime.now());
        passagem1.setVoo(voo1);
        voos.add(voo1);

        double resultado = compra.calcRemuneracaoAgencia(passagens, viajante, voos);
        assertEquals(4.0, resultado); // 2% de 200
    }

    @Test
    public void testEmitirBilhete() {
        // Configurar dados para o teste
        Viajante viajante = new Viajante("Nome Teste 2", "Ultimo nome teste 2", "1111222", 4);

        Passagem passagem1 = new Passagem();
        passagem1.setValorTarifa(200);
        passagem1.setViajante(viajante);

        // Configuração do voo
        Voo voo1 = new Voo("XX9999", ciaAerea, aeroportoOrigem, aeroportoDestino, 33, 100, 200, 300, LocalDateTime.now(), LocalDateTime.now());
        passagem1.setVoo(voo1);

        // Adiciona a passagem e voos a listas
        ArrayList<Passagem> passagens = new ArrayList<>();
        passagens.add(passagem1);

        ArrayList<Voo> voos = new ArrayList<>();
        voos.add(voo1);

        // Criar uma lista de compras
        ArrayList<Compra> compras = new ArrayList<>();
        Compra compra1 = new Compra(viajante, passagens, "Business", "REAL");
        compras.add(compra1);


        Bilhete bilhete = compra1.emitirBilhete(compras, passagens, voos, viajante);

        // Verificações
        assertEquals(viajante.getNomeCompleto(), bilhete.getNomePassageiro());
        assertEquals(viajante.getDocumento(), bilhete.getDocumento());
        assertEquals(passagens, bilhete.getPassagens());
        assertEquals(200.0, bilhete.getValorTotal(), 0.001); // Delta de precisão para double
        assertEquals("REAL", bilhete.getMoeda());
    }


}
