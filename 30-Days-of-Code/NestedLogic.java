import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int Da = scan.nextInt();
        int Ma = scan.nextInt();
        int Ya = scan.nextInt();
        int De = scan.nextInt();
        int Me = scan.nextInt();
        int Ye = scan.nextInt();
        int d = Da-De;
        int m = Ma-Me;
        int y = Ya-Ye;
        
        if(d>0 && m==0 && y==0) System.out.println(15*d);
        else if(m>0 && y==0) System.out.println(500*m);
        else if(y>0) System.out.println(10000);
        else System.out.println(0);
            
        /*System.out.println((y>0) ? 10000
            : (m>0 && y==0) ? m * 500
            : (d>0 && m==0 && y==0) ? d * 15
            : 0);*/
    
    }
}
