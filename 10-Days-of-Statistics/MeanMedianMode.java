import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double sum = 0;
        int[] Arr = new int[N];
        double mean = 0;
        double median = 0;
        int mode = 0;
        int maxValue = 0;
        int maxValues = 0;
        for (int i = 0; i < N; i++) {
            Arr[i] = sc.nextInt();
        }
        Arrays.sort(Arr);
        for (int i = 0; i < N; i++) {
            int value = Arr[i];
            sum += value;
            int valuesCounter = 0;
            for (int j = 0; j < N; j++) {
                if (value == Arr[j]) {
                    valuesCounter++;
                }
            }
            if (maxValues < valuesCounter) {
                maxValues = valuesCounter;
                maxValue = value;
            }
        }
        mean = (double) (sum / N);
        System.out.println(mean);
        if (N % 2 == 0) {
            double first = Arr[(N / 2 - 1)];
            double second = Arr[(N / 2)];
            median = (first + second) / 2;
        } else if (N % 2 == 1) {
            median = Arr[N / 2 + 1];
        }
        System.out.println(median);
        mode = maxValue;
        System.out.println(mode);
       
        
    }
}

//or
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        double t = 0;
        
        int maxValue = 0;
        int maxValues = 0;
        
        for(int i=0; i<n; i++){
            a[i] = scan.nextInt();
            t += a[i];
        }
        Arrays.sort(a);
        double mean =  t/n;
        
        double median;
        
        if(n%2 == 1) median = (float)(a[(n/2)]);
        else median = (float)(a[(n/2)-1] + a[n/2])/2;
        
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
