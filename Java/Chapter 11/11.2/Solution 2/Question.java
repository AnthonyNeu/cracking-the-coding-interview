/*Question 11.2 Write a method to sort an array of strings so that all the anagrams are next to each other.*/

/*
Answer 2: we use hash table to group the string with the same characters.
 */

import MyLibrary.AssortedMethod;
import java.util.*;

public class Question {
    public static String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static void sort(String[] array) {
        Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();

        //Group the string
        for(String s: array)
        {
            if(hash.get(sortChars(s)) == null)
                hash.put(sortChars(s),new LinkedList<String>());
            LinkedList<String> temp = hash.get(sortChars(s));
            temp.push(s);
        }

        //Convert hash table to String
        int index = 0;
        for(String s : hash.keySet())
        {
            LinkedList<String> temp = hash.get(s);
            for(String c: temp)
            {
                array[index] = c;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        sort(array);
        System.out.println(AssortedMethod.stringArrayToString(array));
    }
}
