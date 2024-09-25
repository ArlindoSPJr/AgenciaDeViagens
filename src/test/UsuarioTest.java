package test;

import entities.*;
import entities.Funcionario;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private Usuario usuario;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Funcionario> funcionarios;

    @Before
    public void setUp() {
        usuario = new Usuario("usuarioTeste", "senhaTeste");
        usuarios = new ArrayList<>();
        funcionarios = new ArrayList<>();

    }

    @Test
    public void testGetUsername() {
        assertEquals("usuarioTeste", usuario.getUsername());
    }

    @Test
    public void testSetUsername() {
        usuario.setUsername("novoUsuario");
        assertEquals("novoUsuario", usuario.getUsername());
    }

    @Test
    public void testGetSenha() {
        assertEquals("senhaTeste", usuario.getSenha());
    }

    @Test
    public void testSetSenha() {
        usuario.setSenha("novaSenha");
        assertEquals("novaSenha", usuario.getSenha());
    }

    @Test
    public void testGetFuncionario() {
        assertNull(usuario.getFuncionario());
    }

    @Test
    public void testSetFuncionario() {
        Funcionario funcionario = new Funcionario("NOme teste 3", "003456", "email@teste");
        usuario.setFuncionario(funcionario);
        assertEquals(funcionario, usuario.getFuncionario());
    }

    @Test
    public void testGetUsuarios() {
        assertEquals(usuarios, usuario.getUsuarios());
    }

    @Test
    public void testSetUsuarios() {
        ArrayList<Usuario> novosUsuarios = new ArrayList<>();
        usuario.setUsuarios(novosUsuarios);
        assertEquals(novosUsuarios, usuario.getUsuarios());
    }

    @Test
    public void testCadastrarUsuario() {
        Funcionario funcionario = new Funcionario("Teste Nome 4","567890","teste@func");
        funcionarios.add(funcionario);

        // Simular entrada do usuário
        String input = "673535\nusuarioTeste\nsenhaTeste\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        usuario.cadastrarUsuaario(usuarios, funcionarios);
        usuarios.add(usuario);

        assertEquals(1, usuarios.size());
        assertEquals("usuarioTeste", usuarios.getFirst().getUsername());
        assertEquals("senhaTeste", usuarios.getFirst().getSenha());
    }

    @Test
    public void testFazerLoginSuccess() {
        usuarios.add(usuario);

        // Simular entrada do usuário
        String input = "usuarioTeste\nsenhaTeste\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean resultado = usuario.fazerLogin(usuarios);
        assertTrue(resultado);
    }

    @Test
    public void testFazerLoginErro() {
        // Usuário não cadastrado
        String input = "usuarioInexistente\nsenhaInexistente\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean resultado = usuario.fazerLogin(usuarios);
        assertFalse(resultado);
    }
}