/* Question 4.6 Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node in a binary search tree.
You may assume that each node has a link to its parent.
 */

/*
Answer: There are two situation need to be considered.
*/

import MyLibrary.TreeNode;


public class Question {
    public static TreeNode inorderSuccessor(TreeNode n) {
        if(n == null)
            return null;
        else if(n.right != null)
            //for this situation:
            /*
                  8
                 /  \
                /    \
               3      10
              / \
             /   \
            1    6
            We want to find the in-order successor of 3.
             */
            return leftMostChild(n.right);
        else
        {
            //for this situation:
            /*
                  8
                 /  \
                /    \
               3      10
              / \
             /   \
            1    6
            We want to find the in-order successor of 6.
             */
            TreeNode parent = n.parent;
//            while(parent != null && parent.right == n)
//            {
//                n = parent;
//                parent = parent.parent;
//            }
            while(parent !=null && parent.data < n.data)
                parent = parent.parent;
            return parent;
        }
    }

    public static TreeNode leftMostChild(TreeNode n) {
        if(n == null)
            return null;
        else
        {
            while(n.left != null)
                n = n.left;
            return n;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        root.print();
        for (int i = 0; i < array.length; i++) {
            TreeNode node = root.find(array[i]);
            TreeNode next = inorderSuccessor(node);
            if (next != null) {
                System.out.println(node.data + "->" + next.data);
            } else {
                System.out.println(node.data + "->" + null);
            }
        }
    }
}

