/* Question 9.9 Write an algorithm to prim all ways of arranging eight queens on an 8x8 chess board
so that none of them share the same row, column or diagonal.
In this case, "diagonal" means all diagonals, not just the two that bisect the board.*/

/*
Answer: there is no easy way to solve this but we can reduce the amount of work we spend on searching.
 */

import java.util.ArrayList;

public class Question {
    public static int GRID_SIZE = 8;

    /* Check if (row1, column1) is a valid spot for a queen by checking if there
     * is a queen in the same column or diagonal. We don't need to check it for queens
     * in the same row because the calling placeQueen only attempts to place one queen at
     * a time. We know this row is empty.
     */
    public static boolean checkValid(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];

            //check whether we have a queue in the same column
            if(column2 == column1)
                return false;

            //check diagonals:if the distance between the columns
            //equals the distance between the rows, then they're in the * same diagonal.
            if(row1 - row2 == Math.abs(column1-column2))
                return false;
        }
        return true;
    }

    public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row == GRID_SIZE) { // Found valid placement
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col;	// Place queen
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    public static void clear(Integer[] columns) {
        for (int i = 0; i < GRID_SIZE; i++) {
            columns[i] = -1;
        }
    }

    public static void printBoard(Integer[] columns) {
        drawLine();
        for(int i = 0; i < GRID_SIZE; i++){
            System.out.print("|");
            for (int j = 0; j < GRID_SIZE; j++){
                if (columns[i] == j) {
                    System.out.print("Q|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.print("\n");
            drawLine();
        }
        System.out.println("");
    }

    private static void drawLine() {
        StringBuilder line = new StringBuilder();
        for (int i=0;i<GRID_SIZE*2+1;i++)
            line.append('-');
        System.out.println(line.toString());
    }



    public static void printBoards(ArrayList<Integer[]> boards) {
        for (int i = 0; i < boards.size(); i++) {
            Integer[] board = boards.get(i);
            printBoard(board);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        Integer[] columns = new Integer[GRID_SIZE];
        clear(columns);
        placeQueens(0, columns, results);
        printBoards(results);
        System.out.println(results.size());
    }
}