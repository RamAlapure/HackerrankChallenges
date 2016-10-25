import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        sb = sb.reverse();
        if(A.equals(sb.toString())) System.out.println("Yes");
        else System.out.println("No");
    }
}


//or

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */        
        System.out.println(A.equals((new StringBuilder(A)).reverse().toString()) ? "Yes" :"No");
    }
}
