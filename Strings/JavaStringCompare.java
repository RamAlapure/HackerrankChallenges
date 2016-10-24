import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        
        String str=scan.next();
        int k=scan.nextInt();
        SortedSet<String> sets = new TreeSet<String>();
        for(int i=0;i<=str.length()-k;i++){
            sets.add(str.substring(i,i+k));
        }
        System.out.println(sets.first());
        System.out.println(sets.last());
    }
}

//or

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String S = scan.next();
        int n = scan.nextInt();
        List<String> list = new ArrayList<String>();
        for(int i=0; i<=S.length()-n; i++){
            String s = S.substring(i, i+n);
            list.add(s);
        }
        Collections.sort(list);
        System.out.println(list.get(0));
        System.out.println(list.get((list.size())-1));
    }
}
