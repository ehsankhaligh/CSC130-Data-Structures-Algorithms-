import java.util.*;
import java.lang.*;
import java.io.*;

public class Main{

   public static void main (String args []){
   
       Random random = new Random();
       int arrayAssending[] = new int[10000];
       int arrayDescending[] = new int [10000];
       
       AVLTree avlTree = new AVLTree();
       
       //RedBlackTree RBT = new RedBlackTree(-1);
       
       try{
       
         RedBlackTree RBT = new RedBlackTree(-1);
       
       } catch (ExceptionInInitializerError e) {
         
         System.out.println("Red black Tree Exception");
       
       }
    
    
    // compiler throws exception for Red Black Tree and I used try catch to catch the exception 
       
    /*  ----jGRASP exec: java Main
 Exception in thread "main" java.lang.ExceptionInInitializerError
 	at Main.main(Main.java:16)
 Caused by: java.lang.NullPointerException
 	at RedBlackTree.<clinit>(RedBlackTree.java:14)
 	... 1 more*/

      

       
       for(int i = 0; i< 10000; i++){
         
         //arrayAssending[i]= i+1;
         //System.out.println(arrayAssending[i]); //Test it prints all the numbers
        
         avlTree.insert(i);
         //RBT.insert(i); //gives error because of exception
         
         
                  
       }
       
       long startTime = System.nanoTime();
       long estimatedTime = System.nanoTime() - startTime;   
       System.out.println(estimatedTime);   
       
       for(int j=10000; j>=1; j--){
         
          //arrayDescending[j-1] = j;
          //System.out.println(arrayDescending[j-1]);//Test it prints all the numbers          
          
          avlTree.insert(j);
          //RBT.insert(j);//gives error because of exception

       } 
       
       long startTime1 = System.nanoTime();
       long estimatedTime1 = System.nanoTime() - startTime1;   
       System.out.println(estimatedTime1);        
       
       for(int k=0;k<10000; k++){
       
         //arrayAssending[k] = random.nextInt(10000)+1;//Between 1 and 10000
         //System.out.println(arrayAssending[k]);//Test it prints all the numbers
         
         
         avlTree.insert(k);
         //RBT.insert(k); //gives error because of exception
         
       }
       
       long startTime2 = System.nanoTime();
       long estimatedTime2 = System.nanoTime() - startTime2;   
       System.out.println(estimatedTime2);        
            
   }
}