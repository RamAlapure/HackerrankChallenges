package com.hackerrank.basics;

import java.util.*;

class ConditionalStatements {
   
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt(); 
      scan.close();
      String ans="";
      
      // if 'n' is NOT evenly divisible by 2 (i.e.: n is odd)
      if((n%2==1) || ((n%2==0) && (n>=6 && n<=20))){
         ans = "Weird";
      }
      if(((n%2==0) && (n>=2 && n<=5)) || ((n%2==0) && (n>20))){
         // Complete the code 
          ans = "Not Weird";
      }
      System.out.println(ans);
   }
}
