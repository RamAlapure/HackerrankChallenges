import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numInputs = scan.nextInt();
        scan.close();
        
        for(int i = 1; i <= numInputs; i++){ // rows
            
            int j = numInputs;
            
            // loop to print (size - i) spaces
            while(j-- > i) {
                System.out.print(" ");
            }
            // loop to print (i) #s
            while(j-- >= 0) {
                System.out.print("#");
            }
            
            System.out.println();
        }
        
    }
}


//or

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for(int i=0; i<n+1; i++){
            for(int j=i; j<n; j++){
                if(j==0){
                    j = n-1;
                }else{
                    System.out.print(" ");
                }
            }
            for(int k=0; k<i; k++){
                System.out.print("#");
            }      
            if(i>0){
                System.out.println();
            }            
        }
    }
}
