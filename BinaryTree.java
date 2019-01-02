public class BinaryTree {

   BTNode root;
   
   public void add(String data, String morse){
   
      BTNode newNode = new BTNode(data, morse);
      
      if (root == null){
      
         root = newNode;
         
      }
      
      else {
      
         Node focusNode = root;
         
         Node parent;
         
         while(true){
         
            parent = focusNode;
            
            if(key < focusNode.key){
            
               focusNode = focusNode.leftChild;
               
               if (focusNode == null){
               
                  parent.leftChild = newNode;
                  return;
               
               }
            
            }
            
            else {
            
               focusNode = focusNode.rightChild;
               
               if (focusNode == null){
               
                  parent.rightChild = newNode;
                  return;
                  
               }
            
            }
         
         }
      
      }
   
   }
   
   public static void main(String[] args){
   
   }

}

class BTNode {
   
   int key;
   String name;
   
   Node leftChild;
   Node rightChild;
   
   Node(int key, String name){
   
      this.Key = key;
      
      this.name = name;
   
   }
   
   public toString(){
   
      return name + " has a key " + key;
   
   }
}