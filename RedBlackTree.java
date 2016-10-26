public class RedBlackTree{
    
    
     private RBTreeNode currentNode;
     private RBTreeNode parentNodeNode;
     private RBTreeNode grandNode;
     private RBTreeNode greatNode;
     private RBTreeNode headerNode;  
     private static RBTreeNode emptyNode = null;
     
     static {
     
         RedBlackTree RBT = new RedBlackTree(0);
         emptyNode.left = emptyNode;
         emptyNode.right = emptyNode;
     }
     
     static final int BLACK = 1;    
     static final int RED   = 0;
     
     
      public RedBlackTree(int value){

         headerNode = new RBTreeNode(value);
         headerNode.left = emptyNode;
         headerNode.right = emptyNode;
         
      }
      
      public boolean isEmpty(){
        
         return headerNode.right == emptyNode;
     }
    
    //Not sure we have to keep or not// ASK?
     public void makeEmpty(){
     
         headerNode.right = emptyNode;
     }

      public void insert(int item ){
         
         currentNode = parentNodeNode = grandNode = headerNode;
         emptyNode.data = item;
      
       while (currentNode.data != item){            
             greatNode = grandNode; 
             grandNode = parentNodeNode; 
             parentNodeNode = currentNode;
             currentNode = item < currentNode.data ? currentNode.left : currentNode.right;
                       
           if (currentNode.left.color == RED && currentNode.right.color == RED)
                handleReorient( item );
                 
             if (currentNode != emptyNode)
             
                 return;
                 
             currentNode = new RBTreeNode(item, emptyNode, emptyNode);
         
             //add to the parentNodeNodeNode 
        
            if (item < parentNodeNode.data)
           
              parentNodeNode.left = currentNode;
             
            else
            
              parentNodeNode.right = currentNode;   
                  
              handleReorient( item );    
            }
          }
         
         private void handleReorient(int item){
         
          // changing color 
         
          currentNode.color = RED;
          currentNode.left.color = BLACK;
          currentNode.right.color = BLACK;
 
         if (parentNodeNode.color == RED){
             // Have to rotate
             grandNode.color = RED;
             if (item < grandNode.data != item < parentNodeNode.data)
                 parentNodeNode = rotate( item, grandNode );  //Double rotation 
             currentNode = rotate(item, greatNode );
             currentNode.color = BLACK;
         }
       
         // Make root black
         headerNode.right.color = BLACK;
       
         }
         
       
       private RBTreeNode rotate(int item, RBTreeNode parentNode){
       
         if(item < parentNodeNode.data)
         
             return parentNodeNode.left = item < parentNode.left.data ? rotateWithLeftChild(parentNode.left) : rotateWithRightChild(parentNode.left) ;  
         
         else
         
             return parentNode.right = item < parentNode.right.data ? rotateWithLeftChild(parentNode.right) : rotateWithRightChild(parentNode.right);  
     }
     
     /* Rotate binary tree node with left child */
     private RBTreeNode rotateWithLeftChild(RBTreeNode k2){
        
         RBTreeNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         return k1;
         
     }
     
     
     private RBTreeNode rotateWithRightChild(RBTreeNode k1){
        
         RBTreeNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         return k2;
     }
         
     
     public int countRBTreeNodes(){
          
         return countRBTreeNodes(headerNode.right);
     }
     
     private int countRBTreeNodes(RBTreeNode r){
        
         if (r == emptyNode)
             return 0;
         else{
         
             int l = 1;
             l += countRBTreeNodes(r.left);
             l += countRBTreeNodes(r.right);
             return l;
         }
     }
     
     public boolean searchNode(int val){
     
         return searchNode(headerNode.right, val);
     }
     
     private boolean searchNode(RBTreeNode r, int val){
     
         boolean found = false;
         while ((r != emptyNode) && !found){
         
             int rval = r.data;
             if (val < rval)
                 r = r.left;
             else if (val > rval)
                 r = r.right;
             else
             {
                 found = true;
                 break;
             }
             found = searchNode(r, val);
         }
         return found;
     }
     /* Function for inorder traversal */ 
     public void inorder(){
         inorder(headerNode.right);
         
     }
     private void inorder(RBTreeNode r){
        
         if (r != emptyNode){
         
             inorder(r.left);
             String c = "black";
             if (r.color == 0)
                 c = "red";
             System.out.print(r.data+""+c+" ");
             inorder(r.right);
         }
         
     }
           
     }