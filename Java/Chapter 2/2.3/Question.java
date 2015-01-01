/*Question 2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
EXAMPLE
Input: the node c from the linked list a->b->c->d->e
Result: nothing is returned, but the new linked list looks like a- >b- >d->e*/

import MyLibrary.LinkedListNode;
import MyLibrary.AssortedMethod;

public class Question {
    public static boolean remove(LinkedListNode n)
    {
        if(n == null || n.next == null)
            return false;

        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }

    public static void main(String[] args) {
        LinkedListNode test = AssortedMethod.randomLinkedList(3,0,10);
        System.out.println(test.printForward());
        if(remove(test.next.next))
            System.out.println(test.printForward());
        else
            System.out.println("either input is the last node or input is the first node from the end.");
    }
}
