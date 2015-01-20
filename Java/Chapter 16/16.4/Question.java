/*Question 16.4 Design a class which provides a lock only if there are no possible deadlocks,
*/

/*
Answer: we treat each process's request as a sequence of resource's number；
        A = {1, 2, 3, 4};
        B = {1, 5, 4, 1};
        C = {1, 4, 5};
We can think about this as a graph, where 2 is connected to 3, 3 is connected to 5, and 5 is connected to 2.
A deadlock is represented by a cycle. An edge (w, v) exists in the graph if a process declares that it will request lock v immediately after lock w.
For the earlier example, the following edges would exist in the graph: (1, 2), (2, 3), (3, 4), (I, 3), (3, S), (7, 5), (5, 9), (9, 2).
So we force every process to declare their order of requiring resource and detect cycle in the graph.

The algorithm for detecting graph is DFS.
 */
public class Question {

    public static void main(String[] args) {
        int[] res1 = {1, 2, 3, 4};
        int[] res2 = {1, 5, 4, 1};
        int[] res3 = {1, 4, 5};

        LockFactory.initialize(10);

        LockFactory lf = LockFactory.getInstance();
        System.out.println(lf.declare(1, res1));
        System.out.println(lf.declare(2, res2));
        System.out.println(lf.declare(3, res3));

        System.out.println(lf.getLock(1, 1));
        System.out.println(lf.getLock(1, 2));
        System.out.println(lf.getLock(2, 4));
    }
}
