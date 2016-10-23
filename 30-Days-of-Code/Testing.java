import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
        yes,no,yes,no,yes*/
        
        System.out.println(5);
        System.out.println(3+" "+2);
        System.out.println(0+" "+1+" "+2);
        System.out.println(3+" "+2);
        System.out.println(0+" "+(-1)+" "+2);
        System.out.println(2+" "+2);
        System.out.println(0+" "+1);
        System.out.println(2+" "+2);
        System.out.println(-1+" "+0);
        System.out.println(4+" "+3);
        System.out.println(0+" "+1+" "+(-2)+" "+2);
        
        /*Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0; i<t; i++){
            int n = scan.nextInt();
            int k = scan.nextInt();
            int c = 0;
            for(int j=0; j<n; j++){
                int a = scan.nextInt();
                if(a<=0) c++;
            }
            System.out.println((c>=k)? "NO" : "YES");
        }
        scan.close();*/
    }
}

or

import java.util.*;

public class Solution {
    Solution(int n, int k, int[] a){
        System.out.println(n + " " + k);
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // number of test cases - each test case is two lines
        int testCases = 5; 
        
        System.out.println(testCases);
        new Solution(4, 3, new int[] {-1, 0, 4, 2});
        new Solution(5, 2, new int[] {0, -1, 2, 1, 4});
        new Solution(7, 6, new int[] {2, 0, -1, 1 , 1 , 1, 1});
        new Solution(3, 1, new int[] {-1, 0, 4});
        new Solution(6, 4, new int[] {0, -1, 1, 4, 5, 6});
    }
}
