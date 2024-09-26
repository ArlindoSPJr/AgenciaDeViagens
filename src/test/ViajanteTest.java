package test;

import org.junit.jupiter.api.Test;

import entities.Viajante;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ViajanteTest {

    @Test
    public void testGetNomeCompleto() {
        Viajante viajante = new Viajante("João", "Silva", "123456", 2);
        assertEquals("João Silva", viajante.getNomeCompleto(), "O nome completo deve ser 'João Silva'.");
    }

    @Test
    public void testCadastrarViajante() {
        ArrayList<Viajante> viajantes = new ArrayList<>();
        Viajante viajante = new Viajante();

        // Simulação de entrada de dados
        String input = "João\nSilva\n123456\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Simula o cadastro de um viajante
        viajante.cadastrarViajante(viajantes);

        // Verifica se o viajante foi cadastrado corretamente
        assertEquals(1, viajantes.size(), "A lista de viajantes deve conter 1 viajante.");
        Viajante cadastrado = viajantes.get(0);
        assertNotNull(cadastrado, "O viajante cadastrado não deve ser nulo.");
        assertEquals("João", cadastrado.getNome(), "O nome do viajante deve ser 'João'.");
        assertEquals("Silva", cadastrado.getUltimoSobrenome(), "O sobrenome do viajante deve ser 'Silva'.");
        assertEquals("123456", cadastrado.getDocumento(), "O documento do viajante deve ser '123456'.");
        assertEquals(2, cadastrado.getQntBagagens(), "A quantidade de bagagens deve ser 2.");
    }


    @Test
    public void testListarViajantes() {
        ArrayList<Viajante> viajantes = new ArrayList<>();
        Viajante viajante1 = new Viajante("João", "Silva", "123456", 2);
        Viajante viajante2 = new Viajante("Maria", "Oliveira", "654321", 1);
        viajantes.add(viajante1);
        viajantes.add(viajante2);

        viajante1.listarViajantes(viajantes);

        // Verifica se a lista de viajantes está sendo listada corretamente
        assertEquals(2, viajantes.size(), "A lista de viajantes deve conter 2 viajantes.");
        assertEquals("João", viajantes.get(0).getNome(), "O primeiro viajante deve ser 'João'.");
        assertEquals("Maria", viajantes.get(1).getNome(), "O segundo viajante deve ser 'Maria'.");
    }
}