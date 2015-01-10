/* Question 4.7 Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
Avoid storing additional nodes in a data structure.
NOTE: This is not necessarily a binary search tree.
 */

/*
Answer:My first thought to solve this is to build a hash table for the two nodes and look up the hash table for the common ancestor.But extra space for strong the ahs table
is required.

This is the second answer from the book:
We may recognize that we should only need to search the entire tree once to find p and q.
We should then be able to "bubble up" the findings to earlier nodes in the stack.
The basic logic is the same as the earlier solution. This solution can distinguish whether p or q is in the tree or not.
*/

import MyLibrary.TreeNode;


public class Question {
    public static class Result {
        public TreeNode node;
        public boolean isAncestor;
        public Result(TreeNode n, boolean isAnc) {
            node = n;
            isAncestor = isAnc;
        }
    }

    public static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root == p && root == q) {
            return new Result(root, true);
        }

        Result rx = commonAncestorHelper(root.left, p, q);
        if (rx.isAncestor) { // Found common ancestor
            return rx;
        }

        Result ry = commonAncestorHelper(root.right, p, q);
        if (ry.isAncestor) { // Found common ancestor
            return ry;
        }

        if (rx.node != null && ry.node != null) {
            return new Result(root, true); // This is the common ancestor
        } else if (root == p || root == q) {
			/* If we’re currently at p or q, and we also found one of those
			 * nodes in a subtree, then this is truly an ancestor and the
			 * flag should be true. */
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        } else {
            //if either rx or ry is non-null, return the non-null value
            //But this situation does not return the common ancestor for the problem, it only tells us that this substree only contains p or q
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncestorHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
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

