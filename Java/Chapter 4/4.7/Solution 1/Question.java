/* Question 4.7 Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
Avoid storing additional nodes in a data structure.
NOTE: This is not necessarily a binary search tree.
 */

/*
Answer:My first thought to solve this is to build a hash table for the two nodes and look up the hash table for the common ancestor.But extra space for strong the ahs table
is required.

This is the first answer from the book:
From the root node of the tree, we check whether p,q are all in left or right tree from the node. This algorithm runs in O(n)time on a balanced tree.This is because covers is called on 2n nodes in the first call (n nodes for the left side, and n nodes for the right side). After that, the algorithm branches left or right, at which point covers will be called on 2n/2 nodes, then 2n/4, and soon. This results in a runtime of 0(n).
*/

import MyLibrary.TreeNode;


public class Question {
    public static boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }

    public static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        boolean is_p_on_left = covers(root.left, p);
        boolean is_q_on_left = covers(root.left, q);
        if (is_p_on_left != is_q_on_left) { // Nodes are on different side
            return root;
        }
        TreeNode child_side = is_p_on_left ? root.left : root.right;
        return commonAncestorHelper(child_side, p, q);
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) { // Error check - one node is not in tree
            return null;
        }
        return commonAncestorHelper(root, p, q);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        TreeNode n3 = root.find(1);
        TreeNode n7 = root.find(7);
        TreeNode ancestor = commonAncestor(root, n3, n7);
        System.out.println(ancestor.data);
    }
}

