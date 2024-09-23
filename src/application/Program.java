package application;

import entities.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Listas para armazenar objetos
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Viajante> viajantes = new ArrayList<>();
        ArrayList<Aeroporto> aeroportos = new ArrayList<>();
        ArrayList<CompanhiaAerea> ciasAereas = new ArrayList<>();
        ArrayList<Voo> voos = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Funcionario funcionario = new Funcionario();
        Viajante viajante = new Viajante();
        Aeroporto aeroporto = new Aeroporto();
        CompanhiaAerea ciaAerea = new CompanhiaAerea();
        Voo voo = new Voo();
        Usuario usuario = new Usuario();

        boolean continuar = true;

        while (continuar) {
            System.out.println();
            System.out.println("Software de Agência de Viagens");
            System.out.println("1. Cadastrar funcionario:");
            System.out.println("2. Listar funcionarios:");
            System.out.println("3. Cadastrar Viajante: ");
            System.out.println("4. Listar Viajantes: ");
            System.out.println("5. Cadastrar Aeroporto: ");
            System.out.println("6. Listar Aeroportos: ");
            System.out.println("7. Cadastrar Companhia Aerea: ");
            System.out.println("8. Listar Companhias Aereas: ");
            System.out.println("9. Cadastrar Voo: ");
            System.out.println("10. Procurar Voo: ");
            System.out.println("11. Cadastrar usuario: ");
            System.out.println("12. Fazer Login no sistema: ");
            System.out.println("13. Comprar Passagem: ");
            System.out.println("14. Sair");
            System.out.println("Escolha um opção: [1-14]");
            int opcaoEscolhida = sc.nextInt();
            sc.nextLine();  

            switch (opcaoEscolhida) {
                  case 1:
                    funcionario.cadastrarFuncionario(funcionarios);  // Passar a lista de funcionários
                    break;
                case 2:
                    funcionario.listarFuncionarios(funcionarios);  // Listar os funcionários da lista
                    break;
                case 3:
                    viajante.cadastrarViajante(viajantes);  // Passar a lista de viajantes
                    break;
                case 4:
                    viajante.listarViajantes(viajantes);  // Listar os viajantes da lista
                    break;
                case 5:
                    aeroporto.cadastrarAeroporto(aeroportos);  // Passar a lista de aeroportos
                    break;
                case 6:
                    aeroporto.listarAeroporto(aeroportos);  // Listar os aeroportos da lista
                    break;
                case 7:
                    ciaAerea.cadastrarCompanhiaAerea(ciasAereas);  // Passar a lista de cias aéreas
                    break;
                case 8:
                    ciaAerea.listarCompanhiasAereas(ciasAereas);  // Listar as cias aéreas da lista
                    break;
                case 9:
                    voo.cadastrarVoo(ciasAereas, aeroportos, voos);  // Passar listas de cias aéreas, aeroportos e voos
                    break;
                case 10:
                    System.out.println("Digite o código do voo que deseja buscar: ");
                    String codVoo = sc.nextLine();
                    Voo vooEncontrado = voo.buscarVoo(codVoo, voos);  // Buscar na lista de voos
                    if (vooEncontrado != null) {
                        System.out.println("Voo encontrado: " + vooEncontrado);
                    } else {
                        System.out.println("Voo não encontrado.");
                    }
                    break;
                case 11:
                    usuario.cadastrarUsuaario(usuarios,funcionarios);
                    break;
                case 12:
                    usuario.fazerLogin(usuarios);
                    break;
                case 14:
                    continuar = false;  // Sair do loop
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
