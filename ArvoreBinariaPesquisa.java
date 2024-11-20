
public class ArvoreBinariaPesquisa {
    private class ResultadosBuscaProfundidade {
        public int tamanho;
        public String preordem;
        public ResultadosBuscaProfundidade() {
            tamanho = 0;
            preordem = "";
        }

    }
    /*
fazer:
arrumar o método remover para ele tirar o nodo quando ele tiver na arvore 
• int obterEsquerda(int item)
• int obterDireita(int item)
• boolean existe(int item)
• String elementosCentralOrdem()
• String elementosPosOrdem()
• String elementosLargura()
boolean ehInterno(int item)
• boolean ehExterno(int item)
• int qtdNosNaoFolha() //retorna a quantidade de nodos não folha
• int qtdNodosFolha() //quantidade de nodos folha
int altura()-utilizar obter nivel
• int obterNivel(int item)-acho
• int obterMenorValor() //retorna a menor chave da árvore
• int qtdPares() //retorna a quantidade de chaves que são pares
• int qtdImpares() //retorna a quantidade de chaves são impares
• void mergear(ArvoreBinariaPesquisa t) //esse método deve inserir todas as chaves da árvore t na árvore atual
(a do objeto que está disparando esse método)
• adicionar(String lista) //método para adicionar todas as chaves contidas em lista
• remover(String lista) //método para remover todas as chaves contidas em lista. Esse parâmetro é um string que
deve enviar as chaves a serem removidas separadas por vírgula. Exemplo: “34, 99, 12”. Remove 34, 99, 12
• gerarArvoreAleatoria(int n) //método que limpa a árvore atual e adiciona n chaves não repetidas na árvore




 */

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
    public ArvoreBinariaPesquisa() {};
    public void adicionar(int item) {
        Nodo n = new Nodo(item);
        if(estaVazia()) {
            raiz = n;
        }
        else {
            adicionarRecursivo(n, raiz);
        }
    }
    private void adicionarRecursivo(Nodo n, Nodo pai) {
        if(n.item>pai.item) {
            if(pai.direita==null) {
                pai.direita = n;
                n.pai = pai;
            }
            else adicionarRecursivo(n, pai.direita);
        }
        else {
            if(pai.esquerda==null) {
                pai.esquerda = n;
                n.pai = pai;
            }

            else adicionarRecursivo(n, pai.esquerda);
        }
    }


    public void remover(int item) {
     
        Nodo n = obterNodoRecursivo(item, raiz);
        if(n==null) {
        System.out.println(" não foi possivel remover o"+ item);
        }else{
        if(numeroFilhos(n)==0) {
            if(n.pai.esquerda==n) n.pai.esquerda = null;
            else n.pai.direita = null;
        }
        System.out.println(item + " removido com sucesso");
        }
    }




    private int numeroFilhos(Nodo n) {
        if(n==null) return -1;
        if(n.esquerda==null && n.direita==null) return 0;
        if(n.esquerda!=null && n.direita!=null) return 2;
        return 1;
    }
    private Nodo obterNodoRecursivo(int item, Nodo n) {
        if(n==null) return null;
        if(item==n.item) return n;
        if(item>n.item) return obterNodoRecursivo(item, n.direita);
        if(item<n.item) return obterNodoRecursivo(item, n.esquerda);
        return null;
    }
    public void imprimirArvore() {
        imprimirArvoreRecusivamente(raiz, 0);
    }
    private void imprimirArvoreRecusivamente(Nodo raiz, int nivel) {
        if (raiz == null) return;
        nivel += 5;
        imprimirArvoreRecusivamente(raiz.direita, nivel);
        System.out.print("\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        System.out.print(raiz.item + "\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        imprimirArvoreRecusivamente(raiz.esquerda, nivel);
    }
    public boolean estaVazia() {
        return raiz==null;
    }

    private void percorrerRecursivamente(Nodo aux, ResultadosBuscaProfundidade resultado) {
        if(aux==null) return;
        resultado.tamanho++;
        resultado.preordem = resultado.preordem + " " + aux.item;
        if(aux.esquerda!=null) percorrerRecursivamente(aux.esquerda, resultado);
        if(aux.direita!=null) percorrerRecursivamente(aux.direita, resultado);
    }
    //Ver se tá funcionado
    public int obterTamanho() {
        ResultadosBuscaProfundidade r = new ResultadosBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.tamanho;
    }
    public void limpar() {
        raiz = null;
    }
    public int obterRaiz() {
        if(!estaVazia()) return raiz.item;
        return -1;
    }
    public int obterPai(int item) {
        if(estaVazia()) return -1;
        if(item==raiz.item) return -1;
        Nodo aux = obterNodoRecursivo(item, raiz);
        return aux.pai.item;
    }
    public String percorrerPreOrdem() {
        ResultadosBuscaProfundidade r = new ResultadosBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.preordem;

    }
    public String percorrerPosOrdem() {
        return null;
    }
    public String percorrerCentral() {
        return null;
    }
    public String percorrerLargura() {
        return null;
    }
    public int obterNivel(int item) {
        return 0;
    }
    public int obterAltura(int item) {
        return 0;
    }
    public boolean ehInterno(int item) {
        return false;
    }
    public boolean ehExterno(int item) {
        return false;
    }

    public int contarNodos() {
        return contarNodosRecursivo(raiz);
    }
    private int contarNodosRecursivo(Nodo n) {
        if(n==null) return 0;
        return 1 + contarNodosRecursivo(n.esquerda) + contarNodosRecursivo(n.direita);
    }
    public int maiorValor() {
        int[] maior = new int[1];
        maior[0] = Integer.MIN_VALUE;
        maiorValorRecursivo(raiz, maior);
        return maior[0];
    }

    //• int obterMaiorValor() //retorna a maior chave da árvore
    private void maiorValorRecursivo(Nodo n, int[] maior) {
        if(n==null) return;
        if(n.item>maior[0]) maior[0] = n.item;
        maiorValorRecursivo(n.esquerda, maior);
        maiorValorRecursivo(n.direita, maior);
    }

    public int maiorValor_gpt() {
        return maiorValorRecursivo_gpt(raiz);
    }

    private int maiorValorRecursivo_gpt(Nodo n) {
        if (n == null) {
            return Integer.MIN_VALUE;
        }
        int esquerdaMax = maiorValorRecursivo_gpt(n.esquerda);
        int direitaMax = maiorValorRecursivo_gpt(n.direita);
        return Math.max(n.item, Math.max(esquerdaMax, direitaMax));
    }
    
    public int contarFilhosDaDireita() {
        return 0;
    }

 

}
