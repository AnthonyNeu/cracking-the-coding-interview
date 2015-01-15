/* Question 9.5 Write a method to compute all permutations of a string.*/

/*
Answer:We can recursively compute the permutations for substring of the original string and add the extra char to every position of the result.
 */

import java.util.*;

public class Question {
    public static ArrayList<String> getPerms(String str) {
        if(str == null)
            return null;
        ArrayList<String> premutations = new ArrayList<String>();

        if(str.length()==0)
        {
            premutations.add("");
            return premutations;
        }

        char addChar = str.charAt(0);
        String remain = str.substring(1);
        ArrayList<String> tempanswer = getPerms(remain);
        for(String c:tempanswer)
        {
            for(int j = 0 ;j<=c.length();j++)
            {
                String temp = insertCharAt(c,addChar,j);
                premutations.add(temp);
            }
        }
        return premutations;
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abcde");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }
}