/*Question 2.1 Write code to remove duplicates from an unsorted linked list.
 FOLLOW UP
 How would you solve this problem if a temporary buffer is not allowed? */

import java.util.HashSet;
import MyLibrary.LinkedListNode;

public class Question {
    public static void deleteDupsA(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }


    public static void deleteDupsB(LinkedListNode head) {
        if (head == null) return;

        LinkedListNode current = head;
        while (current != null) {
			/* Remove all future nodes that have the same value */
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        LinkedListNode clone = head.clone();
        deleteDupsA(head);
        System.out.println(head.printForward());
        deleteDupsB(clone);
        System.out.println(clone.printForward());
    }
}
