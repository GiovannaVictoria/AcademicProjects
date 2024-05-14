package T1_RA791648;

import java.util.Arrays;

/* 
*  Nome: Giovanna Victoria Rossetto
*  RA: 791648
*  Trabalho Pratico 1 - Arvores AVL
*  Funcionalidades:
*    - Busca
*    - Impressao em ordem
*    - Impressao pos ordem
*    - Impressao pre ordem
*    - Insercao
*    - Maximo
*    - Minimo
*    - Predecessor
*    - Remocao
*    - Sucessor
*    - Verificar se esta vazia
*/ 

public class Main {

   public static void main(String[] args) {

      Tree tree = new Tree();
      int[] busca = {100, 300, 500, 800, 1400};
      int[] remocao = {100, 200, 800, 1500, 1700};
      int[] insercao = {100, 200, 300, 300, 400, 500, 500, 600, 700, 800, 900, 1000};

      System.out.println("---------- Criacao da arvore ---------");
      System.out.println();

      if (tree.empty()) {
         System.out.println("Arvore vazia");
      } else {
         System.out.println("Arvore nao vazia");
      }
      System.out.println();

      System.out.println("----------- Insercao de nos ----------");
      System.out.println();

      System.out.println("Nos que serao/tentarao ser inseridos: " + Arrays.toString(insercao));

      for (int i : insercao) {
         tree.insert(i);
      }

      System.out.print("Sequencia pre ordem: ");
      tree.preOrder(tree.getRoot());
      System.out.println();

      System.out.print("Sequencia em ordem: ");
      tree.inOrder(tree.getRoot());
      System.out.println();

      System.out.print("Sequencia pos ordem: ");
      tree.postOrder(tree.getRoot());
      System.out.println();

      System.out.println();

      System.out.println("----------- Remocao de nos -----------");
      System.out.println();

      System.out.println("Nos que serao/tentarao ser removidos: " + Arrays.toString(remocao));

      for (int i : remocao) {
         tree.delete(i);
      }

      System.out.print("Sequencia pre ordem: ");
      tree.preOrder(tree.getRoot());
      System.out.println();

      System.out.print("Sequencia em ordem: ");
      tree.inOrder(tree.getRoot());
      System.out.println();

      System.out.print("Sequencia pos ordem: ");
      tree.postOrder(tree.getRoot());
      System.out.println();

      System.out.println();

      System.out.println("------------ Busca de nos ------------");
      System.out.println();

      System.out.println("Nos que serao buscados: " + Arrays.toString(busca));

      for (int i : busca) {
         if (tree.search(i)) {
            System.out.printf("No de valor %d esta na arvore\n", i);
         } else {
            System.out.printf("No de valor %d nao esta na arvore\n", i);
         }
      }

      System.out.println();

      System.out.println("----------- Minimo e maximo ----------");
      System.out.println();

      System.out.println("Menor valor da arvore: " + tree.minimum(tree.getRoot()).getKey());
      System.out.println("Maior valor da arvore: " + tree.maximum(tree.getRoot()).getKey());

      System.out.println();

      System.out.println("------- Predecessor e sucessor -------");
      System.out.println();

      Node successor1 = tree.getRoot().getLeft().getRight();
      Node successor2 = tree.getRoot();
      Node predecessor1 = tree.getRoot();
      Node predecessor2 = tree.getRoot().getRight().getLeft();

      System.out.printf("Valor do sucessor do no de valor %d: %d\n", successor1.getKey(), tree.successor(successor1).getKey());
      System.out.printf("Valor do sucessor do no de valor %d: %d\n", successor2.getKey(), tree.successor(successor2).getKey());
      System.out.printf("Valor do predecessor do no de valor %d: %d\n", predecessor1.getKey(), tree.antecessor(predecessor1).getKey());
      System.out.printf("Valor do predecessor do no de valor %d: %d\n", predecessor2.getKey(), tree.antecessor(predecessor2).getKey());

      System.out.println();
      
      System.out.println("--------------------------------------");

   }
   
}
