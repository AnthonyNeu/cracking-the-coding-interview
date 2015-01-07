/* Question 3.4 In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower.
The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
You have the following constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto the next tower.
(3) A disk can only be placed on top of a larger disk.
Write a program to move the disksfrom the first tower to the last using stacks.
 */

public class Question {
    public static void main(String[] args) {
        // Set up code.
        int n = 5;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        // Copy and paste output into a .XML file and open it with internet explorer.
        //towers[0].print();
        towers[0].moveDisks(n, towers[2], towers[1]);
        //towers[2].print();
    }
}
