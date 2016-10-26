public class AVLTree{

   private Node root; // first node of tree
   
   public AVLTree(){ 
          root = null; // no nodes in tree yet
   }            


   public Node getRoot(){
          return root;
   }
   
   
   // RECURSIVE find node with given key
   public Node find(int key, Node y){

       if (y == null){
           
           return null;
           
       }else if (y.data == key){
           
           return y;
           
       }else if (y.data < key){
           
           return find(key, y.right);
           
       } else {
           
           return find(key, y.left);

       }
      
       } 
    
     // return height of tree rooted at x
     public int height(Node x){ 
     
      if (x == null) 
             
             return -1;
      else 
             return x.height;
     }
     
     
    public Node rotatewithleft(Node c){
     Node p;  // left child of c

     p = c.left;
     c.left = p.right;
     p.right = c;

     c.height = Math.max(height(c.left), height(c.right)) + 1;
     p.height = Math.max(height(p.left), height(p.right)) + 1;

     return p;

   }
     
    public Node rotatewithright(Node c){

     Node p;  // right child of c

     p = c.right;
     c.right = p.left;
     p.left = c;

     c.height = Math.max(height(c.left), height(c.right)) + 1;
     p.height = Math.max(height(p.left), height(p.right)) + 1;

     return p;

   }

   public Node doublerotatewithleft(Node c){

     Node tempNode;

     c.left = rotatewithright(c.left);
     tempNode = rotatewithleft(c);

     return tempNode;

   }
   
   public Node doublerotatewithright(Node c){

    Node tempNode;

    c.right = rotatewithleft(c.right);
    tempNode = rotatewithright(c);

    return tempNode;

   }
   
   public Node AVLinsert(Node newNode, Node rootOfsubtree){
    
    Node newrootOfsubtree = rootOfsubtree;  

   if (newNode.data < rootOfsubtree.data){
     if (rootOfsubtree.left == null){

         rootOfsubtree.left = newNode;  //attach new node as leaf

       }
     else {

         rootOfsubtree.left = AVLinsert(newNode, rootOfsubtree.left);   // branch left

         if ((height(rootOfsubtree.left) - height(rootOfsubtree.right)) == 2) {

            if (newNode.data < rootOfsubtree.left.data) {

              newrootOfsubtree=rotatewithleft(rootOfsubtree);

            }
            else {

              newrootOfsubtree=doublerotatewithleft(rootOfsubtree);

            } 
         } 
      } 
   } 
   
    
   else if (newNode.data > rootOfsubtree.data)/*Branch right*/{  
   
        if (rootOfsubtree.right == null){

            rootOfsubtree.right = newNode;   // attach new node as leaf

       }
     else {

           rootOfsubtree.right = AVLinsert(newNode, rootOfsubtree.right);  // branch right

           if ((height(rootOfsubtree.right) - height(rootOfsubtree.left)) == 2) {

            if (newNode.data > rootOfsubtree.right.data) {

              newrootOfsubtree=rotatewithright(rootOfsubtree);

            }
            else {

                  newrootOfsubtree=doublerotatewithright(rootOfsubtree);

            }
           } 
        } 
   }  

   else System.out.println("Duplicate Key");

   // Update the height

   if ((rootOfsubtree.left == null) && (rootOfsubtree.right != null))
      rootOfsubtree.height = rootOfsubtree.right.height + 1;
   else if ((rootOfsubtree.right == null) && (rootOfsubtree.left != null))
      rootOfsubtree.height = rootOfsubtree.left.height + 1;
   else
      rootOfsubtree.height = Math.max(height(rootOfsubtree.left), height(rootOfsubtree.right)) + 1;

   return newrootOfsubtree; // return new root of this subtree

   }
     
}
