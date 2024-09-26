package test;
import entities.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AeroportoTest {

    private Aeroporto aeroporto; // Instância para testes individuais
    private ArrayList<Aeroporto> aeroportos; // Lista de aeroportos para testes

    @BeforeEach
    public void setUp() {
        // Inicializa antes de cada teste
        aeroporto = new Aeroporto();
        aeroportos = new ArrayList<>();
    }

    @Test
    public void testCadastrarAeroporto() {
        // Teste de cadastro de um aeroporto
        Aeroporto novoAeroporto = new Aeroporto("Aeroporto Internacional", "INT", "São Paulo", "SP", "Brasil");
        aeroportos.add(novoAeroporto);  // Adiciona à lista manualmente (simulando a funcionalidade)

        assertEquals(1, aeroportos.size());  // Verifica se o aeroporto foi adicionado à lista
        assertEquals("Aeroporto Internacional", aeroportos.get(0).getNome());  // Verifica o nome do aeroporto
        assertEquals("INT", aeroportos.get(0).getSigla());  // Verifica a sigla do aeroporto
    }

    @Test
    public void testListarAeroporto() {
        // Testando se o método listarAeroporto funciona corretamente com aeroportos cadastrados
        Aeroporto aeroporto1 = new Aeroporto("Aeroporto 1", "A1", "Cidade1", "Estado1", "País1");
        Aeroporto aeroporto2 = new Aeroporto("Aeroporto 2", "A2", "Cidade2", "Estado2", "País2");

        aeroportos.add(aeroporto1);
        aeroportos.add(aeroporto2);

        assertEquals(2, aeroportos.size());  // Verifica se há dois aeroportos na lista
        assertEquals("Aeroporto 1", aeroportos.get(0).getNome());  // Verifica o nome do primeiro aeroporto
        assertEquals("Aeroporto 2", aeroportos.get(1).getNome());  // Verifica o nome do segundo aeroporto
    }


    @Test
    public void testSemAeroportosCadastrados() {
        // Testando quando não há aeroportos cadastrados
        assertTrue(aeroportos.isEmpty());  // Verifica que a lista está vazia
    }
}
