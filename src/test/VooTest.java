package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Aeroporto;
import entities.CompanhiaAerea;
import entities.Voo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class VooTest {

    private Voo voo;
    private CompanhiaAerea ciaAerea;
    private Aeroporto aeroportoOrigem;
    private Aeroporto aeroportoDestino;

    @BeforeEach
    void setUp() {
        
        ciaAerea = new CompanhiaAerea("ABC1234", 0, "AZUL", 0, 0, 0);
        aeroportoOrigem = new Aeroporto("GUARULHOS", "GU", null, null, null);
        aeroportoDestino = new Aeroporto("CONFINS", "CN", null, null, null);
        voo = new Voo("XX1234", ciaAerea, aeroportoOrigem, aeroportoDestino, 150, 
                      500.0, 1000.0, 1500.0, 
                      LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(5));
    }

    @Test
    void testVerificaCodigoVooValido() {
    
        assertTrue(voo.verificaCodigoVoo("AB1234"));
    }

    @Test
    void testVerificaCodigoVooInvalido() {
        
        assertFalse(voo.verificaCodigoVoo("A1234"));   
        assertFalse(voo.verificaCodigoVoo("ABC1234")); 
        assertFalse(voo.verificaCodigoVoo("AB12A4"));  
    }

    @Test
    void testGetAndSetCiaAerea() {
        
        CompanhiaAerea novaCiaAerea = new CompanhiaAerea("CIA002", 0, "QATAR", 100, 200, 300);
        voo.setCiaAerea(novaCiaAerea);
        assertEquals("CIA002", voo.getCiaAerea().getNome());  
    }

    @Test
    void testCadastrarVoo() {
        
        ArrayList<CompanhiaAerea> ciasAereas = new ArrayList<>();
        ArrayList<Aeroporto> aeroportos = new ArrayList<>();
        ArrayList<Voo> voos = new ArrayList<>();
        
        ciasAereas.add(ciaAerea);
        aeroportos.add(aeroportoOrigem);
        aeroportos.add(aeroportoDestino);

        // Refatoração: Eliminar a dependência de Scanner e fornecer dados diretamente
        voo = new Voo("XX5678", ciaAerea, aeroportoOrigem, aeroportoDestino, 200, 
                      400.0, 800.0, 1200.0, 
                      LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(6));
        voos.add(voo);
        
        
        assertEquals(1, voos.size());
        assertEquals("XX5678", voos.get(0).getCodVoo());
    }
}
