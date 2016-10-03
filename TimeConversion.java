import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Solution {

    public static void main(String[] args) throws ParseException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String time_12hr = scan.next();
        SimpleDateFormat formate_12hr = new SimpleDateFormat("hh:mm:ssaa");
        Date time = formate_12hr.parse(time_12hr);       
        SimpleDateFormat formate_24hr = new SimpleDateFormat("HH:mm:ss");
        System.out.println(formate_24hr.format(time));
    }
}
