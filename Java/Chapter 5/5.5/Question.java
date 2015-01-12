/* Question 5.5 Write a function to determine the number of bits required to convert integer A to integer B.
 */

import MyLibrary.AssortedMethod;

public class Question {
    //Each 1 in XOR represent a different between A and B
    public static int bitSwapRequired(int a, int b)
    {
        int count = 0;
        for(int c = a^b;c!=0;c>>=1)
            count+=c&1;
        return count;
    }

    
    public static int bitSwapRequired2(int a, int b)
    {
        int count = 0;
        for(int c = a^b;c!=0;c = c & (c-1))
            count++;
        return count;
    }


    public static void main(String [] args){
        int a = 23432;
        int b = 512132;
        System.out.println(a + ": " + AssortedMethod.toFullBinaryString(a));
        System.out.println(b + ": " + AssortedMethod.toFullBinaryString(b));
        int nbits = bitSwapRequired(a, b);
        int nbits2 = bitSwapRequired2(a, b);
        System.out.println("Required number of bits: " + nbits + " " + nbits2);
}
}


