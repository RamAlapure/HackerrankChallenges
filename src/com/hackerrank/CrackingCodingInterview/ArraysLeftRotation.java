package com.hackerrank.CrackingCodingInterview;/*
Consider n = 5 d = 4(rotations)
*LEFT ROTATION: * 
Now come to Inputs :
5 4
1 2 3 4 5
Output: 5 1 2 3 4
*Explanation: * Instead of rotating the array ,I find out the index which come after 4th rotation and insert the value directly,So the efficiency was increased.
Cycle 0: i=0 , n=5 , d=4: a[(0+5-4)%5]==> a[1]=1 first value is stored
Cycle 1: i=1 , n=5 , d=4: a[(1+5-4)%5]==> a[2]=2 second value is stored
Cycle 2: i=2 , n=5 , d=4: a[(2+5-4)%5]==> a[3]=3 third value is stored
Cycle 3: i=3 , n=5 , d=4: a[(3+5-4)%5]==> a[4]=4 fourth value is stored
Cycle 4: i=4 , n=5 , d=4: a[(4+5-4)%5]==> a[0]=5 fifth value is stored
Array values: [5,1,2,3,4] //4th rotation
Same wise as RIGHT ROTATION just change logic a[(i+n-d)%n]=in.nextInt();//left ===> a[(i+n+d)%n]=in.nextInt();//right
*/

import java.util.*;

public class ArraysLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];

        for(int i=0;i<n;i++){
            a[(i+n-k)%n]=in.nextInt();  //rotate left 
        }
        
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
}
