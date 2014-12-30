/*Question 1.1.Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?*/

import java.lang.String;
import java.lang.System;


public class Main {

    public static boolean isUniqueString(String str)
    {
        /* we assume the string only contains the char from ASCII 0-127 */
        if(str.length() > 128) return false;

        boolean[] check = new boolean[128];
        for(int i =0; i<str.length();i++)
        {
            int temp = str.charAt(i);
            if(check[temp]) return false;
            check[temp] = true;
        }
        return true;
    }

    public static boolean isUniqueString2(String str)
    {
        if(str.length() > 128) return false;

        int check = 0;
        for(int i =0; i<str.length();i++)
        {
            int temp = str.charAt(i)  - 'a';
            if((check & (1<<temp)) >0) return false;
            check = check | (1<<temp);
        }
        return true;
    }


    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueString(word) + " " + isUniqueString2(word));
        }
    }
}
