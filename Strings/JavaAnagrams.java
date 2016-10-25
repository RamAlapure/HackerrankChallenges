import java.io.*;
import java.util.*;

public class Solution {
   
    //Time complexity O(n) - fast as per performance but complex
    static boolean isAnagram(String a, String b) {
        
        // Complete the function by writing your code here.

        // test for invalid input   
        if( a == null || b == null || a.equals("") || b.equals("") )
            throw new IllegalArgumentException();

        // initial quick test for non-anagrams
        if ( a.length() != b.length() )
            return false;

        a = a.toLowerCase();
        b = b.toLowerCase();

        // populate a map with letters and frequencies of String b
        Map<Character, Integer> map = new HashMap<>();

        for (int k = 0; k < b.length(); k++){
             char letter = b.charAt(k);    

            if( ! map.containsKey(letter)){
                map.put( letter, 1 );
            } else {
                Integer frequency = map.get( letter );
                map.put( letter, ++frequency );
            }
        }

        // test each letter in String a against data in the map
        // return if letter is absent in the map or its  frequency is 0
        // otherwise decrease the frequency by 1

        for (int k = 0; k < a.length(); k++){
            char letter = a.charAt(k);

            if( ! map.containsKey( letter ) )
                return false;

            Integer frequency = map.get( letter );

             if( frequency == 0 )
                return false;
            else    
                map.put( letter, --frequency);
        }
        // if the code got that far it is an anagram
        return true;
    }
  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

//or
//Time complexity 2*n*lon(n)+n/2 = n*log(n)
    static boolean isAnagram(String A, String B) {
        if(A == null && B == null) return false;
        else {
           char [] arrayA = A.toLowerCase().toCharArray();
           char [] arrayB = B.toLowerCase().toCharArray();
           Arrays.sort(arrayA);
           Arrays.sort(arrayB);
           return Arrays.equals(arrayA, arrayB);
       }
    }
