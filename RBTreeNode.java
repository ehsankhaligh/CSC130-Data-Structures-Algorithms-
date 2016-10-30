public class RBTreeNode{

     RBTreeNode left, right;
     int data;
     int color;
 
     public RBTreeNode(int x ){
         
         this( x, null, null );
     } 
     
     public RBTreeNode(int x, RBTreeNode left, RBTreeNode right){
         
         this.left = left;
         this.right = right;
         data = x;
         color = 1;
         
     }   
     
    
}