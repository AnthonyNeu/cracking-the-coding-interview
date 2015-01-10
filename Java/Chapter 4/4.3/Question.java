/* Question 4.3 Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.
 */

/*
Answer: Whenever we want to add a node to the tree, we need to confirm that the nodes in the right children and the left children is the same.
We can use recursion to solve the problem. Every time we get a array, we put the first half in the left and the another in the right.
 */

import MyLibrary.TreeNode;

public class Question {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.data);
        System.out.println("Created BST? " + root.isBST());
        System.out.println("Height: " + root.height());
    }
}

