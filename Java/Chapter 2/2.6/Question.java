/*Question 2.6 Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
EXAMPLE
Input:A ->B->C->D->E-> C[the same Case earlier]
Output:C
*/

import MyLibrary.LinkedListNode;

public class Question {
    public static LinkedListNode FindBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        //If there is a loop in the link list, fast pointer will catch up with the slow pointer in some place
        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // Error check - there is no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        /*假设相遇处离环开始点相距x个点，环长度为n个点
        慢指针:k+qn+x=m (1)
        又有2m-m=m=pn (2)
        有(1),(2)可得:k+qn+x=pn
        所以k+x = (p-q)n，即相遇处离head的距离为环长的整数倍.
        所以将其中一个指针移至head，同时两指针以相同速度再次相遇即为环的开始处.
        */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both now point to the start of the loop.
        return fast;
    }

    public static void main(String[] args) {
        int list_length = 100;
        int k = 10;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }

        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];


        LinkedListNode loop = FindBeginning(nodes[0]);
        if (loop == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println(loop.data);
        }
    }
}
