import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numInputs = scan.nextDouble();
        int posInputs = 0;
        int negInputs = 0;
        int zeroInputs = 0;

        for(int i = 0; i < numInputs; i++){
            int tmp = scan.nextInt();
            
            if (tmp > 0){
                posInputs++;
            }
            else if(tmp < 0){
                negInputs++;
            }
            else{
                zeroInputs++;
            }
        }
        scan.close();
        
        // Print result:
        System.out.println(posInputs / numInputs);
        System.out.println(negInputs / numInputs);
        System.out.println(zeroInputs / numInputs);
    }
}


// or with BigDecimal

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

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
