package T2_RA791648;

import java.util.Arrays;

/*
*  Nome: Giovanna Victoria Rossetto
*  RA: 791648
*  Trabalho Pratico 2 - Tabelas Hash
*  Funcionalidades:
*    - Metodo da divisao
*    - Metodo da multiplicacao
*    - Hashing universal
*    - Encadeamento logico
*    - Enderecamento aberto
*        - sondagem linear
*        - sondagem quadratica
*        - double hashing
*/

public class Main {

   public static void main(String[] args) {

      int qttKeysManualTest = 10;
      int sizeManualTest = 13;
      int[] keysManualTest = {10, 22, 31, 4, 15, 28, 17, 88, 59};
      int qttManualTests = 7;
      Hash[] manualTests = new Hash[qttManualTests];

      manualTests[0] = new Hash(sizeManualTest, keysManualTest, true, 0, 1); // hashing_ManualTest_OpeanAdressing_LinearProbing_MultiplicationHashing
      manualTests[1] = new Hash(sizeManualTest, keysManualTest, true, 1, 0);
      manualTests[2] = new Hash(sizeManualTest, keysManualTest, true, 2, 0, 2);
      manualTests[3] = new Hash(sizeManualTest, keysManualTest, true, 2, 2, 1);

      manualTests[4] = new Hash(qttKeysManualTest, keysManualTest, false, 0);
      manualTests[5] = new Hash(qttKeysManualTest, keysManualTest, false, 1);
      manualTests[6] = new Hash(qttKeysManualTest, keysManualTest, false, 2);

      for (int i = 0; i < qttManualTests; i++) {
         manualTests[i].setA(64);
         manualTests[i].setB(7);
         manualTests[i].setC1(37);
         manualTests[i].setC2(109);
      }

      for (int i = 0; i < qttManualTests; i++) {
         for (int j : keysManualTest) {
            manualTests[i].insertKey(j);
         }
      }

      System.out.println("==============================================================================");
      System.out.println();
      System.out.println("------------- Demonstracao manual com conjunto de chaves pequeno -------------");
      System.out.println();
      System.out
            .println("Chaves do conjunto universo para todos os testes manuais: " + Arrays.toString(keysManualTest));
      System.out.println();

      for (int i = 0; i < qttManualTests; i++) {
         System.out.printf("------------------------------ Teste manual %02d -------------------------------\n", i + 1);
         System.out.println();
         System.out.println("Caracteristicas do espalhamento: " + manualTests[i].getDescription());
         System.out.println("Funcao hash: " + manualTests[i].hashFunction());
         System.out.println();
         for (int j = 0; j < (manualTests[i].getIsAddressing() ? sizeManualTest : qttKeysManualTest); j++) {
            System.out.print("Index " + j + ": "); // + manualTests[i].getLists().get(j)==null ? manualTests[i].getTable()[j] : );
            if (manualTests[i].getIsAddressing()) {
               System.out.println(manualTests[i].getTable()[j]);
            } else {
               if (manualTests[i].getLists().get(j).size()==0) {
                  System.out.println(manualTests[i].getTable()[j]);
               } else {
                  System.out.println(manualTests[i].getTable()[j] + " -> " + manualTests[i].getLists().get(j));
               }
            }
         }
         System.out.println();
         System.out.println("Numero de colisoes: " + manualTests[i].getCounterColisions());
         System.out.println();
         if (i < qttManualTests - 1) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println();
         }
      }
      System.out.println("==============================================================================");
      System.out.println();
   }

}
