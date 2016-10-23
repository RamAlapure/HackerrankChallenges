import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i=0; i<n; i++){
            int num = scan.nextInt();
            int count=0;
            for(int j=2; j<(num/2); j++){
                if(num%j==0) {
                    count++;
                    j=num/2;
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
