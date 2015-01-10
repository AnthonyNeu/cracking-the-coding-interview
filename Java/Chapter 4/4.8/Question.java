/* Question 4.8 You have two very large binary trees: Tl, with millions of nodes, and T2, with
hundreds of nodes. Create an algorithm to decide if T2 is a subtree ofTl.
A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2. T
hat is, if you cut off the tree at node n, the two trees would be identical.
 */

/*
Answer: We can first find the node with the same data as the T2 and start to check the subtree from that node with T2.
*/

import MyLibrary.TreeNode;
import MyLibrary.AssortedMethod;


public class Question {
    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return true; // The empty tree is a subtree of every tree.
        else
            return subTree(t1, t2);
    }

    /* Checks if the binary tree rooted at r1 contains the binary tree
     * rooted at r2 as a subtree somewhere within it.
     */
    public static boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null)
            return false; // big tree empty & subtree still not found.
        if (r1.data == r2.data) {
            if (matchTree(r1,r2)) return true;
        }
        return (subTree(r1.left, r2) || subTree(r1.right, r2));
    }

    /* Checks if the binary tree rooted at r1 contains the
     * binary tree rooted at r2 as a subtree starting at r1.
     */
    public static boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r2 == null && r1 == null)
            return true; // nothing left in the subtree
        if (r1 == null || r2 == null)
            return false; //  big tree empty & subtree still not found
        if (r1.data != r2.data)
            return false;  // data doesn’t match
        return (matchTree(r1.left, r2.left) &&
                matchTree(r1.right, r2.right));
    }

    public static void main(String[] args) {
        // t2 is a subtree of t1
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] array2 = {2, 4, 5, 8, 9, 10, 11};

        TreeNode t1 = AssortedMethod.createTreeFromArray(array1);
        TreeNode t2 = AssortedMethod.createTreeFromArray(array2);

        if (containsTree(t1, t2))
            System.out.println("t2 is a subtree of t1");
        else
            System.out.println("t2 is not a subtree of t1");

        // t4 is not a subtree of t3
        int[] array3 = {1, 2, 3};
        TreeNode t3 = AssortedMethod.createTreeFromArray(array1);
        TreeNode t4 = AssortedMethod.createTreeFromArray(array3);

        if (containsTree(t3, t4))
            System.out.println("t4 is a subtree of t3");
        else
            System.out.println("t4 is not a subtree of t3");
    }
}

