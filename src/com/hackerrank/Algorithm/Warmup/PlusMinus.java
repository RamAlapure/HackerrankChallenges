package com.hackerrank.Algorithm.Warmup;

// or with BigDecimal

import java.util.*;
import java.math.*;

public class PlusMinus {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int y = scan.nextInt();
        int pos = 0;
        int neg = 0;
        int zero = 0;
        for(int i=0; i<y; i++){
            int x = scan.nextInt();
            if(x>0){
                pos++;
            }else if(x<0){
                neg++;
            }else{
                zero++;
            }
        }
        BigDecimal p = new BigDecimal(pos);
        BigDecimal n = new BigDecimal(neg);
        BigDecimal z = new BigDecimal(zero);
        BigDecimal x = new BigDecimal(y);
        
        System.out.println(p.divide(x, y, RoundingMode.CEILING));
        System.out.println(n.divide(x, y, RoundingMode.CEILING));
        System.out.println(z.divide(x, y, RoundingMode.CEILING));
    }
}
