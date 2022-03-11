package com.hackerrank.Strings;

import java.util.*;
import java.util.regex.*;

public class TagContentExtractor {
   public static void main(String[] args){
      
      Scanner in = new Scanner(System.in);
      int testCases = Integer.parseInt(in.nextLine());
      while(testCases>0){
         String line = in.nextLine();
         
         //Write your code here
         String pattern = "<(.+?)>([^<>]+)</\\1>"; //"\\<(.+)\\>([^\\<\\>]+)\\<\\/\\1\\>"; 
         //or String pattern = "<([^>]+)>([^<>]+)</\\1>";

           int count = 0;

            Pattern p = Pattern.compile(pattern);
            Matcher m =  p.matcher(line);

            while(m.find())
            {
                System.out.println(m.group(2));
                count++;
            }
            if(count == 0){
                System.out.println("None");
            }
          
         testCases--;
      }
   }
}
