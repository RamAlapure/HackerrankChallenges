import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    //Write your code here
    static Scanner scan = new Scanner(System.in);
    // initialize Breadth and height
    static int B = scan.nextInt();
    static int H = scan.nextInt();
    public static boolean flag = false;

    static{
        // initialization code goes here
        if(B<=0 || H<=0)System.out.println("java.lang.Exception: Breadth and height must be positive");
        else flag=true;
    }
    
  public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

