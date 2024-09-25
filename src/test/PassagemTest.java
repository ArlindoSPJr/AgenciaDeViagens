package test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Aeroporto;
import entities.Passagem;
import entities.Viajante;
import entities.Voo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class PassagemTest {

    private Passagem passagem;
    private ArrayList<Voo> voos;
    private ArrayList<Passagem> passagens;
    private Voo voo;
    private Viajante viajante;

    @BeforeEach
    public void setUp() {
        voos = new ArrayList<>();
        passagens = new ArrayList<>();
        
        // Criando exemplo de voo e viajante para os testes
        viajante = new Viajante("Fernando Dantas", null, null, 2); // viajante com 2 bagagens
        voo = new Voo("1", null, new Aeroporto("Brasil", null, null, null, null), new Aeroporto("USA", null, null, null, null), 300, 500, 1000, 0, null, null);
        voo.setViajante(viajante); // associando viajante ao voo
        voos.add(voo);
        
        passagem = new Passagem();
    }

    @Test
    public void testCadastrarPassagem() {
        // Simulando o cadastro de uma passagem (executado diretamente)
        passagem.cadastrarPassagem(voos, passagens);
        assertFalse(passagens.isEmpty(), "A lista de passagens não deveria estar vazia.");
    }

    @Test
    public void testBuscarPassagem() {
        // Adiciona uma passagem à lista
        Passagem novaPassagem = new Passagem(voo, "V123", "DOLAR", "basica", 300);
        passagens.add(novaPassagem);
        
        // Busca a passagem pelo código
        Passagem encontrada = passagem.buscarPassagem(passagens);
        assertNotNull(encontrada, "Passagem deveria ter sido encontrada.");
        assertEquals("V123", encontrada.getCodVoo(), "Código de voo deveria ser V123.");
    }

    @Test
    public void testCalcularValorBagagem() {
        // Teste para verificar o cálculo da bagagem
        double valorBagagem = passagem.calcValorBagagem(voos, viajante);
        assertEquals(150, valorBagagem, "Valor da bagagem deveria ser 150.");
    }

    @Test
    public void testCalcularTarifaTotalDosVoos() {
        // Teste para verificar o cálculo total da tarifa dos voos e bagagens
        Passagem novaPassagem = new Passagem(voo, "V123", "DOLAR", "basica", 300);
        passagens.add(novaPassagem);
        
        double tarifaTotal = passagem.calcularTarifaTotalDosVoos(voos, passagens, viajante);
        assertEquals(450, tarifaTotal, "Tarifa total deveria ser 450.");
    }

    @Test
    public void testListarPassagens() {
        // Teste para verificar a listagem de passagens
        Passagem novaPassagem = new Passagem(voo, "V123", "DOLAR", "basica", 300);
        passagens.add(novaPassagem);

        // Vamos capturar a saída para verificar se a passagem está sendo listada
        passagem.listarPassagens(passagens);
        assertFalse(passagens.isEmpty(), "A lista de passagens não deveria estar vazia.");
    }
}