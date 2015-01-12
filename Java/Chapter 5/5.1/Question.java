/* Question 5.1 You are given two 32-bit numbers, N and M, and two bit positions, i and j.
Write a method to insert M into N such that M starts at bit j and ends at bit i.
You can assume that the bits j through i have enough space to fit all of M.
That is, if M = 10011, you can assume that there are at least 5 bits between j and i.
You would not,for example, have j = 3 and i = 2,because M could not fully fit between bit 3 and bit 2.
EXAMPLE
Input: N=10000000000,M=10011,i=2,j=6
Output:N = 10001001100
 */

public class Question {
    public static int updateBits(int m,int n,int i,int j)
    {
        //digit start from 0 to 31
        if(i>=32 | j<i)
            return 0;

        int all_ones = ~0;
        int left = all_ones<<(j+1);
        int right = (1<<i)-1;
        int mask = left | right;

        //clear the bits between i and j
        int n_cleared = n&mask;
        int m_shifted = m<<i;

        return n_cleared | m_shifted;
    }

    public static void main(String [] args){
        int result = updateBits(-128,-3,2,6);
        System.out.println(result);
    }
}

