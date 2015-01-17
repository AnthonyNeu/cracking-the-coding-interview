/*Question 11.2 Write a method to sort an array of strings so that all the anagrams are next to each other.*/

/*
Answer 1: we simply sort the string into ascending order and compare whether two string are the same.
 */

import MyLibrary.AssortedMethod;
import java.util.*;

public class Question {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        System.out.println(AssortedMethod.stringArrayToString(array));
        Arrays.sort(array, new AnagramComparator());
        System.out.println(AssortedMethod.stringArrayToString(array));
    }
}
