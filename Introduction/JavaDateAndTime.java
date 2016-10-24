import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.time.*;
import java.time.LocalDate;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int day = in.nextInt();
        int year = in.nextInt();
        in.close();
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println(date.getDayOfWeek());
    }
}
