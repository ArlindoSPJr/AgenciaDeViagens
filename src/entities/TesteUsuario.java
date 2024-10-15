import entities;
import entities.Funcionario;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private Usuario usuario;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Funcionario> funcionarios;

    @Before
    void setUp() {
        usuario = new Usuario("usuarioTeste", "senhaTeste");
        usuarios = new ArrayList<>();
        funcionarios = new ArrayList<>();
        
    }

    @Test
    void testGetUsername() {
        assertEquals("usuarioTeste", usuario.getUsername());
    }

    @Test
    void testSetUsername() {
        usuario.setUsername("novoUsuario");
        assertEquals("novoUsuario", usuario.getUsername());
    }

    @Test
    void testGetSenha() {
        assertEquals("senhaTeste", usuario.getSenha());
    }

    @Test
    void testSetSenha() {
        usuario.setSenha("novaSenha");
        assertEquals("novaSenha", usuario.getSenha());
    }

    @Test
    void testGetFuncionario() {
        assertNull(usuario.getFuncionario());
    }

    @Test
    void testSetFuncionario() {
        Funcionario funcionario = new Funcionario("NOme teste 3", "003456", "email@teste");
        usuario.setFuncionario(funcionario);
        assertEquals(funcionario, usuario.getFuncionario());
    }

    @Test
    void testGetUsuarios() {
        assertEquals(usuarios, usuario.getUsuarios());
    }

    @Test
    void testSetUsuarios() {
        ArrayList<Usuario> novosUsuarios = new ArrayList<>();
        usuario.setUsuarios(novosUsuarios);
        assertEquals(novosUsuarios, usuario.getUsuarios());
    }

    @Test
    void testCadastrarUsuario() {
        Funcionario funcionario = new Funcionario("Teste Nome 4","567890","teste@func");
        funcionarios.add(funcionario);

        // Simular entrada do usuário
        String input = "673535\nteste8\n12345\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        usuario.cadastrarUsuaario(usuarios, funcionarios);

        assertEquals(1, usuarios.size());
        assertEquals("teste8", usuarios.get(0).getUsername());
        assertEquals("12345", usuarios.get(0).getSenha());
    }

    @Test
    void testFazerLoginSuccess() {
        usuarios.add(usuario);

        // Simular entrada do usuário
        String input = "usuarioTeste\nsenhaTeste\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean resultado = usuario.fazerLogin(usuarios);
        assertTrue(resultado);
    }

    @Test
    void testFazerLoginErro() {
        // Usuário não cadastrado
        String input = "usuarioInexistente\nsenhaInexistente\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean resultado = usuario.fazerLogin(usuarios);
        assertFalse(resultado);
    }
}
