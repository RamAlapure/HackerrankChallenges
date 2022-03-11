package com.hackerrank.DataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackBalancedBrackets {

    /*
    * }][}}(}][))]
[](){()}
()
({}([][]))[]()
{)[](}]}]}))}(())(
([[)
*
* NO
YES
YES
YES
NO
NO
    *
    * */
    public static void main(String[] args) {
        String balanced = isBalanced("[]][{]{(({{)[})(}[[))}{}){[{]}{})()[{}]{{]]]){{}){({(}](({[{[{)]{)}}}({[)}}([{{]]({{");
        System.out.println(balanced);
    }

    public static String isBalanced(String s) {
        if(s.length() % 2 == 1) return "NO";
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> chars = new Stack<>();
        if (s.length() > 1) {
            if (map.get(s.charAt(0)) != null) chars.add(s.charAt(0));
            else return "NO";
        }
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != null) chars.push(c);
            else {
                if(chars.isEmpty()) return "NO";
                if (c == map.get(chars.peek())) chars.pop();
                else return "NO";
            }
        }
        if (chars.isEmpty()) return "YES";
        else return "NO";
    }
}
