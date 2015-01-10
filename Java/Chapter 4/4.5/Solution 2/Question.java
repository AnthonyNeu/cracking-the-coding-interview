/* Question 4.5 Implement a function to check if a binary tree is a binary search tree.
 */

/*
Answer: We check the left children and the right children recursively.
*/

import MyLibrary.TreeNode;


public class Question {
    public static boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }
        if (!checkBST(n.left, min, n.data) ||
                !checkBST(n.right, n.data, max)) {
            return false;
        }
        return true;
    }

    public static boolean checkBST(TreeNode n) {
        return checkBST(n, null, null);
    }

    public static void main(String[] args) {
		/* Simple test -- create one */
        int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        //node.left.data = 6; // "ruin" the BST property by changing one of the elements
        node.print();
        boolean isBst = checkBST(node);
        System.out.println(isBst);
    }
}

