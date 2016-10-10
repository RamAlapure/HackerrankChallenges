import java.util.*;
import java.io.*;
import java.math.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int j=0; j<t; j++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int total = a;
            for(int i=0; i<n; i++){
               total += (b * (int)Math.pow(2,i));
               System.out.print(total + " ");
            }
            System.out.println();
        }
        in.close();
    }    
}
