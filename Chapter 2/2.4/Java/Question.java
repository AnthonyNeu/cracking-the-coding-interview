/*Question 2.4 Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.*/

import MyLibrary.LinkedListNode;

public class Question {
    public static LinkedListNode partition(LinkedListNode n, int value) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while (n != null) {
            LinkedListNode node = new LinkedListNode(n.data,null,null);
            if (n.data < value) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = node;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            }
            if (n.data >= value) {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = node;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            n = n.next;
        }

        if (beforeStart == null)
            return afterStart;

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public static void main(String[] args) {
		/* Create linked list */
        int[] vals = {1, 3, 7, 5, 2, 9, 4};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        System.out.println(head.printForward());

		/* Partition */
        LinkedListNode h = partition(head, 0);

		/* Print Result */
        System.out.println(h.printForward());
    }
}
