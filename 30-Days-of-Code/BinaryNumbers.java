import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new  Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        String binaryString = Integer.toBinaryString(n);
        char[] binary = binaryString.toCharArray();
        int maxLength = 0;
        int tempLength = 0;

        for (int i = 0; i < binary.length; i++) {

            if (binary[i] == '1') {
                tempLength++;
            } else {
                tempLength = 0;
            }

            if (tempLength > maxLength) {
                maxLength = tempLength;
            }
        }
        System.out.println(maxLength);
    }
}
