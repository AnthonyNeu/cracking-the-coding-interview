/* Question 9.7 Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent),
write code to calculate the number of ways of representing n cents.*/


public class Question {
    //we store the denoms from large to small one
    //recursion way
    public static int makeChange(int amount, int[] denoms, int index) {
        if(index >= denoms.length-1)
            return 1;
        int denomAmount =denoms[index];
        int ways = 0;
        for(int i =0;i*denomAmount<=amount;i++)
        {
            ways += makeChange(amount - i * denomAmount,denoms,index+1);
        }
        return ways;
    }

    public static int makeChange1(int n) {
        int[] denoms = {25, 10, 5, 1};
        return makeChange(n, denoms, 0);
    }

    public static int makeChange2(int n) {
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[n + 1][denoms.length];
        return makeChange2(n, denoms, 0, map);
    }

    //dynamic programming way
    public static int makeChange2(int amount, int[] denoms, int index, int[][] map) {
        if (map[amount][index] > 0) { // retrieve value
            return map[amount][index];
        }
        if (index >= denoms.length - 1) return 1; // one denom remaining -> one way to do it
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            // go to next denom, assuming i coins of denomAmount
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange2(amountRemaining, denoms, index + 1, map);
        }
        map[amount][index] = ways;
        return ways;
    }

    public static int makeChange(int n) {
        int x = makeChange1(n);
        int y = makeChange2(n);
        if (x != y) {
            System.out.println("Error: " + x + " " + y);
        }
        return x;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println("makeChange(" + i + ") = " + makeChange(i));
        }
    }
}