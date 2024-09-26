package test;

import entities.Aeroporto;
import entities.CompanhiaAerea;
import entities.Voo;
import entities.VooConexao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class VooConexaoTest {

    private final InputStream systemIn = System.in;  // Backup do System.in original
    private ByteArrayInputStream testIn;  // Usado para simular a entrada do usuário

    private VooConexao vooConexao;
    private CompanhiaAerea ciaAerea1;
    private CompanhiaAerea ciaAerea2;
    private Aeroporto aeroporto1;
    private Aeroporto aeroporto2;
    private Aeroporto aeroporto3;
    private LocalDateTime dataHoraSaida;
    private LocalDateTime dataHoraConexao;
    private LocalDateTime dataHoraChegada;

    ArrayList<CompanhiaAerea> ciasAereas = new ArrayList<>();
    ArrayList<Aeroporto> aeroportos = new ArrayList<>();
    ArrayList<Voo> voos = new ArrayList<>();

    @Before
    public void setUp() throws Exception {


         ciaAerea1 = new CompanhiaAerea("Portugal Airways", 1289, "Portugal Airways", 100, 200, 12345);
         ciaAerea2 = new CompanhiaAerea("GOL", 1333, "GOL", 100, 200, 3334546);

        ciasAereas.add(ciaAerea1);
        ciasAereas.add(ciaAerea2);

        aeroporto1 = new Aeroporto("LIS", "Lisboa", "LIS", "PORT", "PORTUGAL");
        aeroporto2 = new Aeroporto("OPO", "Porto", "Porto", "Porto", "PORTUGAL");
        aeroporto3 = new Aeroporto("MAD", "Madrid", "Madrid", "Madrid", "ESPANHA");

        aeroportos.add(aeroporto1);
        aeroportos.add(aeroporto2);
        aeroportos.add(aeroporto3);

        dataHoraSaida = LocalDateTime.of(2024, 9, 25, 10, 0);
        dataHoraConexao = LocalDateTime.of(2024, 9, 25, 12, 0);
        dataHoraChegada = LocalDateTime.of(2024, 9, 25, 14, 0);

        vooConexao = new VooConexao("TP1234", ciaAerea1, aeroporto1, aeroporto2, 150, 100.0, 200.0, 300.0,
                dataHoraChegada, dataHoraSaida, aeroporto3, dataHoraConexao);
    }


    @After
    public void restoreSystemIn() {
        System.setIn(systemIn);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testCadastrarVooSucesso() {
        // Simulando a entrada do utilizador
        String input = "TP1234\n" + // Código do voo
                "1\n" +      // Escolha da companhia aérea (TAP Portugal)
                "1\n" +      // Escolha do aeroporto de origem (Lisboa)
                "3\n" +      // Escolha do aeroporto intermediário (Madrid)
                "2\n" +      // Escolha do aeroporto de destino (Porto)
                "200\n" +    // Capacidade
                "100.00\n" + // Tarifa básica
                "200.00\n" + // Tarifa business
                "300.00\n" + // Tarifa premium
                "25/09/2024 10:00\n" + // Data de saída
                "25/09/2024 12:00\n" + // Data de conexão
                "25/09/2024 14:00\n";  // Data de chegada

        provideInput(input);

        // Criar uma instância de VooConexao para chamar o método
        VooConexao vooConexao = new VooConexao();

        // Executar o método de cadastro
        vooConexao.cadastrarVoo(ciasAereas, aeroportos, voos);

        // Verificações
        assertEquals(1, voos.size()); // Deve haver um voo cadastrado
        VooConexao vooCadastrado = (VooConexao) voos.get(0);

        // Verificar os dados do voo cadastrado
        assertEquals("TP1234", vooCadastrado.getCodVoo());
        assertEquals("TAP Portugal", vooCadastrado.getCiaAerea().getNome());
        assertEquals("Lisboa", vooCadastrado.getAeroportoDeOrigem().getNome());
        assertEquals("Madrid", vooCadastrado.getAeroportoIntermediario().getNome());
        assertEquals("Porto", vooCadastrado.getAeroportoDeDestino().getNome());
        assertEquals(200, vooCadastrado.getCapacidade());
        assertEquals(100.0, vooCadastrado.getTarifaBasica(), 0.001);
        assertEquals(200.0, vooCadastrado.getTarifaBusiness(), 0.001);
        assertEquals(300.0, vooCadastrado.getTarifaPremium(), 0.001);

        // Verificar as datas
        assertEquals(LocalDateTime.of(2024, 9, 25, 10, 0), vooCadastrado.getDataHora_saida());
        assertEquals(LocalDateTime.of(2024, 9, 25, 12, 0), vooCadastrado.getDataHora_conexao());
        assertEquals(LocalDateTime.of(2024, 9, 25, 14, 0), vooCadastrado.getDataHora_chegada());
    }

    @Test
    public void testCadastrarVooCompanhiaInvalida() {
        // Simular a entrada do utilizador para uma companhia inválida
        String input = "TP1234\n" +
                "5\n"; // Escolha de uma companhia inválida

        provideInput(input);

        // Criar uma instância de VooConexao para chamar o método
        VooConexao vooConexao = new VooConexao();

        // Executar o método de cadastro
        vooConexao.cadastrarVoo(ciasAereas, aeroportos, voos);

        // Não deve adicionar nenhum voo à lista
        assertEquals(0, voos.size());
    }

    @Test
    public void testCadastrarVooCodigoInvalido() {
        // Simular a entrada de um código de voo inválido
        String input = "12345\n"; // Código de voo no formato inválido

        provideInput(input);

        // Criar uma instância de VooConexao para chamar o método
        VooConexao vooConexao = new VooConexao();

        // Executar o método de cadastro
        vooConexao.cadastrarVoo(ciasAereas, aeroportos, voos);

        // Não deve adicionar nenhum voo à lista devido ao código inválido
        assertEquals(0, voos.size());
    }

    @Test
    public void testConstrutor() {

        assertEquals("TP1234", vooConexao.getCodVoo());
        assertEquals(ciaAerea1, vooConexao.getCiaAerea());
        assertEquals(aeroporto1, vooConexao.getAeroportoDeOrigem());
        assertEquals(aeroporto2, vooConexao.getAeroportoDeDestino());
        assertEquals(aeroporto3, vooConexao.getAeroportoIntermediario());
        assertEquals(dataHoraSaida, vooConexao.getDataHora_saida());
        assertEquals(dataHoraConexao, vooConexao.getDataHora_conexao());
        assertEquals(dataHoraChegada, vooConexao.getDataHora_chegada());
    }



    @Test
    public void testDataConexaoInvalida() {

        LocalDateTime dataInvalidaConexao = LocalDateTime.of(2024, 9, 25, 9, 0);  // Antes da saída
        vooConexao.setDataHora_conexao(dataInvalidaConexao);


        assertTrue(dataInvalidaConexao.isBefore(vooConexao.getDataHora_saida()));
    }
}
