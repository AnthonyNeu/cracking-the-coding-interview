/* Question 10.4 You have an array with all the numbers from 7 to N, where N is at most 32,000.
 The array may have duplicate entries and you do not know what N is. With only 4 kilobytes of memory available,
 how would you print all duplicate elements in the array?*/

/*
We use the memory to build a hash table as 4KB memory can hold 4*8*1024 = 32768 int numbers.
 */

import MyLibrary.AssortedMethod;

public class Question {
    public static void checkDuplicates(int[] array)
    {
        BitSet bs = new BitSet(32000);
        for(int i =0;i<array.length;i++)
        {
            if(bs.get(array[i]-1))
                System.out.print(" "+ array[i]);
            else
                bs.set(array[i]-1);
        }
    }

    public static void main(String[] args){
        int[] array = AssortedMethod.randomArray(30, 1, 30);
        System.out.println(AssortedMethod.arrayToString(array));
        checkDuplicates(array);
    }
}