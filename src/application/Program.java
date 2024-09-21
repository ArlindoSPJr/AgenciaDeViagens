package application;

import entities.*;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();
        Aeroporto aeroporto = new Aeroporto();
        Viajante viajante = new Viajante();
        CompanhiaAerea ciaAerea = new CompanhiaAerea();
        Voo voo = new Voo();

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
            System.out.println("11. Fazer Login no sistema: ");
            System.out.println("12. Comprar Passagem: ");
            System.out.println("13. Sair");
            System.out.println("Escolha um opção: [1-13]");
            int opcaoEscolhida = sc.nextInt();

            switch (opcaoEscolhida){
                case 1:
                    funcionario.cadastrarFuncionario();
                    break;
                case 2:
                    funcionario.listarFuncionarios();
                    break;
                case 3:
                    viajante.cadastrarViajante();
                    break;
                case 4:
                    viajante.listarViajantes();
                    break;
                case 5:
                    aeroporto.cadastrarAeroporto();
                    break;
                case 6:
                    aeroporto.listarAeroporto();
                    break;
                case 7:
                    ciaAerea.cadastrarCompanhiaAerea();
                    break;
                case 8:
                    ciaAerea.listarCompanhiasAereas();
                    break;
                case 9:
                    voo.cadastrarVoo();
                    break;
                case 10:
                    System.out.println("Digite o codigo do voo que deseja buscar: ");
                    String codVoo = sc.nextLine();
                    Voo vooEncontrado = voo.buscarVoo(codVoo);
                    if (vooEncontrado != null) {
                        System.out.println("Voo encontrado: " + vooEncontrado);
                    } else {
                        System.out.println("Voo não encontrado.");
                    }
                    break;
                default:
                    System.out.println("Opção Invalida. Tente novamente.");
            }
        }
//        // Emitindo o bilhete com base na compra
//        Bilhete bilhete = Bilhete.emitirBilhete(compra);
//
//        // Imprimindo o bilhete
//        bilhete.imprimirBilhete();
    }
}
