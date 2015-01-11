/* Question 4.9 You are given a binary tree in which each node contains a value.
Design an algorithm to print all paths which sum to a given value.
The path does not need to start or end at the root or a leaf.
 */

/*
Answer: My answer to this problem is to transform this problem to a array problem by the pos-order traversal. But the running time of the algorithm is O(n^2).

This is the answer from the book:
On every node, we look "up" to see if we've found the sum.
That is, rather than asking "Does this node start a path with the sum?," we ask,"Does this node complete a path with the sum?"
When we recurse through each node n, we pass the function the full path from root ton.
This function then adds the nodes along the path in reverse order from n to root. When the sum of each subpath equals sum, then we print this path.
*/

import MyLibrary.TreeNode;

public class Question {
    //we recursively find the path from the first n level of the tree,every time we traverse all the node of the level,we go the next level
    public static void findSum(TreeNode node, int sum, int[] path, int level) {
        if (node == null) {
            return;
        }

		/* Insert current node into path */
        path[level] = node.data;

        int t = 0;
        for (int i = level; i >= 0; i--){
            t += path[i];
            if (t == sum) {
                print(path, i, level);
            }
        }

        //whether we find the sum or not, we don't stop the traverse as negative node exists
        findSum(node.left, sum, path, level + 1);
        findSum(node.right, sum, path, level + 1);

		/* Remove current node from path. Not strictly necessary, since we would
		 * ignore this value, but it's good practice.
		 */
        path[level] = Integer.MIN_VALUE;
    }

    public static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
    }

    public static void findSum(TreeNode node, int sum) {
        int depth = depth(node);
        int[] path = new int[depth];
        findSum(node, sum, path, 0);
    }

    private static void print(int[] path, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

    public static void main(String [] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(6);
        findSum(root, 8);
    }
}

