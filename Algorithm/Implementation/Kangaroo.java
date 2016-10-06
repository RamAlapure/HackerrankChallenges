//wrong answer

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        
        if((x2>x1 && v2>v1) || (x2<x1 && v2<v1)){
            System.out.println("NO");
        }
        
        int l = (x1+v1)*(x2+v2);
        
        for(int i=0; i<l; i++){
            x1 += v1;
            x2 += v2;
            if(x1 == x2){
                System.out.println("YES");
                i = 20001;
            }
        }
        if((x2>x1 && v2>v1) || (x2<x1 && v2<v1)){
            
        }else{ 
            if(x1 != x2) System.out.println("NO");
        }
        
    }
}
