/*Question 1.6 Given an image represented by an NxN matrix,
where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?*/

import java.lang.*;


//Each pixel is 4 bytes, so we can assume that int can be used to store it
public class Main {
    public static int randomInt(int n)
    {
        return (int)(Math.random() * n);
    }

    public static int randomIntInRange(int min,int max)
    {
        return randomInt(max + 1 - min) + min;
    }

    public static int[][] randomMatrix(int row,int column,int min,int max)
    {
        int[][] Matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return Matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    System.out.print(" ");
                }
                if (matrix[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }


    //we rotate the matrix by rotate each layer of the matrix
    //exchange the top,bottom,left,right of each layer
    public static void rotate(int[][] matrix,int N)
    {
        for(int i = 0 ; i<N/2;i++)
        {
            int start = i;
            int end = N-1-i;
            for(int j=start;j<end;j++)
            {
                int top = matrix[start][j];

                //left->top
                matrix[start][j] = matrix[end - (j - start)][start];

                //bottom->left
                matrix[end - (j - start)][start] = matrix[end][end - (j - start)];

                //right->bottom
                matrix[end][end - (j - start)] = matrix[j][end];

                //top->right
                matrix[j][end] = top;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = randomMatrix(10, 10, 0, 9);
        printMatrix(matrix);
        rotate(matrix, 10);
        System.out.println();
        printMatrix(matrix);
    }
}
