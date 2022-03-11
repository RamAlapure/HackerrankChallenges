package com.hackerrank.basics;

import java.util.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;
    	// Add your code here

    Difference(int[] elements){
        this.elements = elements;
    }
    
    public void computeDifference(){
        Arrays.sort(elements);
        int s = elements.length;
        maximumDifference = Math.abs(elements[s-1] - elements[0]);
    }

} // End of Difference class

public class Scope {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
