package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Funcionario;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    private Funcionario funcionario;
    private ArrayList<Funcionario> funcionarios;

    @BeforeEach
    void setUp() {
        
        funcionarios = new ArrayList<>();
        funcionario = new Funcionario("Arthur Pazzutti", "123.456.789-00", "arthurpazzutti@gmail.com");
    }

    @Test
    void testGetAndSetNome() {
        
        funcionario.setNome("Arthur Astolfi");
        assertEquals("Arthur Astolfi", funcionario.getNome());
    }

    @Test
    void testGetAndSetCpf() {
        
        funcionario.setCpf("987.654.321-00");
        assertEquals("987.654.321-00", funcionario.getCpf());
    }

    @Test
    void testGetAndSetEmail() {
        // Teste para verificar getters e setters de email
        funcionario.setEmail("arthurastolfi@gmail.com");
        assertEquals("arthurastolfi@gmail.com", funcionario.getEmail());
    }

    @Test
    void testCadastrarFuncionario() {
        
        Funcionario novoFuncionario = new Funcionario("Arlindo Junior", "000.222.333-44", "arlindojunior@gmail.com");
        funcionarios.add(novoFuncionario);
        
        
        assertEquals(1, funcionarios.size());
        assertEquals("Arlindo Junior", funcionarios.get(0).getNome());
        assertEquals("000.222.333-44", funcionarios.get(0).getCpf());
        assertEquals("arlindojunior@gmail.com", funcionarios.get(0).getEmail());
    }

    @Test
    void testListarFuncionariosComFuncionariosCadastrados() {
        
        funcionarios.add(new Funcionario("Arthur Astolfi", "987.654.321-00", "arthurastolfi@gmail.com"));
        funcionarios.add(new Funcionario("Fernando Dantas", "555.666.777-88", "fernandodantas@gmail.com"));
        
       
        assertEquals(2, funcionarios.size());
        assertEquals("Arthur Astolfi", funcionarios.get(0).getNome());
        assertEquals("Fernando Dantas", funcionarios.get(1).getNome());
    }

    @Test
    void testListarFuncionariosSemFuncionariosCadastrados() {
        
        funcionarios.clear();  
        assertTrue(funcionarios.isEmpty());
    }

    @Test
    void testToString() {
        
        String expectedString = "Nome= Arthur Pazzutti\n" +
                                "CPF= 123.456.789-00\n" +
                                "Email= arthurpazzutti@gmail.com";
        assertEquals(expectedString, funcionario.toString());
    }
}
