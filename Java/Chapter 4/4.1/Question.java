/* Question 4.1 Implement a function to check if a binary tree is balanced.
For the purposes of this question,
a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */

import MyLibrary.TreeNode;
import MyLibrary.AssortedMethod;

public class Question {
    public static int getHeight(TreeNode root) {
        if(root == null)
            return 0;
        else
            return root.height();
    }

    //this method is wrong as it cannot detect linklist-like tree
    public static boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        }
        else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }



    public static int MaxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        else
            return 1+Math.max(MaxDepth(root.left),MaxDepth(root.right));
    }

    public static int MinDepth(TreeNode root)
    {
        if(root ==null)
            return Integer.MAX_VALUE;
        else if(root.left == null && root.right ==null)
            return 1;
        else
            return 1+Math.min(MinDepth(root.left), MinDepth(root.right));
    }

    public static boolean isBalanced1(TreeNode root) {
        return MaxDepth(root) - MinDepth(root) <=1;
    }

    public static void main(String[] args) {
        // Create balanced tree
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Root? " + root.data);
        System.out.println("Is balanced? " + isBalanced1(root));

        // Could be balanced, actually, but it's very unlikely...
        TreeNode unbalanced = new TreeNode(10);
        for (int i = 0; i < 10; i++) {
            unbalanced.insertInOrder(AssortedMethod.randomIntInRange(0, 100));
        }
        System.out.println("Root? " + unbalanced.data);
        System.out.println("Is balanced? " + isBalanced1(unbalanced));

        TreeNode LinkList = new TreeNode(3);
        LinkList.insertInOrder(1);
        LinkList.insertInOrder(2);
        LinkList.insertInOrder(3);
        System.out.println("Root? " + LinkList.data);
        System.out.println("Is balanced? " + isBalanced1(LinkList));
        System.out.println("Is balanced? " + isBalanced(LinkList));
    }
}

