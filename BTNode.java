class BTNode {
   String data = "";
   BTNode leftChild = null;
   BTNode rightChild = null;
		
   public BTNode(){}
		
   public BTNode(String thedata, BTNode  theright, BTNode  theleft) {
      data = thedata;
      leftChild = theleft;
      rightChild = theright;
   }
   
   public String dataToString(){
      return data;
   }
		
   public BTNode getRight(){
      return rightChild;
   }
   
   public BTNode getLeft(){
      return leftChild;
   }
      
   public void setData(String thedata) {
      data = thedata;
   }	
   
   public void setRight(BTNode right){
      rightChild = right;
   }
   	
   public void setLeft(BTNode left){
      leftChild = left;
   }
} // class BTNode   {