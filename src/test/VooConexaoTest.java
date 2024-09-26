package test;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import entities.Aeroporto;
import entities.CompanhiaAerea;
import entities.Voo;
import entities.VooConexao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VooConexaoTest {

    private VooConexao vooConexao;
    private CompanhiaAerea ciaAerea;
    private Aeroporto aeroportoOrigem;
    private Aeroporto aeroportoDestino;
    private Aeroporto aeroportoIntermediario;

    @Before
    public void setUp() {
        // Configuração inicial antes de cada teste
        ciaAerea = new CompanhiaAerea("ABC1234", 0, "AZUL", 0, 0, 0);
        aeroportoOrigem = new Aeroporto("Confins", "CNF", null, null, null);
        aeroportoDestino = new Aeroporto("GUARULHOS", "GU", null, null, null);
        aeroportoIntermediario = new Aeroporto("Santos Dumond", "SDM", null, null, null);
        vooConexao = new VooConexao("AA1234", ciaAerea, aeroportoOrigem, aeroportoDestino, 
                                     180, 500.0, 1000.0, 1500.0,
                                     LocalDateTime.parse("26/12/2024 10:30", 
                                     DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                                     LocalDateTime.parse("25/12/2024 15:30", 
                                     DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                                     aeroportoIntermediario, 
                                     LocalDateTime.parse("25/12/2024 19:00", 
                                     DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
    }

    @Test
    public void testCadastrarVoo() {
        ArrayList<CompanhiaAerea> ciasAereas = new ArrayList<>();
        ciasAereas.add(ciaAerea);

        ArrayList<Aeroporto> aeroportos = new ArrayList<>();
        aeroportos.add(aeroportoOrigem);
        aeroportos.add(aeroportoDestino);
        aeroportos.add(aeroportoIntermediario);

        ArrayList<Voo> voos = new ArrayList<>();
        vooConexao.cadastrarVoo(ciasAereas, aeroportos, voos);

        assertEquals(1, voos.size());
        assertEquals("AA1234", voos.get(0).getCodVoo());
        assertEquals(ciaAerea, voos.get(0).getCiaAerea());
        assertEquals(aeroportoOrigem, voos.get(0).getAeroportoDeOrigem());
        assertEquals(aeroportoDestino, voos.get(0).getAeroportoDeDestino());
        assertEquals(aeroportoIntermediario, ((VooConexao) voos.get(0)).getAeroportoIntermediario());
    }

    @Test
    public void testDataHoraConexaoAntesDataHoraSaida() {
        vooConexao.setDataHora_conexao(LocalDateTime.parse("25/12/2024 14:30", 
                                      DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        
        ArrayList<CompanhiaAerea> ciasAereas = new ArrayList<>();
        ciasAereas.add(ciaAerea);

        ArrayList<Aeroporto> aeroportos = new ArrayList<>();
        aeroportos.add(aeroportoOrigem);
        aeroportos.add(aeroportoDestino);
        aeroportos.add(aeroportoIntermediario);

        ArrayList<Voo> voos = new ArrayList<>();

        // Testa a validação se a data da conexão é antes da saída
        try {
            vooConexao.cadastrarVoo(ciasAereas, aeroportos, voos);
            fail("Deveria ter lançado uma exceção sobre a data da conexão");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("A data e hora da conexão não podem ser antes da data e hora de saída do voo de ida."));
        }
    }

    @Test
    public void testDataHoraChegadaAntesDataHoraConexao() {
        vooConexao.setDataHora_chegada(LocalDateTime.parse("25/12/2024 18:00", 
                                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

        ArrayList<CompanhiaAerea> ciasAereas = new ArrayList<>();
        ciasAereas.add(ciaAerea);

        ArrayList<Aeroporto> aeroportos = new ArrayList<>();
        aeroportos.add(aeroportoOrigem);
        aeroportos.add(aeroportoDestino);
        aeroportos.add(aeroportoIntermediario);

        ArrayList<Voo> voos = new ArrayList<>();

        // Testa a validação se a data de chegada é antes da conexão
        try {
            vooConexao.cadastrarVoo(ciasAereas, aeroportos, voos);
            fail("Deveria ter lançado uma exceção sobre a data de chegada");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("A data e hora de chegada no destino final não podem ser antes da data e hora do fim da conexão."));
        }
    }
}
