import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for(int i=0; i<t; i++){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] a = new int[n];
            for(int j=0; j<n; j++){
                a[j] = scan.nextInt();
            }
            System.out.println(isSolvable(m, a, 0)? "YES" : "NO");
        }
    }
    
    private static boolean isSolvable(int m, int[] arr, int i) {
        if (i < 0 || arr[i] == 1) return false;
        if ((i == arr.length - 1) || i + m > arr.length - 1) return true;

        arr[i] = 1;
        return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
    }
}


//or

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i=0;i<t;i++){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] a = new int[n];
            boolean[] win = new boolean[n];
            for (int j=0;j<n;j++)
                a[j] = scan.nextInt();
            
            for (int j=n-1;j>=0;j--){
                if (a[j]==0&&(j+Math.max(1,m)>=n || win[j+1] || win[j+m])){
                    win[j] = true;
                    int k = j+1;
                    while (k<n-1&&a[k]==0&&!win[k]){
                        win[k] = true;
                        k++;
                    }
                }
            }
            
            System.out.println(win[0]?"YES":"NO");
        }
        scan.close();
    }
}
