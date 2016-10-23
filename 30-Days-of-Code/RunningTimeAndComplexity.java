import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for(int i=0; i<n; i++){
            int num = scan.nextInt();
            int k = (int)Math.sqrt(num);
            int count=0;
            if(num<2) System.out.println("Not prime");
            else{
                for(int j=2; j<=k; j++){
                    if(num%j==0) {
                        count++;
                        j=k;
                    }
                }
                if(count<1){
                    System.out.println("Prime");
                }else{
                    System.out.println("Not prime");
                }
            }            
        }
    }
}
