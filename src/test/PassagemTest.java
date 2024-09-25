package test;

import entities.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    ArrayList<Voo> voos = new ArrayList<>();
    
    voos.add(voo); 

    ArrayList<Passagem> passagens = new ArrayList<>();
    Passagem passagem = new Passagem();
    
    // Simula o cadastro de uma passagem
    String input = "1\nbasica\n"; // Supondo que você escolha o voo 1 e a tarifa básica
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    passagem.cadastrarPassagem(voos, passagens);
    
    // Verifica se a passagem foi cadastrada corretamente
    assertEquals(1, passagens.size(), "A lista de passagens deve conter 1 passagem.");
    Passagem cadastrado = passagens.get(0);
    assertNotNull(cadastrado, "A passagem cadastrada não deve ser nula.");
}

    @Test
public void testBuscarPassagemPorCodigoVoo() {
    passagens.add(passagem);

    // O código do voo a ser buscado (em formato de string)
    String input = "1\n123"; // 1 para escolher o critério de código e '123' como o código do voo
    
    // Simula a entrada do usuário usando ByteArrayInputStream
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Simula a busca por código do voo
    ArrayList<Passagem> encontradas = passagem.buscarPassagem(passagens);
    
    // Verificações
    assertNotNull(encontradas, "A lista de passagens encontradas não deveria ser nula.");
    assertEquals(1, encontradas.size(), "Deveria encontrar 1 passagem.");
    assertEquals("123", encontradas.get(0).getCodVoo(), "O código do voo deve ser '123'.");
}

    @Test
public void testBuscarPassagemPorHorario() {
    // Simulando a data e hora do voo (como exemplo)
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    String dataHoraSaida = "25/09/2024 14:30";
    LocalDateTime horarioSaida = LocalDateTime.parse(dataHoraSaida, formatter);

    // Configurando o voo com a data de saída correta
    voo.setDataHora_saida(horarioSaida);
    passagem.setVoo(voo);
    passagens.add(passagem);

    
    String input = "2\n25/09/2024 14:30"; 
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    
    ArrayList<Passagem> encontradas = passagem.buscarPassagem(passagens);

    
    assertNotNull(encontradas, "A lista de passagens encontradas não deveria ser nula.");
    assertEquals(1, encontradas.size(), "Deveria encontrar 1 passagem.");
    assertEquals(voo.getDataHora_saida(), encontradas.get(0).getVoo().getDataHora_saida(),
            "O horário da passagem encontrada deve corresponder ao horário do voo.");
}

@Test
public void testCalcularValorBagagem() {
    // Definindo os valores de bagagem para a companhia aérea
    voo.getCiaAerea().setValorPrimeiraBagagem(100);
    voo.getCiaAerea().setValorBagagemAdicional(50);

    // Testa o cálculo do valor das bagagens
    double valorBagagem = passagem.calcValorBagagem(voos, viajante);

    // Verifica se o valor calculado está correto
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
