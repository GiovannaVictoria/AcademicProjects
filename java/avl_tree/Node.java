package T1_RA791648;

public class Node {

   private int key;
   private Node father, left, right;

   // Construtor
   public Node (int key) {
      this.key = key;
      this.father = null;
      this.left = null;
      this.right = null;
   }

   // Getter do atributo key
   public int getKey () {
      return this.key;
   }

   // Setter do atributo key
   protected void setKey (int key) {
      this.key = key;
   }

   // Getter do atributo father
   public Node getFather () {
      return this.father;
   }

   // Setter do atributo father
   protected void setFather (Node father) {
      this.father = father;
   }

   // Getter do atributo left
   public Node getLeft () {
      return this.left;
   }

   // Setter do atributo left
   protected void setLeft (Node left) {
      this.left = left;
   }

   // Getter do atributo right
   public Node getRight () {
      return this.right;
   }

   // Setter do atributo left
   protected void setRight (Node right) {
      this.right = right;
   }

}
