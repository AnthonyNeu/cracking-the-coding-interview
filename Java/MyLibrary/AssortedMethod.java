package MyLibrary;
import java.util.*;
import java.awt.*;

public class AssortedMethod {
    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static LinkedListNode randomLinkedList(int N, int min, int max) {
        LinkedListNode root = new LinkedListNode(randomIntInRange(min, max),
                null, null);
        LinkedListNode prev = root;
        for (int i = 1; i < N; i++) {
            int data = randomIntInRange(min, max);
            LinkedListNode next = new LinkedListNode(data, null, null);
            prev.setNext(next);
            prev = next;
        }
        return root;
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int v : array) {
            sb.append(v + ", ");
        }
        return sb.toString();
    }

    public static String toFullBinaryString(int a) {
        String s = "";
        for (int i = 0; i < 32; i++) {
            Integer lsb = new Integer(a & 1);
            s = lsb.toString() + s;
            a = a >> 1;
        }
        return s;
    }

    /* Creates tree by mapping the array left to right, top to bottom. */
    public static TreeNode createTreeFromArray(int[] array) {
        if (array.length > 0) {
            TreeNode root = new TreeNode(array[0]);
            java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
            queue.add(root);
            boolean done = false;
            int i = 1;
            while (!done) {
                TreeNode r = (TreeNode) queue.element();
                if (r.left == null) {
                    r.left = new TreeNode(array[i]);
                    i++;
                    queue.add(r.left);
                } else if (r.right == null) {
                    r.right = new TreeNode(array[i]);
                    i++;
                    queue.add(r.right);
                } else {
                    queue.remove();
                }
                if (i == array.length)
                    done = true;
            }
            return root;
        } else {
            return null;
        }
    }

    public static TreeNode randomBST(int N, int min, int max) {
        int d = randomIntInRange(min, max);
        TreeNode root = new TreeNode(d);
        for (int i = 1; i < N; i++) {
            root.insertInOrder(randomIntInRange(min, max));
        }
        return root;
    }
}
