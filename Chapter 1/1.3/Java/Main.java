/*Question 1.3 Given two strings, write a method to decide if one is a permutation of the other.*/

import java.lang.String;
import java.lang.System;

public class Main {
    public static boolean permutation(String s,String t)
    {
        if(s.length() != t.length())
            return false;

        int[] letters = new int[256];
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        for(char temp: s_char)
            letters[temp]++;

        for(char temp: t_char)
            if (--letters[temp] < 0)
                return false;
        return true;
    }


    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
