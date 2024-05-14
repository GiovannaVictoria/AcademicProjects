package T2_RA791648;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;

public class Hash {

   private double K;                                    // K: constante multiplicativa no caso do metodo da multiplicacao;
   private int[] keys, table;                           // keys: conjunto universo; table: tabela hash;
   private String description;                          // description: descricao das caracteristicas do espalhamento;
   private boolean isAdressing;                         // isAdressing: true se o tratamento de colisoes for por enderecamento aberto, false caso contrario;
   private int a, b, c1, c2, p, size;                   // a, b, p: parametros do metodo de hashing universal;
                                                        // c1, c2: parametros do metodo de sondagem quadratica;
                                                        // size: tamanho da tabela  
   private int counterColisions;                        // counterColisions: contador de colisoes;
   private List<LinkedList<Integer>> lists;             // lists: listas geradas no tratamento de colisoes por encadeamento logico;
   private int hashMethod1, hashMethod2, probingMethod; // hashMethod1: metodo de hash no caso de sondagem linear ou quadratica, ou encadeamento logico;
                                                        // hashMethod2: segundo metodo de hash no caso de double hashing;
                                                        // probingMethod: sondagem linear, quadratica ou double hashing;

   /* Construtor da classe Hash com tratamento de colisoes por encadeamento logico */
   public Hash(int size, int[] keys, boolean isAdressing, int hashMethod1) {
      this.K = (Math.sqrt(5) - 1) / 2;
      this.size = size;
      this.keys = keys;
      this.isAdressing = isAdressing;
      this.hashMethod1 = hashMethod1;
      this.hashMethod2 = -1;
      this.probingMethod = -1;
      this.counterColisions = 0;
      table = new int[size];
      lists = new ArrayList<LinkedList<Integer>>();
      for (int i = 0; i < size; i++) {
         lists.add(new LinkedList<Integer>());
      }
      this.p = biggestKey();
      boolean prime = isPrime(p);
      for (; !prime; this.p++) {
         if (isPrime(this.p)) {
            prime = true;
         }
      }
      Random generate = new Random();
      this.a = generate.nextInt(1, p);
      this.b = generate.nextInt(0, p);
      this.c1 = (int) (Math.pow(2, generate.nextInt(2, 10))-1);
      this.c2 = (int) (Math.pow(2, generate.nextInt(2, 10))-1);
      this.description = "encadeamento logico";
      if (hashMethod1 == 0) {
         this.description += ", metodo da divisao";
      } else if (hashMethod1 == 1) {
         this.description += ", metodo da multiplicacao";
      } else if (hashMethod1 == 2) {
         this.description += ", hashing universal";
      }
   }

   /* Construtor da classe Hash com tratamento de colisoes por enderecamento aberto e sondagem linear ou quadratica */
   public Hash(int size, int[] keys, boolean isAdressing, int probingMethod, int hashMethod1) {
      this.K = (Math.sqrt(5) - 1) / 2;
      this.size = size;
      this.keys = keys;
      this.isAdressing = isAdressing;
      this.probingMethod = probingMethod;
      this.hashMethod1 = hashMethod1;
      this.hashMethod2 = -1;
      this.counterColisions = 0;
      table = new int[size];
      lists = new ArrayList<LinkedList<Integer>>();
      for (int i = 0; i < size; i++) {
         lists.add(new LinkedList<Integer>());
      }
      this.p = biggestKey();
      boolean prime = isPrime(p);
      for (; !prime; this.p++) {
         if (isPrime(this.p)) {
            prime = true;
         }
      }
      Random generate = new Random();
      this.a = generate.nextInt(1, p);
      this.b = generate.nextInt(0, p);
      this.c1 = (int) (Math.pow(2, generate.nextInt(2, 10))-1);
      this.c2 = (int) (Math.pow(2, generate.nextInt(2, 10))-1);
      this.description = "enderecamento aberto";
      if (probingMethod==0) {
         this.description += ", sondagem linear";
      } else if (probingMethod==1) {
         this.description += ", sondagem quadratica";
      }
      if (hashMethod1 == 0) {
         this.description += ", metodo da divisao";
      } else if (hashMethod1 == 1) {
         this.description += ", metodo da multiplicacao";
      } else if (hashMethod1 == 2) {
         this.description += ", hashing universal";
      }
   }

   /* Construtor da classe Hash com tratamento de colisoes por enderecamento aberto e hashing duplo */
   public Hash(int size, int[] keys, boolean isAdressing, int probingMethod, int hashMethod1, int hashMethod2) {
      this.K = (Math.sqrt(5) - 1) / 2;
      this.size = size;
      this.keys = keys;
      this.isAdressing = isAdressing;
      this.probingMethod = probingMethod;
      this.hashMethod1 = hashMethod1;
      this.hashMethod2 = hashMethod2;
      this.counterColisions = 0;
      table = new int[size];
      lists = new ArrayList<LinkedList<Integer>>();
      for (int i = 0; i < size; i++) {
         lists.add(new LinkedList<Integer>());
      }
      this.p = biggestKey();
      boolean prime = isPrime(p);
      for (; !prime; this.p++) {
         if (isPrime(this.p)) {
            prime = true;
         }
      }
      Random generate = new Random();
      this.a = generate.nextInt(1, p);
      this.b = generate.nextInt(0, p);
      this.c1 = (int) (Math.pow(2, generate.nextInt(2, 10))-1);
      this.c2 = (int) (Math.pow(2, generate.nextInt(2, 10))-1);
      this.description = "enderecamento aberto";
      if (probingMethod==2) {
         this.description += ", hashing duplo";
      }
      if (hashMethod1 == 0) {
         this.description += ", metodo da divisao";
      } else if (hashMethod1 == 1) {
         this.description += ", metodo da multiplicacao";
      } else if (hashMethod1 == 2) {
         this.description += ", hashing universal";
      }
      if (hashMethod2 == 0) {
         this.description += " e metodo da divisao";
      } else if (hashMethod2 == 1) {
         this.description += " e metodo da multiplicacao";
      } else if (hashMethod2 == 2) {
         this.description += " e hashing universal";
      }
   }

   /* Getter do atributo size */
   public int getSize() {
      return this.size;
   }

   /* Setter do atributo size */
   public void setSize(int size) {
      this.size = size;
   }

   /* Getter do atributo description */
   public String getDescription() {
      return this.description;
   }

   /* Setter do atributo description */
   public void setDescription(String description) {
      this.description = description;
   }

   /* Getter do atributo keys */
   public int[] getKeys() {
      return this.keys;
   }

   /* Setter do atributo keys */
   public void setKeys(int[] keys) {
      this.keys = keys;
   }

   /* Getter do atributo table */
   public int[] getTable() {
      return this.table;
   }

   /* Setter do atributo table */
   public void setTable(int[] table) {
      this.table = table;
   }

   /* Getter do atributo counterColisions */
   public int getCounterColisions() {
      return this.counterColisions;
   }

   /* Setter do atributo counterColisions */
   public void setCounterColisions(int counterColisions) {
      this.counterColisions = counterColisions;
   }

   /* Getter do atributo lists */
   public List<LinkedList<Integer>> getLists() {
      return this.lists;
   }

   /* Setter do atributo lists */
   public void setLists(List<LinkedList<Integer>> lists) {
      this.lists = lists;
   }

   /* Getter do atributo K */
   public double getK() {
      return this.K;
   }

   /* Setter do atributo K */
   public void setK(double K) {
      this.K = K;
   }

   /* Getter do atributo a */
   public int getA() {
      return this.a;
   }

   /* Setter do atributo a */
   public void setA(int a) {
      this.a = a;
   }

   /* Getter do atributo b */
   public int getB() {
      return this.b;
   }

   /* Setter do atributo b */
   public void setB(int b) {
      this.b = b;
   }

   /* Getter do atributo c1 */
   public int getC1() {
      return this.c1;
   }

   /* Setter do atributo c1 */
   public void setC1(int c1) {
      this.c1 = c1;
   }

   /* Getter do atributo c2 */
   public int getC2() {
      return this.c2;
   }

   /* Setter do atributo c2 */
   public void setC2(int c2) {
      this.c2 = c2;
   }

   /* Getter do atributo p */
   public int getP() {
      return this.p;
   }

   /* Setter do atributo p */
   public void setP(int p) {
      this.p = p;
   }

   /* Getter do atributo hashMethod1 */
   public int getHashMethod1() {
      return this.hashMethod1;
   }

   /* Setter do atributo hashMethod1 */
   public void setHashMethod1(int hashMethod1) {
      this.hashMethod1 = hashMethod1;
   }

   /* Getter do atributo hashMethod2 */
   public int getHashMethod2() {
      return this.hashMethod2;
   }

   /* Setter do atributo hashMethod2 */
   public void setHashMethod2(int hashMethod2) {
      this.hashMethod2 = hashMethod2;
   }

   /* Getter do atributo probingMethod */
   public int getProbingMethod() {
      return this.probingMethod;
   }

   /* Setter do atributo probingMethod */
   public void setProbingMethod(int probingMethod) {
      this.probingMethod = probingMethod;
   }

   /* Getter do atributo isAdressing */
   public boolean getIsAddressing() {
      return this.isAdressing;
   }

   /* Setter do atributo isAdressing */
   public void setIsAdressing(boolean isAdressing) {
      this.isAdressing = isAdressing;
   }

   /* Metodo da divisao: key mod size */
   public int divisionHashing(int k) {
      return k % this.size;
   }

   /* Metodo da multiplicacao: size * ( (key * K) mod 1 ) */
   public int multiplicationHashing(int k) {
      return (int) (Math.floor(this.size * ((k * this.K) % 1)));
   }

   /* Hashing universal: ( (a * key + b) mod p ) mod size */
   public int universalHashing(int k) {
      return ((this.a * k + this.b) % this.p) % this.size;
   }

   /*
      Nome: biggestKey
      Objetivo: encontrar a maior chave dentre o conjunto de chaves
      Parametros: nao ha
      Retorno: inteiro referente a maior chave
   */
   public int biggestKey() {
      int biggest = this.keys[0];
      for (int i = 1; i < this.keys.length; i++) {
         if (this.keys[i] > biggest) {
            biggest = this.keys[i];
         }
      }
      return biggest;
   }

   /*
      Nome: isPrime
      Objetivo: determinar se um inteiro n eh primo ou nao
      Parametros: inteiro n
      Retorno:
         - true se n for primo
         - false se n nao for primo
   */
   public boolean isPrime(int n) {
      int i = 2;
      boolean div = true;
      if (n == 1) {
         div = false;
      } else if (n > 2) {
         do {
            if (n % i == 0) { // verificando se n eh divisivel por i
               div = false;
            }
            i++;
         } while (!div && i <= Math.sqrt(n));
      }
      return div;
   }

   /*
      Nome: linearProbing
      Objetivo: encontrar a posicao de insercao da chave k atraves de sondagem linear
      Parametros: inteiro k - chave a ser inserida
      Retorno: inteiro referente a posicao de insercao da chave
   */
   public int linearProbing(int k) {
      int h = -1, i = 0;
      if (this.hashMethod1 == 0) {
         do {
            h = (divisionHashing(k) + i) % this.size;
            i++;
         } while (this.table[h] != 0);
      } else if (this.hashMethod1 == 1) {
         do {
            h = (multiplicationHashing(k) + i) % this.size;
            i++;
         } while (this.table[h] != 0);
      } else if (this.hashMethod1 == 2) {
         do {
            h = (universalHashing(k) + i) % this.size;
            i++;
         } while (this.table[h] != 0);
      }
      this.counterColisions += (i == 0) ? i : (i - 1);
      return h;
   }

   /*
      Nome: quadraticProbing
      Objetivo: encontrar a posicao de insercao da chave k atraves de sondagem quadratica
      Parametros: inteiro k - chave a ser inserida
      Retorno: inteiro referente a posicao de insercao da chave
   */
   public int quadraticProbing(int k) {
      int h = -1, i = 0;
      if (this.hashMethod1 == 0) {
         do {
            h = (divisionHashing(k) + i * this.c1 + i * i * this.c2) % this.size;
            i++;
         } while (this.table[h] != 0);
      } else if (this.hashMethod1 == 1) {
         do {
            h = (multiplicationHashing(k) + i * this.c1 + i * i * this.c2) % this.size;
            i++;
         } while (this.table[h] != 0);
      } else if (this.hashMethod1 == 2) {
         do {
            h = (universalHashing(k) + i * this.c1 + i * i * this.c2) % this.size;
            i++;
         } while (this.table[h] != 0);
      }
      this.counterColisions += (i == 0) ? i : (i - 1);
      return h;
   }

   /*
      Nome: doubleHashing
      Objetivo: encontrar a posicao de insercao da chave k atraves de hashing duplo
      Parametros: inteiro k - chave a ser inserida
      Retorno: inteiro referente a posicao de insercao da chave
   */
   public int doubleHashing(int k) {
      int h = -1, i = 0;
      if (this.hashMethod1 == 0) {
         if (this.hashMethod2 == 0) {
            do {
               h = (divisionHashing(k) + i * divisionHashing(k)) % this.size;
               i++;
            } while (this.table[h] != 0);
         } else if (this.hashMethod2 == 1) {
            do {
               h = (divisionHashing(k) + i * multiplicationHashing(k)) % this.size;
               i++;
            } while (this.table[h] != 0);
         } else if (this.hashMethod2 == 2) {
            do {
               h = (divisionHashing(k) + i * universalHashing(k)) % this.size;
               i++;
            } while (this.table[h] != 0);
         }
      } else if (this.hashMethod1 == 1) {
         if (this.hashMethod2 == 0) {
            do {
               h = (multiplicationHashing(k) + i * divisionHashing(k)) % this.size;
               i++;
            } while (this.table[h] != 0);
         } else if (this.hashMethod2 == 1) {
            do {
               h = (multiplicationHashing(k) + i * multiplicationHashing(k)) % this.size;
               i++;
            } while (this.table[h] != 0);
         } else if (this.hashMethod2 == 2) {
            do {
               h = (multiplicationHashing(k) + i * universalHashing(k)) % this.size;
               i++;
            } while (this.table[h] != 0);
         }
      } else if (this.hashMethod1 == 2) {
         if (this.hashMethod2 == 0) {
            do {
               h = (universalHashing(k) + i * divisionHashing(k)) % this.size;
               i++;
            } while (this.table[h] != 0);
         } else if (this.hashMethod2 == 1) {
            do {
               h = (universalHashing(k) + i * multiplicationHashing(k)) % this.size;
               i++;
            } while (this.table[h] != 0);
         } else if (this.hashMethod2 == 2) {
            do {
               h = (universalHashing(k) + i * universalHashing(k)) % this.size;
               i++;
            } while (this.table[h] != 0);
         }
      }
      this.counterColisions += (i == 0) ? i : (i - 1);
      return h;
   }

   /*
      Nome: hashFuncition
      Objetivo: montar uma string contendo a funcao hash usada na insercao das chaves
      Parametros: nao ha
      Retorno: string contendo a funcao hash
   */
   public String hashFunction() {
      String division = new String("(k mod " + this.size + ")");
      String multiplication = new String("floor(" + this.size + " * (k * " + this.K + " mod 1))");
      String universal = new String("((" + this.a + " * k + " + this.b + ") mod " + this.p + ") mod " + this.size);
      if (this.isAdressing) {
         if (this.probingMethod == 0) {
            if (this.hashMethod1 == 0) {
               return "(" + division + " + i) mod " + this.size;
            } else if (this.hashMethod1 == 1) {
               return "(" + multiplication + " + i) mod " + this.size;
            } else if (this.hashMethod1 == 2) {
               return "(" + universal + " + i) mod " + this.size;
            }
         } else if (this.probingMethod == 1) {
            if (this.hashMethod1 == 0) {
               return "(" + division + " + " + this.c1 + " * i + " + this.c2 + " * i^2) mod " + this.size;
            } else if (this.hashMethod1 == 1) {
               return "(" + multiplication + " + " + this.c1 + " * i + " + this.c2 + " * i^2) mod " + this.size;
            } else if (this.hashMethod1 == 2) {
               return "(" + universal + " + " + this.c1 + " * i + " + this.c2 + " * i^2) mod " + this.size;
            }
         } else if (this.probingMethod == 2) {
            if (this.hashMethod2 == -1) {
               return null;
            }
            if (this.hashMethod1 == 0) {
               if (this.hashMethod2 == 0) {
                  return "(" + division + " + i * " + division + ") mod " + this.size;
               } else if (this.hashMethod2 == 1) {
                  return "(" + division + " + i * " + multiplication + ") mod " + this.size;
               } else if (this.hashMethod2 == 2) {
                  return "(" + division + " + i * " + universal + ") mod " + this.size;
               }
            } else if (this.hashMethod1 == 1) {
               if (this.hashMethod2 == 0) {
                  return "(" + multiplication + " + i * " + division + ") mod " + this.size;
               } else if (this.hashMethod2 == 1) {
                  return "(" + multiplication + " + i * " + multiplication + ") mod " + this.size;
               } else if (this.hashMethod2 == 2) {
                  return "(" + multiplication + " + i * " + universal + ") mod " + this.size;
               }
            } else if (this.hashMethod1 == 2) {
               if (this.hashMethod2 == 0) {
                  return "(" + universal + " + i * " + division + ") mod " + this.size;
               } else if (this.hashMethod2 == 1) {
                  return "(" + universal + " + i * " + multiplication + ") mod " + this.size;
               } else if (this.hashMethod2 == 2) {
                  return "(" + universal + " + i * " + universal + ") mod " + this.size;
               }
            }
         }
      } else {
         if (this.hashMethod1 == 0) {
            return division;
         } else if (this.hashMethod1 == 1) {
            return multiplication;
         } else if (this.hashMethod1 == 2) {
            return universal;
         }
      }
      return null;
   }

   /*
      Nome: openAdressing
      Objetivo: inserir a chave k tratando as colisoes com enderecamento aberto
      Parametros: inteiro k - chave a ser inserida
      Retorno:
         - true se a chave foi inserida
         - false se a chave nao foi inserida (no caso, se algum dos parametros isAdressing ou hashMethod foi passado incorretamente)
   */
   public boolean openAdressing(int k) {
      int h;
      if (!this.isAdressing) {
         return false;
      }
      if (this.probingMethod == 0) {
         h = linearProbing(k);
         if (h == -1) {
            return false;
         }
         table[h] = k;
      } else if (this.probingMethod == 1) {
         h = quadraticProbing(k);
         if (h == -1) {
            return false;
         }
         table[h] = k;
      } else if (probingMethod == 2) {
         h = doubleHashing(k);
         if (h == -1) {
            return false;
         }
         table[h] = k;
      }
      return true;
   }

   /*
      Nome: separateChaining
      Objetivo: inserir a chave k tratando as colisoes com encadeamento logico
      Parametros: inteiro k - chave a ser inserida
      Retorno:
         - true se a chave foi inserida
         - false se a chave nao foi inserida (no caso, se algum dos parametros isAdressing ou hashMethod foi passado incorretamente)
   */
   public boolean separateChaining(int k) {
      int h;
      if (this.isAdressing) {
         return false;
      }
      if (this.hashMethod1 == 0) {
         h = divisionHashing(k);
         if (h == -1) {
            return false;
         }
         if (this.table[h] != 0) {
            lists.get(h).add(k);
            this.counterColisions++;
         } else {
            table[h] = k;
         }
      } else if (this.hashMethod1 == 1) {
         h = multiplicationHashing(k);
         if (h == -1) {
            return false;
         }
         if (this.table[h] != 0) {
            lists.get(h).add(k);
            this.counterColisions++;
         } else {
            table[h] = k;
         }
      } else if (this.hashMethod1 == 2) {
         h = universalHashing(k);
         if (h == -1) {
            return false;
         }
         if (this.table[h] != 0) {
            lists.get(h).add(k);
            this.counterColisions++;
         } else {
            table[h] = k;
         }
      }
      return true;
   }

   /*
      Nome: insertKey
      Objetivo: inserir a chave k
      Parametros: inteiro k - chave a ser inserida
      Retorno:
         - true se a chave foi inserida
         - false se a chave nao foi inserida (no caso, se algum dos parametros isAdressing ou hashMethod foi passado incorretamente)
   */
   public boolean insertKey(int k) {
      // if tabela cheia
      if (this.isAdressing) {
         return openAdressing(k);
      } else {
         return separateChaining(k);
      }
   }

}