package T1_RA791648;

import java.lang.Math;

public class Tree {

   private Node root;

   // Construtor
   public Tree () {
      this.root = null;
   }

   // Getter do atributo root
   public Node getRoot () {
      return this.root;
   }
   
   // Setter do atributo root
   protected void setRoot (Node root) {
      this.root = root;
   }

   /*
   * Nome: antecessor
   * Objetivo: buscar o predecessor de um no em uma arvore
   * Parametros:
   *    - node: no cujo predecessor sera buscado
   * Retorno: node referente ao predecessor do no
   */
   public Node antecessor (Node node) {
      if (node.getLeft()!=null) {
         return maximum(node.getLeft());
      }
      Node aux = node.getFather();
      if (aux!=null) {
         while (aux!=null && node==aux.getLeft()) {
            node = aux;
            aux = aux.getFather();
         }
      }
      return aux;
   }

   /*
   * Nome: balance 
   * Objetivo: balancear um no desbalanceado e seus ancestrais
   * Parametros:
   *    - node: no mais baixo a ser balanceado
   * Retorno: void
   */
   protected void balance (Node node) {
      while (node!=null) {
         if (balanceFactor(node) > 1) {
            if (balanceFactor(node.getLeft()) >= 0) {
               rightRotate(node);
            } else {
               leftRightRotate(node);
            }
         } else if (balanceFactor(node) <-1) {
            if (balanceFactor(node.getRight()) <= 0) {
               leftRotate(node);
            } else {
               rightLeftRotate(node);
            }
         }
         node = node.getFather();
      }
   }

   /*
   * Nome: balanceFactor
   * Objetivo: calcular o fator de balanceamento de um no
   * Parametros:
   *    - node: no cujo fator de balanceamento sera calculado
   * Retorno: int referente ao fator de balanceamento
   */
   protected int balanceFactor (Node node) {
      return height(node.getLeft()) - height(node.getRight());
   }

   /*
   * Nome: delete 
   * Objetivo: remover um no da arvore, se ele existir
   * Parametros:
   *    - key: inteiro referente que valor que sera removido
   * Retorno:
   *    - true em caso de remocao realizada
   *    - false em caso de remocao nao realizada
   */
   public boolean delete (int key) {
      Node aux = this.root, auxBalance;
      // percorre a arvore procurando o no a ser removido
      while (aux!=null && aux.getKey()!=key) {
         if (aux.getKey()<key) {
            aux = aux.getRight();
         } else {
            aux = aux.getLeft();
         }
      }
      // a arvore nao contem o no
      if (aux==null) {
         return false;
      }
      if (aux.getLeft()==null) {                // o no a ser removido contem no maximo o filho da direita
         auxBalance = aux.getRight();           // o ancestral mais proximo que pode ficar desbalanceado
         transplant(aux, aux.getRight());
      } else if (aux.getRight()==null) {        // o no a ser removido contem no maximo o filho da esquerda
         auxBalance = aux.getLeft();            // o ancestral mais proximo que pode ficar desbalanceado
         transplant(aux, aux.getLeft());
      } else {                                  // o no a ser removido possui os dois filhos
         Node min = minimum(aux.getRight());    // encontra o sucessor do no a ser removido
         auxBalance = min;                      // o ancestral mais proximo que pode ficar desbalanceado
         if (aux.getRight()!=min) {             // o sucessor nao eh filho a direita do no a ser removido
            auxBalance = min.getFather();       // nesse caso, esse eh o ancestral mais proximo que pode ficar desbalanceado
            transplant (min, min.getRight());
            min.setRight(aux.getRight());
            aux.setRight(null);
            min.getRight().setFather(min);
         }
         transplant(aux, min);
         min.setLeft(aux.getLeft());
         aux.setLeft(null);
         aux.setRight(null);
         min.getLeft().setFather(min);
      }
      // balanceia a arvore
      balance(auxBalance);
      return true;
   }

   /*
   * Nome: height 
   * Objetivo: calcular a altura de um no
   * Parametros:
   *    - node: no cuja altura sera calculada
   * Retorno: int referente a altura
   */
   public int height (Node node) {
      if (node==null) {
         return -1;
      }
      return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
   }

   /*
   * Nome: inOrder
   * Objetivo: percorrer e imprimir os nos da arvore na sequencia Em Ordem
   * Parametros:
   *    - node: no contendo a subarvore a ser percorrida e impressa
   * Retorno: void
   */
   public void inOrder (Node node) {
      if (node==null) {
         return;
      }
      inOrder(node.getLeft());
      System.out.print(node.getKey() + " ");
      inOrder(node.getRight());
   }

   /*
   * Nome: insert
   * Objetivo: inserir um no na arvore, se ele ainda nao existir
   * Parametros:
   *    - key: valor do no a ser inserido na arvore
   * Retorno:
   *    - true em caso de insercao realizada
   *    - false em caso de insercao nao realizada
   */
   public boolean insert (int key) {
      // arvore vazia
      if (empty()) {
         this.root = new Node (key);
         return true;
      }
      // arvore ja contem o no
      if (search(key)){
         return false;
      }
      Node atual = this.root;
      Node ant = atual;
      Node newNode = new Node (key);
      // procura a posicao certa para a insercao
      while (atual!=null) {
         ant = atual;
         if (atual.getKey()<key) {
            atual = atual.getRight();
         } else {
            atual = atual.getLeft();
         }
      }
      // insere
      if (ant.getKey()<key) {
         ant.setRight(newNode);
      } else {
         ant.setLeft(newNode);
      }
      newNode.setFather(ant);
      // balanceia a arvore
      balance (ant);
      return true;
   }

   /*
   * Nome: empty
   * Objetivo: verificar se uma arvore esta vazia ou nao
   * Parametros: nao ha
   * Retorno:
   *    - true se a arvore estiver vazia
   *    - true se a arvore nao estiver vazia
   */
   public boolean empty () {
      return this.root==null;
   }

   /*
   * Nome: leftRightRotate
   * Objetivo: fazer uma rotacao dupla esquerda-direita em uma subarvore
   * Parametros:
   *    - node: subarvore que sofera a rotacao
   * Retorno: void
   */
   protected void leftRightRotate (Node node) {
      leftRotate(node.getLeft());
      rightRotate(node);
   }

   /*
   * Nome: leftRotate
   * Objetivo: fazer uma rotacao simples a esquerda em uma subarvore
   * Parametros:
   *    - node: subarvore que sofera a rotacao
   * Retorno: void
   */
   protected void leftRotate (Node node) {
      Node aux = node.getRight();
      node.setRight(aux.getLeft());
      if (aux.getLeft()!=null) {
         aux.getLeft().setFather(node);
      }
      aux.setLeft(node);
      aux.setFather(node.getFather());
      if (node.getFather()!=null) {
         if (node.getFather().getRight()==node) {
            node.getFather().setRight(aux);
         } else {
            node.getFather().setLeft(aux);
         }
      
      }
      node.setFather(aux);
      if (aux.getFather()==null) {
         this.root = aux;
      }
   }

   /*
   * Nome: maximum
   * Objetivo: encontrar o no de maior valor em uma subarvore
   * Parametros:
   *    - node: subarvore que contem o no de maior valor
   * Retorno: Node referente ao no de maior valor
   */
   public Node maximum (Node node) {
      if (node==null) {
         return null;
      }
      Node aux = node;
      while (aux.getRight()!=null) {
         aux = aux.getRight();
      }
      return aux;
   }

   /*
   * Nome: minimun
   * Objetivo: encontrar o no de menor valor em uma subarvore
   * Parametros:
   *    - node: subarvore que contem o no de menor valor
   * Retorno: Node referente ao no de menor valor
   */
   public Node minimum (Node node) {
      if (node==null) {
         return null;
      }
      Node aux = node;
      while (aux.getLeft()!=null) {
         aux = aux.getLeft();
      }
      return aux;
   }

   /*
   * Nome: posOrder
   * Objetivo: percorrer e imprimir os nos da arvore na sequencia Pos Ordem
   * Parametros:
   *    - node: no contendo a subarvore a ser percorrida e impressa
   * Retorno: void
   */
   public void postOrder (Node node) {
      if (node==null) {
         return;
      }
      postOrder(node.getLeft());
      postOrder(node.getRight());
      System.out.print(node.getKey() + " ");
   }

   /*
   * Nome: preOrder
   * Objetivo: percorrer e imprimir os nos da arvore na sequencia Pre Ordem
   * Parametros:
   *    - node: no contendo a subarvore a ser percorrida e impressa
   * Retorno: void
   */
   public void preOrder (Node node) {
      if (node==null) {
         return;
      }
      System.out.print(node.getKey() + " ");
      preOrder(node.getLeft());
      preOrder(node.getRight());
   }

   /*
   * Nome: rightLeftRotate
   * Objetivo: fazer uma rotacao dupla direita-esquerda em uma subarvore
   * Parametros:
   *    - node: subarvore que sofera a rotacao
   * Retorno: void
   */
   protected void rightLeftRotate (Node node) {
      rightRotate(node.getRight());
      leftRotate(node);
   }

   /*
   * Nome: rightRotate
   * Objetivo: fazer uma rotacao simples a direita em uma subarvore
   * Parametros:
   *    - node: subarvore que sofera a rotacao
   * Retorno: void
   */
   protected void rightRotate (Node node) {
      Node aux = node.getLeft();
      node.setLeft(aux.getRight());
      if (aux.getRight()!=null) {
         aux.getRight().setFather(node);
      }
      aux.setRight(node);
      aux.setFather(node.getFather());
      if (node.getFather()!=null) {
         if (node.getFather().getRight()==node) {
            node.getFather().setRight(aux);
         } else {
            node.getFather().setLeft(aux);
         }
      }
      node.setFather(aux);
      if (aux.getFather()==null) {
         this.root = aux;
      }
   }

   /*
   * Nome: search
   * Objetivo: buscar um no de valor especifico em uma arvore
   * Parametros:
   *    - key: valor que sera procurado na arvore
   * Retorno:
   *    - true se a arvore contem o no
   *    - false se a arvore nao contem o no
   */
   public boolean search (int key) {
      if (empty()) {
         return false;
      } else {
         Node atual = this.root;
         Node ant = atual;
         while (atual!=null && atual.getKey()!=key) {
            ant = atual;
            if (atual.getKey()<key) {
               atual = atual.getRight();
            } else {
               atual = atual.getLeft();
            }
         }
         return (atual!=null || ant.getKey()==key);
      }
   }

   /*
   * Nome: successor
   * Objetivo: buscar o sucessor de um no em uma arvore
   * Parametros:
   *    - node: no cujo sucessor sera buscado
   * Retorno: node referente ao sucessor do no
   */
   public Node successor (Node node) {
      if (node.getRight()!=null) {
         return minimum(node.getRight());
      }
      Node aux = node.getFather();
      if (aux!=null) {
         while (aux!=null && node==aux.getRight()) {
            node = aux;
            aux = aux.getFather();
         }
      }
      return aux;
   }

   /*
   * Nome: transplant
   * Objetivo: substituir uma subarvore enraizada por x por outra subarvore enraizada por y
   * Parametros:
   *    - x: raiz da subarvore que sera substituido
   *    - y: raiz da subarvore que substituira
   * Retorno: void
   */
   protected void transplant (Node x, Node y) {
      if (x.getFather()==null) {
         this.root = y;
      } else if (x.getFather().getLeft()==x) {
         x.getFather().setLeft(y);
      } else {
         x.getFather().setRight(y);
      }
      if (y!=null) {
         y.setFather(x.getFather());
         x.setFather(null);
      }
   }

}
