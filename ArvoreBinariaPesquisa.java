import java.util.List;
import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;

public class ArvoreBinariaPesquisa {
    private class ResultadosBuscaProfundidade {
        public int tamanho;
        public String preordem;
        public String centralordem;
        public String posordem;
        public String largura;

        public ResultadosBuscaProfundidade() {
            tamanho = 0;
            preordem = "";
            centralordem = "";
            posordem = "";
            largura = "";
        }

    }

    private class Nodo {
        private int item;
        private Nodo esquerda;
        private Nodo direita;
        private Nodo pai;

        public Nodo(int item) {
            this.item = item;
        }
    }

    private Nodo raiz;

    public ArvoreBinariaPesquisa() {
    };

    /*
     * • void mergear(ArvoreBinariaPesquisa t) //esse método deve inserir todas as
     * chaves da árvore t na árvore atual
     * (a do objeto que está disparando esse método)
     * • adicionar(String lista) //método para adicionar todas as chaves contidas em
     * lista
     * • remover(String lista) //método para remover todas as chaves contidas em
     * lista. Esse parâmetro é um string que
     * deve enviar as chaves a serem removidas separadas por vírgula. Exemplo: “34,
     * 99, 12”. Remove 34, 99, 12
     * • gerarArvoreAleatoria(int n) //método que limpa a árvore atual e adiciona n
     * chaves não repetidas na árvore
     */

    // Métodos que estão funcionando

    public void adicionar(int item) {
        Nodo n = new Nodo(item);
        if (estaVazia()) {
            raiz = n;
        } else {
            adicionarRecursivo(n, raiz);
        }
    }

    public void adicionar(List<Integer> lista) {
        for (Integer item : lista) {
            if (!existe(item)) adicionar(item);
        }
    }

    private void adicionarRecursivo(Nodo n, Nodo pai) {
        if (n.item > pai.item) {
            if (pai.direita == null) {
                pai.direita = n;
                n.pai = pai;
            } else
                adicionarRecursivo(n, pai.direita);
        } else {
            if (pai.esquerda == null) {
                pai.esquerda = n;
                n.pai = pai;
            }

            else
                adicionarRecursivo(n, pai.esquerda);
        }
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    private void percorrerRecursivamente(Nodo aux, ResultadosBuscaProfundidade resultado) {
        if (aux == null)
            return;
        resultado.tamanho++;
        resultado.preordem = resultado.preordem + " " + aux.item;
        percorrerRecursivamente(aux.esquerda, resultado);
        percorrerRecursivamente(aux.direita, resultado);
    }

    public int obterTamanho() {
        ResultadosBuscaProfundidade r = new ResultadosBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.tamanho;
    }

    public void limpar() {
        raiz = null;
    }

    private Nodo obterNodoRecursivo(int item, Nodo n) {
        if (n == null)
            return null;
        if (item == n.item)
            return n;
        if (item > n.item)
            return obterNodoRecursivo(item, n.direita);
        if (item < n.item)
            return obterNodoRecursivo(item, n.esquerda);
        return null;
    }

    public int obterEsquerda(int item) {
        Nodo n = obterNodoRecursivo(item, raiz);
        if (n == null) {
            return -1;
        } else if (n.esquerda == null)
            return 0;
        else
            return n.esquerda.item;
    }

    
    public int obterDireita(int item) {
    Nodo n = obterNodoRecursivo(item, raiz);
     if(n==null) return -1;
     if(n.direita==null) return 0;
    return n.direita.item;
     }

    public int obterPai(int item) {
        if (estaVazia())
            return -1;
        if (item == raiz.item)
            return -1;
        Nodo aux = obterNodoRecursivo(item, raiz);
        return aux.pai.item;
    }

    public String elementosPreOrdem() {
        ResultadosBuscaProfundidade r = new ResultadosBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.preordem;
    }

    private void percorrerRecursivamenteCentral(Nodo aux, ResultadosBuscaProfundidade resultado) {
        if (aux == null) {
            return;
        }
        percorrerRecursivamenteCentral(aux.esquerda, resultado);
        resultado.tamanho++;
        resultado.centralordem = resultado.centralordem + " " + aux.item;
        percorrerRecursivamenteCentral(aux.direita, resultado);
    }

    public String elementosCentralOrdem() {
        ResultadosBuscaProfundidade r = new ResultadosBuscaProfundidade();
        percorrerRecursivamenteCentral(raiz, r);
        return r.centralordem;
    }

    private void percorrerRecursivamentePosOrdem(Nodo aux, ResultadosBuscaProfundidade resultado) {
        if (aux == null) {
            return;
        }
        percorrerRecursivamentePosOrdem(aux.esquerda, resultado);
        percorrerRecursivamentePosOrdem(aux.direita, resultado);
        resultado.tamanho++;
        resultado.posordem = resultado.posordem + " " + aux.item;
    }

    public String elementosPosOrdem() {
        ResultadosBuscaProfundidade r = new ResultadosBuscaProfundidade();
        percorrerRecursivamentePosOrdem(raiz, r);
        return r.posordem;
    }

    
    private void percorrerPorNiveis(Nodo raiz, ResultadosBuscaProfundidade resultado) {
        if (raiz == null) {
            return;
        }

        Queue<Nodo> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Nodo atual = fila.poll();
            resultado.largura = resultado.largura + " " + atual.item;

            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }

            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }
    }

    public String elementosLargura() {
        ResultadosBuscaProfundidade r = new ResultadosBuscaProfundidade();
        percorrerPorNiveis(raiz, r);
        return r.largura;
    }

    public int obterNivel(int item) {
        return obterNivelRecursivo(item, raiz, 0);
    }

    private int obterNivelRecursivo(int item, Nodo n, int nivel) {
        if (n == null) {
            return -1;
        }
        if (item == n.item) {
            return nivel;
        }
        if (item < n.item) {
            return obterNivelRecursivo(item, n.esquerda, nivel + 1);
        } else {
            return obterNivelRecursivo(item, n.direita, nivel + 1);
        }
    }

    public boolean existe(int item) {
        if (obterNodoRecursivo(item, raiz) != null)
            return true;
        else
            return false;
    }

    public int obterAltura(int item) {
        return obterAlturaRecursivo(raiz);
    }

    private int obterAlturaRecursivo(Nodo n) {
        if (n == null) {
            return -1;
        }
        int alturaEsquerda = obterAlturaRecursivo(n.esquerda);
        int alturaDireita = obterAlturaRecursivo(n.direita);
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    public boolean ehInterno(int item) {
        Nodo n = obterNodoRecursivo(item, raiz);
        if (n != null && numeroFilhos(n) > 0) {
            return true;
        }
        return false;
    }

    private int numeroFilhos(Nodo n) {
        if (n == null)
            return -1;
        if (n.esquerda == null && n.direita == null)
            return 0;
        if (n.esquerda != null && n.direita != null)
            return 2;
        return 1;
    }

    public boolean ehExterno(int item) {
        Nodo n = obterNodoRecursivo(item, raiz);
        if (n != null && numeroFilhos(n) > 1) {
            return true;
        }
        return false;
    }

    
    public void remover(int item) {
        Nodo n = obterNodoRecursivo(item, raiz);
        if (n == null) {
            System.out.println(" não foi possivel remover o" + item);
        } else {
            if (numeroFilhos(n) == 0) {
                if (n.pai.esquerda == n)
                    n.pai.esquerda = null;
                else
                    n.pai.direita = null;
            }
            System.out.println(item + " removido com sucesso");
        }
    }

    public void remover(List<Integer> lista) {
        for (Integer item : lista) {
            if (existe(item)) remover(item);
        }
    }
 
    public int qtdNosNaoFolha() {
      return contarNodos()-qtdNodosFolha();
      }
      public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }

    private int contarNodosRecursivo(Nodo n) {
        if(n==null) return 0;
        return 1 + contarNodosRecursivo(n.esquerda) + contarNodosRecursivo(n.direita);
    }
     

    public int qtdNodosFolha() {
        return contarNodosFolhasRecursivo(raiz);
    }

    private int contarNodosFolhasRecursivo(Nodo n) {
        if (n == null)
            return 0;
        if (n.esquerda == null && n.direita == null)
            return 1;
        return contarNodosFolhasRecursivo(n.esquerda) + contarNodosFolhasRecursivo(n.direita);
    }

    private void maiorValorRecursivo(Nodo n, int[] maior) {
        if (n == null)
            return;
        if (n.item > maior[0])
            maior[0] = n.item;
        maiorValorRecursivo(n.esquerda, maior);
        maiorValorRecursivo(n.direita, maior);
    }

    public int maiorValor() {
        int[] maior = new int[1];
        maior[0] = Integer.MIN_VALUE;
        maiorValorRecursivo(raiz, maior);
        return maior[0];
    }

    private void menorValorRecursivo(Nodo n, int[] menor) {
        if (n == null)
            return;
        if (n.item < menor[0])
            menor[0] = n.item;
        menorValorRecursivo(n.esquerda, menor);
        menorValorRecursivo(n.direita, menor);
    }

    public int menorValor() {
        int[] menor = new int[1];
        menor[0] = Integer.MAX_VALUE;
        menorValorRecursivo(raiz, menor);
        return menor[0];
    }

    public int qtdPares() {
        return qtdParesRecursivo(raiz);
    }

    public int qtdParesRecursivo(Nodo n) {
        if (n == null)
            return 0;
        if (n.item % 2 == 0)
            return 1 + qtdParesRecursivo(n.esquerda) + qtdParesRecursivo(n.direita);
        return qtdParesRecursivo(n.esquerda) + qtdParesRecursivo(n.direita);
    }

    
    public int qtdImpares() {
        return qtdImparesRecursivo(raiz);
    }

    public int qtdImparesRecursivo(Nodo n) {
        if (n == null)
            return 0;
        if (n.item % 2 != 0)
            return 1 + qtdImparesRecursivo(n.esquerda) + qtdImparesRecursivo(n.direita);
        return qtdImparesRecursivo(n.esquerda) + qtdImparesRecursivo(n.direita);
    }

    public void imprimirArvore() {
        imprimirArvoreRecusivamente(raiz, 0);
    }

    private void imprimirArvoreRecusivamente(Nodo raiz, int nivel) {
        if (raiz == null)
            return;
        nivel += 5;
        imprimirArvoreRecusivamente(raiz.direita, nivel);
        System.out.print("\n");
        for (int i = 5; i < nivel; i++)
            System.out.print(" ");
        System.out.print(raiz.item + "\n");
        for (int i = 5; i < nivel; i++)
            System.out.print(" ");
        imprimirArvoreRecusivamente(raiz.esquerda, nivel);
    }

    public int obterRaiz() {
        if (!estaVazia())
            return raiz.item;
        return -1;
    }

    public void gerarArvoreAleaoria(int qtdNodos) {
        for (int i = 0; i < qtdNodos; i++) {
            int num = new Random().nextInt(0, 100);
            adicionar(num);
        }
    }

    public void mergear(ArvoreBinariaPesquisa t) {
        if (t == null || t.raiz == null) {
            return;
        }

        mergearNodos(t.raiz);
    }

    private void mergearNodos(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        mergearNodos(nodo.esquerda);
        if (!existe(nodo.item)) adicionar(nodo.item);
        mergearNodos(nodo.direita);
    }
}
