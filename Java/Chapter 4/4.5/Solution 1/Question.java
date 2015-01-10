/* Question 4.5 Implement a function to check if a binary tree is a binary search tree.
 */

/*
Answer: We check the left children and the right children recursively.
 */

import MyLibrary.TreeNode;


public class Question {
    public static boolean checkBST(TreeNode root,Integer last)
    {
        if(root == null)
            return true;

        //check left
        if(!checkBST(root.left,last))
            return false;

        //check current right child is bigger than parent
        if(last != null && root.data <= last)
            return false;
        last = root.data;

        //check right
        if(!checkBST(root.right,last))
            return false;
        return true;
    }

    public static void main(String[] args){
        int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        TreeNode node = TreeNode.createMinimalBST(array);
        Integer last = null;
        //node.left.data = 5;
        //node.right.data = 10;
        System.out.println(checkBST(node,last));
    }
}

