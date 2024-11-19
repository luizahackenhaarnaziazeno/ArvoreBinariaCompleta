
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
• int obterTamanho()-confirmar se tá ok
fazer:
• int obterEsquerda(int item)
• int obterDireita(int item)
• boolean existe(int item)
• void remover(int item)
• int qtdNosNaoFolha() //retorna a quantidade de nodos não folha
• int qtdNodosFolha() //quantidade de nodos folha


//temos em alguma aula do git
• String elementosPreOrdem()
• String elementosCentralOrdem()
• String elementosPosOrdem()
• String elementosLargura()
boolean ehInterno(int item)
• boolean ehExterno(int item)




//tem no nosso t2
• int altura()
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
        private int chave;
        private Nodo esquerda;
        private Nodo direita;
        private Nodo pai;
        public Nodo(int chave) {
            this.chave = chave;
        }
    }
    private Nodo raiz;
    public ArvoreBinariaPesquisa() {};
    public void adicionar(int chave) {
        Nodo n = new Nodo(chave);
        if(estaVazia()) {
            raiz = n;
        }
        else {
            adicionarRecursivo(n, raiz);
        }
    }
    private void adicionarRecursivo(Nodo n, Nodo pai) {
        if(n.chave>pai.chave) {
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
    public boolean remover(int chave) {
        //retorna TRUE se removeu ou FALSE se nao removeu (nao existia a chave)
        Nodo n = obterNodoRecursivo(chave, raiz);
        if(n==null) return false;
        if(numeroFilhos(n)==0) {
            if(n.pai.esquerda==n) n.pai.esquerda = null;
            else n.pai.direita = null;
        }
        return true;
    }
    private int numeroFilhos(Nodo n) {
        if(n==null) return -1;
        if(n.esquerda==null && n.direita==null) return 0;
        if(n.esquerda!=null && n.direita!=null) return 2;
        return 1;
    }
    private Nodo obterNodoRecursivo(int chave, Nodo n) {
        if(n==null) return null;
        if(chave==n.chave) return n;
        if(chave>n.chave) return obterNodoRecursivo(chave, n.direita);
        if(chave<n.chave) return obterNodoRecursivo(chave, n.esquerda);
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
        System.out.print(raiz.chave + "\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        imprimirArvoreRecusivamente(raiz.esquerda, nivel);
    }
    public boolean estaVazia() {
        return raiz==null;
    }

    private void percorrerRecursivamente(Nodo aux, ResultadosBuscaProfundidade resultado) {
        if(aux==null) return;
        resultado.tamanho++;
        resultado.preordem = resultado.preordem + " " + aux.chave;
        if(aux.esquerda!=null) percorrerRecursivamente(aux.esquerda, resultado);
        if(aux.direita!=null) percorrerRecursivamente(aux.direita, resultado);
    }
    //IMPLEMENTAR NA AULA DO DIA 04/11
    public int obterTamanho() {
        ResultadosBuscaProfundidade r = new ResultadosBuscaProfundidade();
        percorrerRecursivamente(raiz, r);
        return r.tamanho;
    }
    public void limpar() {
        raiz = null;
    }
    public int obterRaiz() {
        if(!estaVazia()) return raiz.chave;
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
    public int obterNivel(int chave) {
        return 0;
    }
    public int obterAltura(int chave) {
        return 0;
    }
    public boolean ehInterno(int chave) {
        return false;
    }
    public boolean ehExterno(int chave) {
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
        if(n.chave>maior[0]) maior[0] = n.chave;
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
        return Math.max(n.chave, Math.max(esquerdaMax, direitaMax));
    }
    
    public int contarFilhosDaDireita() {
        return 0;
    }

}
