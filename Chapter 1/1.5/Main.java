/*Question 1.5 Implement a method to perform basic string compression using the counts of repeated characters.
For example, the string aabcccccaaa would become a2blc5a3.
If the "compressed" string would not become smaller than the original string, your method should return the original string.*/

import java.lang.*;

public class Main {
    public static int countCompression(String str)
    {
        if(str.length() == 0) return 0;
        int count = 1;
        int compressionLength = 0;
        char[] str_char = str.toCharArray();
        char previous = str_char[0];
        for(int i = 1 ; i< str.length();i++) {
            if (str_char[i] == previous)
                count++;
            else {
                compressionLength += 2;
                count = 1;
            }
            previous = str_char[i];
        }
        return compressionLength + 2;
    }

    public static String compressString(String str)
    {
        int compressionLength = countCompression(str);

        if(compressionLength >= str.length())
            return str;

        String compressionString = "";
        int index = 0;
        char[] str_char = str.toCharArray();
        char previous = str_char[0];
        int count = 1;
        for(int i = 1 ; i< str.length();i++)
        {
            if(str_char[i] == previous)
                count++;
            else {
                compressionString = compressionString + str_char[i-1] + Integer.toString(count);
                index = index + 2;
                count = 1;
            }
            previous = str_char[i];
        }
        return compressionString + str_char[str.length()-1] + Integer.toString(count);
    }

    public static void main(String[] args) {
        String str = "abbccccccdee";
        int length = countCompression(str);
        String str2 = compressString(str);
        System.out.println("Compression: " + str);
        System.out.println("Old String (len = " + str.length() + "): " + str);
        System.out.println("New String (len = " + str2.length() + "): " + str2);
        System.out.println("Potential Compression: " + length);
    }
}
