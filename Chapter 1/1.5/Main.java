/*Question 1.4 Write a method to replace all spaces in a string with'%20'.
You may assume that the string has sufficient space at the end of the string to hold the additional characters,
and that you are given the "true" length of the string.*/

import java.lang.*;

public class Main {
    public static void replaceSpaces(char[] s,int length)
    {
        int spaceNumber = 0;
        for(int i =0; i<length;i++) {
            char temp = s[i];
            if (temp == ' ')
                spaceNumber++;
        }
        int index = length + spaceNumber * 2;
        s[index] = '\0';
        for(int i = length -1 ; i>=0;i--)
        {
            if(s[i] == ' ')
            {
                s[index - 1] = '0';
                s[index - 2] = '2';
                s[index - 3] = '%';
                index = index - 3;
            }
            else
            {
                s[index-1] = s[i];
                index --;
            }
        }
    }

    public static String charToString(char[] s)
    {
        String result = "";
        for(char temp : s) {
            result = result + Character.toString(temp);
        }
        return result;
    }


    public static void main(String[] args) {
        String str = "abc d e f";
        char[] arr = new char[str.length() + 3 * 2 + 1];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        replaceSpaces(arr, str.length());
        System.out.println("\"" +charToString(arr) +"\"");
    }
}
