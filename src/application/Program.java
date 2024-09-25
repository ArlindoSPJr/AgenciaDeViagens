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
        ArrayList<Passagem> passagems = new ArrayList<>();
        ArrayList<Compra> compras = new ArrayList<>();
        ArrayList<Bilhete> bilhetes = new ArrayList<>();

        Bilhete bilhete = new Bilhete();
        Compra compra = new Compra();
        Passagem passagem = new Passagem();
        Funcionario funcionario = new Funcionario();
        Viajante viajante = new Viajante();
        Aeroporto aeroporto = new Aeroporto();
        CompanhiaAerea ciaAerea = new CompanhiaAerea();
        Voo voo = new Voo();
        Usuario usuario = new Usuario();
        VooConexao vooConexao = new VooConexao();

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
            System.out.println("13. Cadastrar Passagem: ");
            System.out.println("14. Listar Passagem: ");
            System.out.println("15. Buscar Passagem: ");
            System.out.println("16. Comprar Passagem: ");
            System.out.println("17. Calcular valor total da Passagem: ");
            System.out.println("18. Calcular valor da remuneração da agência: ");
            System.out.println("19. Emitir bilhete classe bilhete: ");
            System.out.println("20. Sair");
            System.out.println("Escolha um opção: [1-20]");
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
                Scanner scanner = new Scanner(System.in);

                System.out.println("Escolha a opção:");
                System.out.println("1. Cadastrar voo com conexão");
                System.out.println("2. Cadastrar voo direto");
                int escolha = scanner.nextInt();
                scanner.nextLine(); 
            
                switch (escolha) {
                    case 1:
                        vooConexao.cadastrarVoo(ciasAereas, aeroportos, voos);
                        break;
            
                    case 2:
                        
                        voo.cadastrarVoo(ciasAereas, aeroportos, voos);
                        break;
            
                    default:
                        System.out.println("Escolha inválida. Tente novamente.");
                        break;
                }
                    break;
                case 10:
                ArrayList<Voo> voosEncontrados = voo.buscarVoo(voos);  // Buscar na lista de voos
                if (!voosEncontrados.isEmpty()) {
                    System.out.println("Voos encontrados:");
                    for (Voo v : voosEncontrados) {
                        System.out.println(v);
                        System.out.println();
                    }
                } else {
                    System.out.println("Nenhum voo encontrado.");
                }
                break;
                case 11:
                    usuario.cadastrarUsuaario(usuarios,funcionarios);
                    break;
                case 12:
                    usuario.fazerLogin(usuarios);
                    break;
                case 13:
                    passagem.cadastrarPassagem(voos,passagems);
                    break;
                case 14:
                    passagem.listarPassagens(passagems);
                    break;
                case 15:
                    ArrayList<Passagem> passagensEncontradas = passagem.buscarPassagem(passagems);  // Buscar na lista de passagens
                    if (!passagensEncontradas.isEmpty()) {
                    System.out.println("Passagens encontradas:");
                    for (Passagem p : passagensEncontradas) {
                        System.out.println(p);  
                        System.out.println();
                    }
                    } else {
                    System.out.println("Nenhuma passagem encontrada.");
                    }
                    break;
                case 16:
                    compra.comprarPassagem(passagems,viajantes);
                    break;
                case 17:
                    compra.calcularValorTotal(passagems, viajante, voos);
                    break;
                case 18:
                    compra.calcRemuneracaoAgencia(passagems, viajante, voos);
                    break;
                case 19:
                    compra.emitirBilhete(compras,passagems, voos, viajante);
                    bilhete.imprimirBilhete();
                    break;
                case 20:
                    continuar = false;  // Sair do loop
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        sc.close();
    }
}
