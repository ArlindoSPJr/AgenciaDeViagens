package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Aeroporto;
import entities.Bilhete;
import entities.CompanhiaAerea;
import entities.Compra;
import entities.Passagem;
import entities.Viajante;
import entities.Voo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BilheteTest {
   
    ArrayList<Passagem> passagens;
    Viajante viajante;
    Compra compra;
    ArrayList<Voo> voos;
    CompanhiaAerea ciaAerea;
    Aeroporto aero1;
    Aeroporto aero2;
    Voo voo;
    Passagem passagem;

    @BeforeEach
    public void setup() {
        passagens = new ArrayList<>();
        viajante = new Viajante("João", "Silva", "123456", 2);
        compra = new Compra(viajante, passagens, "premium", "USD");
        voos = new ArrayList<>();

        ciaAerea = new CompanhiaAerea("GOL", 12089, "Voo comercial", 50, 75, 12456);
        aero1 = new Aeroporto("Confins", "CNF", "Confins", "MG", "Brasil");
        aero2 = new Aeroporto("Guarulhos", "GRU", "Sao Paulo", "SP", "Estados unidos");

        voo = new Voo("XX1234", ciaAerea, aero1, aero2, 150,
                500.0, 1000.0, 1500.0,
                LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(5));

        // Adicionar o voo à lista, se necessário para os testes
        voos.add(voo);
    }
    @Test
    public void testEmitirBilhete() {
        // Simula a emissão do bilhete
        Bilhete bilhete = Bilhete.emitirBilhete(compra, voos, viajante);

        // Verifica os dados do bilhete
        assertNotNull(bilhete, "O bilhete não deve ser nulo.");
        assertEquals("João Silva", bilhete.getNomePassageiro(), "O nome do passageiro deve ser 'João Silva'.");
        assertEquals("123456", bilhete.getDocumento(), "O documento deve ser '123456'.");
        assertEquals("USD", bilhete.getMoeda(), "A moeda deve ser 'USD'.");
    }

    @Test
    public void testImprimirBilhete() {
        ArrayList<Passagem> passagens = new ArrayList<>();
        passagens.add(new Passagem(voo, "XX1234", "real", "premium", 300.0));
        Bilhete bilhete = new Bilhete("João Silva", "123456", passagens, 300.0, "USD");

        // Simula a impressão do bilhete
        bilhete.imprimirBilhete();

        // Verifica se o bilhete foi impresso corretamente (pode usar capturas de output para validar em testes avançados)
        assertEquals("João Silva", bilhete.getNomePassageiro(), "O nome do passageiro deve ser 'João Silva'.");
        assertEquals(1, bilhete.getPassagens().size(), "Deve haver uma passagem associada ao bilhete.");
        assertEquals(300.0, bilhete.getValorTotal(), "O valor total do bilhete deve ser $300.");
    }
}

