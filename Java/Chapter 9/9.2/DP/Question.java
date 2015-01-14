/* Question 9.2 Imagine a robot sitting on the upper left corner of an X by Y grid.
The robot can only move in two directions: right and down. How many possible paths are there for the robot to go from (0, 0) to (X, Y) ?
FOLLOW UP
Imagine certain spots are "off limits," such that the robot cannot step on them.
Design an algorithm to find a path for the robot from the top left to the bottom right.
*/


import java.util.ArrayList;
import java.awt.*;
import MyLibrary.AssortedMethod;

public class Question {
    public static int[][] maze = new int[10][10];

    public static boolean isFree(int x, int y) {
        if (maze[x][y] == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean getPath(int x, int y, ArrayList<Point> path) {
        // If out of bounds or not available, return.
        if (y < 0 || x < 0 || !isFree(x, y)) {
            return false;
        }

        boolean isAtOrigin = (x == 0) && (y == 0);

        // If there's a path from the start to my current location, add my location.
        if (isAtOrigin || getPath(x, y - 1, path) || getPath(x - 1, y, path)) {
            Point p = new Point(x, y);
            path.add(p);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int size = 5;
        maze = AssortedMethod.randomMatrix(size, size, 0, 5);

        AssortedMethod.printMatrix(maze);

        ArrayList<Point> path = new ArrayList<Point>();
        boolean success = getPath(size - 1, size - 1, path);
        if (success) {
            String s = AssortedMethod.listOfPointsToString(path);
            System.out.println(s);
        } else {
            System.out.println("No path found.");
        }
    }

}