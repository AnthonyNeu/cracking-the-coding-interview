/*Question 11.6 Given an M X N matrix in which each row and each column is sorted in ascending order, write a method to find an element.*/


/*
Answer 1:As a first approach, we first compare the target with the element in the end of column to decide the row of the target.
Then we find the target in the row which end of element bigger than target.The running time of this algorithm is O(m+n).
We can do binary search in each row and the running time become O(m+lgn).
 */

import MyLibrary.AssortedMethod;

public class Question {
    public static boolean findElement(int[][] matrix, int elem) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == elem) {
                return true;
            } else if (matrix[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int M = 10;
        int N = 5;
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 10 * i + j;
            }
        }

        AssortedMethod.printMatrix(matrix);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int v = 10 * i + j;
                System.out.println(v + ": " + findElement(matrix, v));
            }
        }

    }
}
