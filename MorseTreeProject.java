import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseTreeProject   {

   BTNode root = new BTNode ();  //root stores no data, just a handle
			
   private void setUpTreeFromFile(String fileName) throws FileNotFoundException {
      Scanner location = new Scanner(new File(fileName));
      while(location.hasNextLine()){
         String data = location.nextLine().trim();
         if (data.length() > 0) {
             add(data.substring(0, 2).trim(), data.substring(2).trim());
         }
      }
   }
   
   public String encode(String inputEnglish){
      BTNode currentNode = root;
      String result = "";
      String symbol = "";
      for(char currentLetter : inputEnglish.toCharArray()){
         //should use recursion to find the morse code for the letter
         //however, it returns blank
         result = findMorse(currentNode, currentLetter + "", symbol); 
         System.out.println("here the result should print :" + result); //here the result should print
      }
      System.out.println(result);
      return result;
   }
   
   public String findMorse(BTNode current, String letter, String symbol){
      String result = "";
      if (current.data.compareTo(letter) == 0){
         System.out.println(symbol + " is the result");
         return symbol; //here i am returning the value
      }
      else{
         if (current.getLeft() != null){
            findMorse(current.getLeft(), letter, symbol + ".");
         }
         if (current.getRight() != null){
            findMorse(current.getRight(), letter, symbol + "-");
         }
      }
      return symbol;
   }

   public String decode(String inputMorseCode) {
      BTNode current = root;
   	String result = "";
      for(char currentMorseSymbol : inputMorseCode.toCharArray()) {
         if(currentMorseSymbol == '.'){
            if (current.leftChild != null) {
               current = current.leftChild;
            } else {
                current.setLeft(new BTNode());
                current = current.getLeft();
            }
         }
         else if(currentMorseSymbol == '-'){
            if (current.rightChild != null) {
               current = current.getRight();
            }
                else {
                    current.setRight(new BTNode());
                    current = current.rightChild;
                }
         }
         else {
            result += current.data;
            current = root;
         }
      	
         if(current == null) {  //not in the tree, avoid null exception below
            return null;
         }

      }  	
      return result += current.dataToString();
   }


   public void add(String data, String morse)  {
      BTNode newNode = new BTNode(data, null, null);
      if (root == null){
         root = newNode;
      }
      
      BTNode focusNode = root;
      BTNode parent = null;  //hint: you may need to keep a parent pointer hanging around for this function
   	
      for(char c : morse.toCharArray()) {
         if (c == '.') {
            if (focusNode.getLeft() != null) {
               focusNode = focusNode.getLeft();
            } 
            else {
               focusNode.setLeft(new BTNode());
               focusNode = focusNode.getLeft();
            }
         } 
         else {
            if (focusNode.getRight() != null) {
               focusNode = focusNode.getRight();
            } 
            else {
               focusNode.setRight(new BTNode());
               focusNode = focusNode.getRight();
            }
         }
      }  
      focusNode.setData(data);
   } // add
	
   public static void testAll() {
   // put your pre-user interactin test code here
      System.out.println("testAll asserts should be done.");
   }
   
   public static void main(String[] args) throws FileNotFoundException {
     	   	
      MorseTreeProject  morseTree = new MorseTreeProject ();

//       String letter = "S";
//       String morse = "...";
//       morseTree.add(letter, morse);
//       
//       String letter2 = "O";
//       String morse2 = "---";
//       morseTree.add(letter2, morse2);	
//       
//       letter2 = "G";
//       morse2 = "--.";
//       morseTree.add(letter2, morse2);	
//       
//    
//       testAll(morseTree);
//       System.out.println("test");
   
      morseTree.setUpTreeFromFile("Few.txt");
   	
      //System.out.println("Morse tree is: " + morseTree);
      //System.out.println(morseTree.encode("h"));
      System.out.println(morseTree.encode("q") + "testing");
     //System.out.println(morseTree.decode("--.-"));
      //System.out.println(morseTree.decode("-."));	
   } // main
   
   public static void testAll(MorseTreeProject morseTree) {
      System.out.println(morseTree.decode("..."));
      System.out.println(morseTree.decode("---"));
      System.out.println(morseTree.decode("--."));  // would fail with only S and O loaded in tree
   /*   	*/
      System.out.println("testAll(morseTree); asserts should be done.");
   
   } // testAll()
	
} // public class MorseTreeProject   {