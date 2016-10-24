import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        Locale uslocale = new Locale.Builder().setLanguage("en").setRegion("US").build(); 
        Locale inlocale = new Locale.Builder().setLanguage("en").setRegion("IN").build(); 
        Locale chlocale = new Locale.Builder().setLanguage("zh").setRegion("CN").build(); 
        Locale frlocale = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
        String us = NumberFormat.getCurrencyInstance(uslocale).format(payment);
        String india = NumberFormat.getCurrencyInstance(inlocale).format(payment);;
        String china = NumberFormat.getCurrencyInstance(chlocale).format(payment);;
        String france = NumberFormat.getCurrencyInstance(frlocale).format(payment);;
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
