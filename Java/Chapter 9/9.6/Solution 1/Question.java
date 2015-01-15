/* Question 9.6 Implement an algorithm to print all valid (i.e., properly opened and closed) combinations of n-pairs of parentheses.*/

/*
(()) -> (()()) / inserted pair after 1st left paren /
     -> ((())) / inserted pair after 2nd left paren /
     -> ()(()) / inserted pair at beginning of string /
 */

import java.util.*;

public class Question {
    public static String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1, str.length());
        return left + "()" + right;
    }

    public static HashSet<String> generateParens(int remaining) {
        HashSet<String> set = new HashSet<String>();
        if(remaining == 0)
            set.add("");
        else
        {
            HashSet<String> previous = generateParens(remaining-1);
            for(String c : previous)
            {
                for(int i=0;i<c.length();i++)
                {
                    if(c.charAt(i) =='(')
                    {
                        String temp = insertInside(c,i);
                        set.add(temp);
                    }
                }
                set.add("()"+c);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        Set<String> list = generateParens(4);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }
}