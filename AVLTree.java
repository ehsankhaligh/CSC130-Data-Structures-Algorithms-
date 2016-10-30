public class AVLTree{

   private AVLNode root; // first node of tree
   
   public AVLTree(){ 
          
       root = null; // no nodes in tree yet
   }            


   public AVLNode getRoot(){
          return root;
   }
   
   
   // RECURSIVE find node with given key
   public AVLNode find(int key, AVLNode y){

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
     public int height(AVLNode x){ 
     
      if (x == null) 
             
             return -1;
      else 
             return x.height;
     }
     
     
    public AVLNode rotatewithleft(AVLNode c){
       
       AVLNode p;  // left child of c
       
       p = c.left;
       c.left = p.right;
       p.right = c;

       c.height = Math.max(height(c.left), height(c.right)) + 1;
       p.height = Math.max(height(p.left), height(p.right)) + 1;

       return p;

   }
     
    public AVLNode rotatewithright(AVLNode c){

       AVLNode p;  // right child of c

       p = c.right;
       c.right = p.left;
       p.left = c;

       c.height = Math.max(height(c.left), height(c.right)) + 1;
       p.height = Math.max(height(p.left), height(p.right)) + 1;

       return p;

   }

   public AVLNode doublerotatewithleft(AVLNode c){

       AVLNode tempAVLNode;

       c.left = rotatewithright(c.left);
       tempAVLNode = rotatewithleft(c);

       return tempAVLNode;

   }
   
   public AVLNode doublerotatewithright(AVLNode c){

      AVLNode tempAVLNode;

      c.right = rotatewithleft(c.right);
      tempAVLNode = rotatewithright(c);

      return tempAVLNode;

   }
   
   public AVLNode AVLinsert(AVLNode newAVLNode, AVLNode rootOfsubtree){
    
    AVLNode newrootOfsubtree = rootOfsubtree;  

   if (newAVLNode.data < rootOfsubtree.data){
     if (rootOfsubtree.left == null){

         rootOfsubtree.left = newAVLNode;  //attach new node as leaf

       }
     else {

         rootOfsubtree.left = AVLinsert(newAVLNode, rootOfsubtree.left);   // branch left

         if ((height(rootOfsubtree.left) - height(rootOfsubtree.right)) == 2) {

            if (newAVLNode.data < rootOfsubtree.left.data) {

              newrootOfsubtree=rotatewithleft(rootOfsubtree);

            }
            else {

              newrootOfsubtree=doublerotatewithleft(rootOfsubtree);

            } 
         } 
      } 
   } 
   
    
   else if (newAVLNode.data > rootOfsubtree.data)/*Branch right*/{  
   
        if (rootOfsubtree.right == null){

            rootOfsubtree.right = newAVLNode;   // attach new node as leaf

       }
     else {

           rootOfsubtree.right = AVLinsert(newAVLNode, rootOfsubtree.right);  // branch right

           if ((height(rootOfsubtree.right) - height(rootOfsubtree.left)) == 2) {

            if (newAVLNode.data > rootOfsubtree.right.data) {

              newrootOfsubtree=rotatewithright(rootOfsubtree);

            }
            else {

                  newrootOfsubtree=doublerotatewithright(rootOfsubtree);

            }
           } 
        } 
   }  

   // else System.out.println("Duplicate Key");

   // Update the height

   if ((rootOfsubtree.left == null) && (rootOfsubtree.right != null))
     
      rootOfsubtree.height = rootOfsubtree.right.height + 1;
   
   else if ((rootOfsubtree.right == null) && (rootOfsubtree.left != null))
   
      rootOfsubtree.height = rootOfsubtree.left.height + 1;
   
   else
   
      rootOfsubtree.height = Math.max(height(rootOfsubtree.left), height(rootOfsubtree.right)) + 1;

   return newrootOfsubtree; // return new root of this subtree

   }
   
   public void insert(int id){
         
         AVLNode newNode = new AVLNode(id);    // make new node

         if(root==null)
        
         root = newNode;
         
         else{

           root=AVLinsert(newNode, root); 
         }
   }     
     
}
