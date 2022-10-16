package com.hackerrank.ip.day1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {

    public static void main(String[] args) {
        timeConversion("07:05:45PM");
    }

    public static String timeConversion(String s) {
        LocalTime time = LocalTime.parse(s, DateTimeFormatter.ofPattern("hh:mm:ssa"));
        return time.format(DateTimeFormatter.ISO_TIME);
    }
}
