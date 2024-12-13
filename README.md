<div align="center">

#  Árvore Binária Completa
O objetivo dessa atividade é completar a implementação do tipo abstrato de dados de árvore binária de pesquisa com
todos os métodos propostos.
Além da estrutura de dados também deve ser implementada uma aplicação de exemplo (AppExemplo.java) que
demonstre a execução de todos os métodos implementados na TAD.

# :hammer: Funcionalidades do projeto
O programa realiza os seguintes funções:
## Adicionar:
- `adicionar(int chave)`
- `adicionar(String lista)` //método para adicionar todas as chaves contidas em lista

## Boolean:
- `boolean estaVazia()`
- `boolean existe(int item)`
- `boolean ehInterno(int item)`
- `boolean ehExterno(int item)`

## Int: 
- `int obterTamanho()`
- `int obterEsquerda(int item)`
- `int obterDireita(int item)`
- `int obterPai(int item)`
- `int obterNivel(int item)`
- `int altura()`
- `int qtdNosNaoFolha()` //retorna a quantidade de nodos não folha
- `int qtdNodosFolha()` //quantidade de nodos folha
- `int obterMaiorValor()` //retorna a maior chave da árvore
- `int obterMenorValor()` //retorna a menor chave da árvore
- `int qtdPares()` //retorna a quantidade de chaves que são pares
- `int qtdImpares()` //retorna a quantidade de chaves são impares

## String:
- `String elementosPreOrdem()`
- `String elementosCentralOrdem()`
- `String elementosPosOrdem()`
- `String elementosLargura()`

## Void:
- `void limpar()`
- `void remover(int item)`
- `void mergear(ArvoreBinariaPesquisa t)` //esse método deve inserir todas as chaves da árvore t na árvore atual(a do objeto que está disparando esse método)


## Remover:
- `remover(String lista)` //método para remover todas as chaves contidas em lista. Esse parâmetro é um string que deve enviar as chaves a serem removidas separadas por vírgula.
- Exemplo: “34, 99, 12”.
- Remove 34, 99, 12

## GerarArvoreAleatoria
- `gerarArvoreAleatoria(int n)` //método que limpa a árvore atual e adiciona n chaves não repetidas na árvore

  # Autores:
| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/142232479?v=4" width=115><br><sub>Luiza Hackenhaar Naziazeno</sub>](https://github.com/luizahackenhaarnaziazeno) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/71355284?v=4" width=115><br><sub>Ricardo Soares</sub>](https://github.com/ric-soares) |
| :---: | :---: |

