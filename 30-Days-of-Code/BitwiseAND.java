/*
Logical Statements and Boolean Algebra
If you're not familiar with the term boolean algebra, you might be surprised to know that you likely already learned how to do this during the logic unit commonly taught during High School (secondary education). If you need a refresher, check out the Wikipedia article on Truth Tables.
Instead of using  (true) and  (false), boolean algebra uses the binary numbers  for true and  for false.
Basic Operators
Here are some commonly used Java operators you should familiarize yourself with:
& Bitwise AND (). This binary operation evaluates to  (true) if both operands are true, otherwise  (false). In other words:
1 & 1 = 1
1 & 0 = 0
0 & 1 = 0
0 & 0 = 0
| Bitwise Inclusive OR (). This binary operation evaluates to  if either operand is true, otherwise  (false) if both operands are false. In other words:
1 | 1 = 1
1 | 0 = 1
0 | 1 = 1
0 | 0 = 0
^ Bitwise Exclusive OR or XOR (). This binary operation evaluates to  (true) if and only if exactly one of the two operands is ; if both operands are  or , it evaluates to  (false). In other words:
1 ^ 1 = 0
1 ^ 0 = 1
0 ^ 1 = 1
0 ^ 0 = 0
~ The unary Bitwise Complement operator flips every bit; for example, the bitwise-inverted -bit binary number  becomes , and the bitwise-inverted signed decimal integer  becomes .
Example
The code below converts a word and an integer to binary strings:
class BinaryString {
    
    BinaryString(String string){
        for( byte b : string.getBytes() ){
            System.out.print(Integer.toBinaryString(b) + " ");
        }
        System.out.println();
    }
    
    BinaryString(Integer integer){
        System.out.println(Integer.toBinaryString(integer));
    }
    
    public static void main(String[] args) {
        new BinaryString("HackerRank");
        new BinaryString(8675309);
    }
}
When run, it prints the following output:
1001000 1100001 1100011 1101011 1100101 1110010 1010010 1100001 1101110 1101011 // Binary for "H a c k e r R a n k"
100001000101111111101101 // Binary for the integer 8675309
Next, let's modify the above class to find and print the OR of each character in the string with :
class BinaryString {

    BinaryString(String string, Integer integer){
        String binaryInteger = Integer.toBinaryString(integer);
        
        for( byte b : string.getBytes() ){
            // Perform a bitwise operation using byte and integer operands, save result as tmp:
            int tmp = b | integer; 
            System.out.println( Integer.toBinaryString(b) + " OR " + Integer.toBinaryString(integer) 
                + " = " + Integer.toBinaryString(tmp) + " = " + tmp );
        }
    }
    
    public static void main(String[] args) {
        new BinaryString("HackerRank", 8675309);
    }
}
The above code produces the following output:
1001000 OR 100001000101111111101101 = 100001000101111111101101 = 8675309
1100001 OR 100001000101111111101101 = 100001000101111111101101 = 8675309
1100011 OR 100001000101111111101101 = 100001000101111111101111 = 8675311
1101011 OR 100001000101111111101101 = 100001000101111111101111 = 8675311
1100101 OR 100001000101111111101101 = 100001000101111111101101 = 8675309
1110010 OR 100001000101111111101101 = 100001000101111111111111 = 8675327
1010010 OR 100001000101111111101101 = 100001000101111111111111 = 8675327
1100001 OR 100001000101111111101101 = 100001000101111111101101 = 8675309
1101110 OR 100001000101111111101101 = 100001000101111111101111 = 8675311
1101011 OR 100001000101111111101101 = 100001000101111111101111 = 8675311
Notice that the first  bits () are always the same. This is because bit position is counted starting with the least-significant (rightmost) bit and then it moves left so, in the example above, the only values with the potential to change are the lower (rightmost)  bits (as that is the number of bits in the smaller operand). For each bit position in the lower  bits, an OR operation is performed. If we were to again modify the above code to print the exclusive OR (instead of the inclusive OR), we would get this output:
1001000 XOR 100001000101111111101101 = 100001000101111110100101 = 8675237
1100001 XOR 100001000101111111101101 = 100001000101111110001100 = 8675212
1100011 XOR 100001000101111111101101 = 100001000101111110001110 = 8675214
1101011 XOR 100001000101111111101101 = 100001000101111110000110 = 8675206
1100101 XOR 100001000101111111101101 = 100001000101111110001000 = 8675208
1110010 XOR 100001000101111111101101 = 100001000101111110011111 = 8675231
1010010 XOR 100001000101111111101101 = 100001000101111110111111 = 8675263
1100001 XOR 100001000101111111101101 = 100001000101111110001100 = 8675212
1101110 XOR 100001000101111111101101 = 100001000101111110000011 = 8675203
1101011 XOR 100001000101111111101101 = 100001000101111110000110 = 8675206
If you're still having some trouble understanding how bitwise operations work, spend some time comparing the different outputs and experimenting with the code that produced them.
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int k = in.nextInt();
            if(((k-1)|k) > n && k%2==0){
                System.out.println(k-2);
            }else{
                System.out.println(k-1);               
            }
        }
    }
}
