package test;

import entities.CompanhiaAerea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CompanhiaAereaTest {

    private CompanhiaAerea companhiaAerea;
    private ArrayList<CompanhiaAerea> ciasAereas;

    @BeforeEach
    public void setup() {
        // Inicializar os objetos necessários
        ciasAereas = new ArrayList<>();
        companhiaAerea = new CompanhiaAerea("GOL", 12089, "Voo Comercial GOL", 50, 75, 123456789);
    }

    @Test
    public void testCadastrarCompanhiaAerea() {
        // Simular o cadastro de uma nova companhia aérea
        CompanhiaAerea novaCia = new CompanhiaAerea("LATAM", 9876, "Voo Comercial LATAM", 55, 80, 987654321);
        ciasAereas.add(novaCia);

        // Verificar se a companhia foi adicionada à lista
        assertEquals(1, ciasAereas.size(), "Deveria haver uma companhia aérea cadastrada.");
        assertEquals("LATAM", ciasAereas.get(0).getNome(), "O nome da companhia cadastrada deveria ser 'LATAM'.");
        assertEquals(987654321, ciasAereas.get(0).getCnpj(), "O CNPJ da companhia deveria ser '987654321'.");
    }

    @Test
    public void testListarCompanhiasAereas() {
        // Testar a listagem de companhias aéreas
        ciasAereas.add(companhiaAerea);

        assertFalse(ciasAereas.isEmpty(), "A lista de companhias aéreas não deveria estar vazia.");
        assertEquals(1, ciasAereas.size(), "Deveria haver uma companhia aérea na lista.");
        assertEquals("GOL", ciasAereas.get(0).getNome(), "O nome da companhia aérea deve ser 'GOL'.");
    }

    @Test
    public void testValoresBagagem() {
        // Testar se os valores de bagagem estão corretos
        assertEquals(50, companhiaAerea.getValorPrimeiraBagagem(), "O valor da primeira bagagem deveria ser 50.");
        assertEquals(75, companhiaAerea.getValorBagagemAdicional(), "O valor da bagagem adicional deveria ser 75.");
    }

}
