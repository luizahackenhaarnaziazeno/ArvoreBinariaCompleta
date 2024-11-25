import java.util.ArrayList;
import java.util.Scanner;

//Luiza Hackenhaar Naziazeno e Ricardo Soares Ribeiro

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa();
        abp.adicionar(15);
        abp.adicionar(9);
        abp.adicionar(2);
        abp.adicionar(11);
        abp.adicionar(23);
        abp.adicionar(20);
        abp.adicionar(28);

        while (continuar) {
            System.out.println("\n === Menu ===");
            System.out.println("1 - Imprindo Árvore Criada:");
            System.out.println("2 -Tamanho Da Árvore Criada:");
            System.out.println("3 - Obter Nodo Da Esquerda Do 9:");
            System.out.println("4 - Obter Nodo Da Direita Do 23:");
            System.out.println("5 - Pai Do 20:");
            System.out.println("6 - Se o valor 11 existe na árvore:");
            System.out.println("7 - Se o valor 12 existe na árvore:");
            System.out.println("8 - Se o valor 2 é interno:");
            System.out.println("9 - Se o valor 23 é externo:");
            System.out.println("10 - Maior valor da árvore:");
            System.out.println("11 - Menor valor da árvore:");
            System.out.println("12 - Quantidade de nodos não folhas na árvore:");
            System.out.println("13 - Quantidade de nodos folhas na árvore:");
            System.out.println("14 - Preordem:");
            System.out.println("15 - Posordem:");
            System.out.println("16 - OrdemEmLargura:");
            System.out.println("17 - Centralordem:");
            System.out.println("18 - Nivel do Nodo 11:");
            System.out.println("19 - Altura do Nodo 15:");
            System.out.println("20 - A quantidades de números pares na árvore:");
            System.out.println("21 - A quantidades de números ímpares na árvore:");
            System.out.println("22 - Remover 2:");
            System.out.println("23 - Adicionar e depois remover uma lista de elementos {1, 7, 16, 22} :");
            System.out.println("24 - Gerar duas arvores aleatórias e depois mergear:");
            System.out.println("25 - Obter a raiz da árvore: ");
            System.out.println("26 - Limpar a árvore: ");
            System.out.println("27 - Sair:");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Imprimindo árvore criada:");
                    abp.imprimirArvore();
                    System.out.println("");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Tamanho = " + abp.obterTamanho());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 3:
                    abp.imprimirArvore();
                    System.out.println("Obter Nodo Da Esquerda Do 9");
                    System.out.println(abp.obterEsquerda(9));
                    abp.imprimirArvore();
                    System.out.println("");
                    System.out.println("");
                    break;
                case 4:
                    abp.imprimirArvore();
                    System.out.println("Obter Nodo Da Direita Do 23");
                    System.out.println(abp.obterDireita(23));
                    abp.imprimirArvore();
                    System.out.println("");
                    System.out.println("");
                    break;
                case 5:
                    int valor = 20;
                    System.out.println("Pai do " + valor + " = " + abp.obterPai(20));
                    abp.imprimirArvore();
                    System.out.println("");
                    System.out.println("");
                    break;
                case 6:
                    int valor2 = 11;
                    abp.imprimirArvore();
                    System.out.println("Se " + valor2 + " existe na árvore");
                    System.out.println(abp.existe(11));
                    System.out.println("");
                    System.out.println("");
                    break;
                case 7:
                    int valor3 = 12;
                    abp.imprimirArvore();
                    System.out.println("Se " + valor3 + " existe na árvore");
                    System.out.println(abp.existe(12));
                    System.out.println("");
                    System.out.println("");
                    break;
                case 8:
                    int valor4 = 2;
                    System.out.println("Se " + valor4 + " é interno ");
                    System.out.println(abp.ehInterno(2));
                    System.out.println("");
                    System.out.println("");
                    break;
                case 9:
                    int valor5 = 23;
                    System.out.println("Se " + valor5 + " é externo");
                    System.out.println(abp.ehExterno(23));
                    System.out.println("");
                    System.out.println("");
                    break;
                case 10:
                    System.out.println("Maior valor da árvore é ");
                    System.out.println(abp.maiorValor());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 11:
                    System.out.println("Menor valor da árvore é ");
                    System.out.println(abp.menorValor());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 12:
                    System.out.println("Quantidade de nodos não folhas na árvore é ");
                    System.out.println(abp.qtdNosNaoFolha());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 13:
                    System.out.println("Quantidade de nodos folhas na árvore é ");
                    System.out.println(abp.qtdNodosFolha());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 14:
                    abp.imprimirArvore();
                    System.out.println("Preordem = " + abp.elementosPreOrdem());
                    abp.imprimirArvore();
                    System.out.println("");
                    System.out.println("");
                    break;
                case 15:
                    abp.imprimirArvore();
                    System.out.println("Posordem = " + abp.elementosPosOrdem());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 16:
                    abp.imprimirArvore();
                    System.out.println("OrdemEmLargura = " + abp.elementosLargura());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 17:
                    abp.imprimirArvore();
                    System.out.println("Centralordem = " + abp.elementosCentralOrdem());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 18:
                    int valor6 = 11;
                    abp.imprimirArvore();
                    System.out.println("Nivel do Nodo " + valor6 + " é " + "=");
                    System.out.println(abp.obterNivel(11));
                    System.out.println("");
                    System.out.println("");
                    break;
                case 19:
                    int valor7 = 15;
                    abp.imprimirArvore();
                    System.out.println("Altura do Nodo " + valor7 + " é " + "=");
                    System.out.println(abp.obterAltura(15));
                    System.out.println("");
                    System.out.println("");
                    break;
                case 20:
                    abp.imprimirArvore();
                    System.out.println("A quantidades de números pares na árvore é ");
                    System.out.println(abp.qtdPares());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 21:
                    abp.imprimirArvore();
                    System.out.println("A quantidades de números ímpares na árvore é ");
                    System.out.println(abp.qtdImpares());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 22:
                    System.out.println("Removendo 2");
                    abp.remover(2);
                    abp.imprimirArvore();
                    System.out.println("");
                    System.out.println("");
                    break;
                case 23:
                    System.out.println("Adicionar e depois remover uma lista de elementos: {1, 7, 16, 22}");
                    ArrayList<Integer> itens = new ArrayList<>();
                    itens.add(2);
                    itens.add(7);
                    itens.add(15);
                    itens.add(22);
                    abp.adicionar(itens);
                    abp.imprimirArvore();
                    System.out.println("\n=========================\n");
                    abp.remover(itens);
                    abp.imprimirArvore();
                    break;
                case 24:
                    System.out.println("Gerar duas arvores aleatórias e depois mergear");
                    abp.limpar();
                    abp.gerarArvoreAleaoria(5);
                    abp.imprimirArvore();
                    System.out.println("\n=========================\n");
                    ArvoreBinariaPesquisa outraAbp = new ArvoreBinariaPesquisa();
                    outraAbp.gerarArvoreAleaoria(5);
                    outraAbp.imprimirArvore();
                    System.out.println("\n=========================\n");
                    abp.mergear(outraAbp);
                    abp.imprimirArvore();
                    break;
                case 25:
                    abp.imprimirArvore();
                    System.out.println("Obter a raiz da árvore");
                    System.out.println(abp.obterRaiz());
                    System.out.println("");
                    System.out.println("");
                    break;
                case 26:
                    abp.imprimirArvore();
                    System.out.println("Limpando a árvore");
                    abp.limpar();
                    abp.imprimirArvore();
                    System.out.println("");
                    System.out.println("");
                    break;
                case 27:
                    System.out.println("Saindo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();

    }
}
