/* Question 5.6 Write a program to swap odd and even bits in an integer with as few instructions as possible
(e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and soon).
 */

/*
Answer: We can mask all odd bits by 10101010 which is 0xAA and shift them right by 1 to put them in even spots. And do the same thing for the even bits.
 */
import MyLibrary.AssortedMethod;

public class Question {
        public static int swapOddEvenBits(int x) {
            return ( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1) );
        }

        public static void main(String[] args) {
            int a = 103217;
            System.out.println(a + ": " + AssortedMethod.toFullBinaryString(a));
            int b = swapOddEvenBits(a);
            System.out.println(b + ": " + AssortedMethod.toFullBinaryString(b));
        }
}


