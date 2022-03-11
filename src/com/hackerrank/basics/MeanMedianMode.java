package com.hackerrank.basics;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class MeanMedianMode {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        double t = 0;

        int maxValue = 0;
        int maxValues = 0;

        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            t += a[i];
        }
        Arrays.sort(a);
        double mean = t / n;

        double median;

        if (n % 2 == 1) median = (float) (a[(n / 2)]);
        else median = (float) (a[(n / 2) - 1] + a[n / 2]) / 2;

        for (int i = 0; i < n; i++) {
            int value = a[i];
            int valuesCounter = 0;
            for (int j = 0; j < n; j++) {
                if (value == a[j]) {
                    valuesCounter++;
                }
            }
            if (maxValues < valuesCounter) {
                maxValues = valuesCounter;
                maxValue = value;
            }
        }

        DecimalFormat df = new DecimalFormat("#.#");

        System.out.println(df.format(mean));
        System.out.println(median);
        System.out.println(maxValue);

    }
}
