
/*
The doc of isProbablePrime says : "Parameter certainty - a measure of the uncertainty that the caller is willing to tolerate: if the call returns true the probability that this BigInteger is prime exceeds (1 - (1/2)^certainty). The execution time of this method is proportional to the value of this parameter."
So it seems to me that a small value (1) would provide an important risk of false positive (the probability that the number tested is prime exceeds 1 - (1/2)^1 = 0.5 = 50%), and that using a bigger number as parameter would provide much more certainty ?
Since here we're looking for precision and not speed, it seems far more safe to give the parameter a bigger value.
In fact, I'm surprised that all the tests cases pass with a value of 1.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      BigInteger n = in.nextBigInteger();
      in.close();
      // Write your code here.
      System.out.println(n.isProbablePrime(1)? "prime" : "not prime");
   }
}
