package test;

import entities.*;
import entities.CompanhiaAerea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PassagemTest {

    private Passagem passagem;
    private ArrayList<Voo> voos;
    private ArrayList<Passagem> passagens;
    private Voo voo;
    private Viajante viajante;

    @BeforeEach
    public void setUp() {
        passagens = new ArrayList<>();
        voos = new ArrayList<>();

        // Setup do aeroporto de origem e destino
        Aeroporto origem = new Aeroporto("Brasil", null, null, null, "GRU");
        Aeroporto destino = new Aeroporto("USA", null, null, null, "JFK");

        // Setup da cia aérea
        CompanhiaAerea ciaAerea = new CompanhiaAerea("GOL", 33, "GOL", 100, 50,0134); // Exemplo: $100 pela primeira bagagem, $50 por adicional

        // Setup de viajante com bagagens
        viajante = new Viajante("Fernando Dantas", null, null, 2); // 2 bagagens

        // Setup de voo
        voo = new Voo("123", ciaAerea, origem, destino, 300, 500, 1000, 0, LocalDateTime.now(), LocalDateTime.now());
        voo.setViajante(viajante);  // associar viajante ao voo

        // Adicionar voo à lista de voos
        voos.add(voo);

        // Instanciar uma passagem
        passagem = new Passagem(voo, "123", "DOLAR", "basica", 300);
    }

    @Test
    public void testCadastrarPassagem() {
        // Simula o cadastro de uma nova passagem
        passagem.cadastrarPassagem(voos, passagens);
        assertFalse(passagens.isEmpty(), "A lista de passagens não deveria estar vazia.");
        assertEquals(1, passagens.size(), "Deveria haver uma passagem cadastrada.");
        assertEquals(voo, passagens.getFirst().getVoo(), "O voo associado à passagem deve ser correto.");
    }

    @Test
    public void testBuscarPassagemPorCodigoVoo() {
        passagens.add(passagem);

        // Simula a busca por código do voo
        ArrayList<Passagem> encontradas = passagem.buscarPassagem(passagens);
        assertNotNull(encontradas, "A lista de passagens encontradas não deveria ser nula.");
        assertEquals(1, encontradas.size(), "Deveria encontrar 1 passagem.");
        assertEquals("123", encontradas.getFirst().getCodVoo(), "O código do voo deve ser '123'.");
    }

    @Test
    public void testBuscarPassagemPorHorario() {
        passagens.add(passagem);

        // Teste para buscar a passagem pelo horário de saída do voo
        ArrayList<Passagem> encontradas = passagem.buscarPassagem(passagens);
        assertNotNull(encontradas, "A lista de passagens encontradas não deveria ser nula.");
        assertEquals(1, encontradas.size(), "Deveria encontrar 1 passagem.");
        assertEquals(voo.getDataHora_saida(), encontradas.getFirst().getVoo().getDataHora_saida(),
                "O horário da passagem encontrada deve corresponder ao horário do voo.");
    }

    @Test
    public void testCalcularValorBagagem() {
        // Testa o cálculo do valor das bagagens
        double valorBagagem = passagem.calcValorBagagem(voos, viajante);
        assertEquals(150, valorBagagem, "O valor total das bagagens deveria ser $150 (100 pela primeira e 50 pela segunda).");
    }

    @Test
    public void testCalcularTarifaTotalDosVoos() {
        // Teste para verificar o cálculo total da tarifa dos voos mais o valor das bagagens
        passagens.add(passagem);

        double tarifaTotal = passagem.calcularTarifaTotalDosVoos(voos, passagens, viajante);
        assertEquals(450, tarifaTotal, "A tarifa total deveria ser 450 ($300 do voo + $150 das bagagens).");
    }

    @Test
    public void testListarPassagens() {
        // Adiciona uma passagem e verifica a listagem
        passagens.add(passagem);

        // Simula a listagem de passagens
        passagem.listarPassagens(passagens);
        assertFalse(passagens.isEmpty(), "A lista de passagens não deveria estar vazia.");
        assertEquals(1, passagens.size(), "Deveria haver uma passagem listada.");
        assertEquals("123", passagens.get(0).getCodVoo(), "O código do voo da passagem listada deve ser '123'.");
    }
}
