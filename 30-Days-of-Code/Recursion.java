import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int result = factorial(scan.nextInt());
        System.out.println(result);
    }
    
    // Multiply 'n' by 'k' using addition:
    private static int factorial(int n) {
        // Recursive Case
        if(n > 1) { 
            return factorial(n-1)*n;
        }
        // Base Case n = 1
        else { 
            return n;
        }
    }

}
