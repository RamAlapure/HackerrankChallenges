package com.hackerrank.Algorithm.Implementation;

public class DayOfProgrammer {

    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(1918));
    }

    public static String dayOfProgrammer(int year) {

        // if leap year sum(8 months) = 244
        // if not leap year sum(8 months) = 243
        // day of the programmer = 256
        int day = year == 1918 ? 26 : year < 1918 && year % 4 == 0 || year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ? 12 : 13;

        return day + ".09." + year;
    }
}
