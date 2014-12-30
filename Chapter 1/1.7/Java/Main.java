/*Question 1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.*/

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

    public static void setRowToZero(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void setColumnToZero(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void setZero(int[][] matrix)
    {
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        for(int i=0;i<matrix.length;i++) {
            if (matrix[i][0] == 0)
            {
                firstRowHasZero = true;
                break;
            }
        }

        for(int i=0;i<matrix[0].length;i++) {
            if (matrix[0][i] == 0)
            {
                firstColumnHasZero = true;
                break;
            }
        }

        //check whether other elements in the matrix has zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1;i<matrix.length;i++) {
            if (matrix[i][0] == 0)
                setRowToZero(matrix,i);
        }

        for(int i=1;i<matrix[0].length;i++) {
            if (matrix[0][i] == 0)
                setColumnToZero(matrix,i);
        }

        if(firstRowHasZero)
            setRowToZero(matrix,0);

        if(firstColumnHasZero)
            setColumnToZero(matrix,0);
    }



    public static void main(String[] args) {
        int[][] matrix = randomMatrix(10, 15, 0, 9);
        printMatrix(matrix);
        setZero(matrix);
        System.out.println();
        printMatrix(matrix);
    }
}
