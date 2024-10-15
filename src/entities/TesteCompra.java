import entities;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TesteCompra {

    private Compra compra;
    private Viajante viajante;
    private ArrayList<Passagem> passagens;
    private ArrayList<Voo> voos;
    private ArrayList<Compra> compras;

    @Before
    void setUp() {
        viajante = new Viajante("Nome teste", "Ultimo sobrenome", "222333", 2);
        passagens = new ArrayList<>();
        voos = new ArrayList<>();
        compra = new Compra(viajante, passagens, "basica", "REAL");
        compras = new ArrayList<>();
    }

    @Test
    void testGetViajante() {
        assertEquals(viajante, compra.getViajante());
    }

    @Test
    void testSetViajante() {
        Viajante novoViajante = new Viajante("Novo Nome", "Novo ulrimo nome", "222555", 5);
        compra.setViajante(novoViajante);
        assertEquals(novoViajante, compra.getViajante());
    }

    @Test
    void testGetValorTotal() {
        assertEquals(0, compra.getValorTotal());
    }

    @Test
    void testSetValorTotal() {
        compra.setValorTotal(100.0);
        assertEquals(100.0, compra.getValorTotal());
    }

    @Test
    void testGetTipoTarifa() {
        assertEquals("basica", compra.getTipoTarifa());
    }

    @Test
    void testSetTipoTarifa() {
        compra.setTipoTarifa("Premium");
        assertEquals("Premium", compra.getTipoTarifa());
    }

    @Test
    void testGetTipoMoeda() {
        assertEquals("REAL", compra.getTipoMoeda());
    }

    @Test
    void testSetTipoMoeda() {
        compra.setTipoMoeda("DOLAR");
        assertEquals("DOLAR", compra.getTipoMoeda());
    }

    @Test
    void testGetPassagens() {
        assertEquals(passagens, compra.getPassagens());
    }

    @Test
    void testSetPassagens() {
        ArrayList<Passagem> novasPassagens = new ArrayList<>();
        compra.setPassagens(novasPassagens);
        assertEquals(novasPassagens, compra.getPassagens());
    }

    @Test
    void testGetVoos() {
        assertEquals(voos, compra.getVoos());
    }

    @Test
    void testSetVoos() {
        ArrayList<Voo> novosVoos = new ArrayList<>();
        compra.setVoos(novosVoos);
        assertEquals(novosVoos, compra.getVoos());
    }

    @Test
    void testGetCompras() {
        assertEquals(compras, compra.getCompras());
    }

    @Test
    void testSetCompras() {
        ArrayList<Compra> novasCompras = new ArrayList<>();
        compra.setCompras(novasCompras);
        assertEquals(novasCompras, compra.getCompras());
    }

    @Test
    void testCalcularValorTotal() {
        Passagem passagem1 = new Passagem();
        passagem1.setValorTarifa(200);
        passagem1.setViajante(viajante);
        passagens.add(passagem1);

        Voo voo1 = new Voo(1,"gol","gru","cnf",21,100,200,300,LocalDate.now(),LocalDate.now());
        passagem1.setVoo(voo1);
        voos.add(voo1);

        double resultado = compra.calcularValorTotal(passagens, viajante, voos);
        assertEquals(200.0, resultado);
    }

    @Test
    void testCalcRemuneracaoAgencia() {
        Passagem passagem1 = new Passagem();
        passagem1.setValorTarifa(200);
        passagem1.setViajante(viajante);
        passagens.add(passagem1);

        Voo voo1 = new Voo(1,"gol","gru","cnf",21,100,200,300,LocalDate.now(),LocalDate.now());
        passagem1.setVoo(voo1);
        voos.add(voo1);

        double resultado = compra.calcRemuneracaoAgencia(passagens, viajante, voos);
        assertEquals(4.0, resultado); // 2% de 200
    }

    @Test
void testEmitirBilhete() {
    // Configurar dados para o teste
    Viajante viajante = new Viajante("Nome Teste 2", "Ultimo nome teste 2", "1111222", 4);
    
    Passagem passagem1 = new Passagem();
    passagem1.setValorTarifa(200);
    passagem1.setViajante(viajante);
    
    Voo voo1 = new Voo(333, "gol", "gru", "cnf", 33,100,200,300, LocalDate.now(),LocalDate.now() );
    passagem1.setVoo(voo1);
    
    ArrayList<Passagem> passagens = new ArrayList<>();
    passagens.add(passagem1);
    
    ArrayList<Voo> voos = new ArrayList<>();
    voos.add(voo1);

    // Criar uma lista de compras
    ArrayList<Compra> compras = new ArrayList<>();
    Compra compra1 = new Compra(viajante, passagens, "Business", "REAL");
    compras.add(compra1);

    // Emitir o bilhete
    Bilhete bilhete = compra1.emitirBilhete(compras, passagem1, voos, viajante);

    
    assertEquals(viajante.getNomeCompleto(), bilhete.getNomeViajante());
    assertEquals(viajante.getDocumento(), bilhete.getDocumentoViajante());
    assertEquals(passagens, bilhete.getPassagens(),);
    assertEquals(200.0, bilhete.getValorTotal());
    assertEquals("REAL", bilhete.getMoeda());
}

}
