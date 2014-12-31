/*Question 2.3 Implement an algorithm to find the kth to last element of a singly linked list.*/

import MyLibrary.LinkedListNode;
import MyLibrary.AssortedMethod;

public class Question {
    public static int position = 6;
    public static void findPostition(LinkedListNode n)
    {
        if(n==null) return;
        findPostition(n.next);
        if(position == 1) System.out.println("Result is " + n.data);
        position --;
    }

    public static void findPosition1(LinkedListNode n,int number)
    {
        if(n == null || number <=0)
            return;
        LinkedListNode first = n;
        LinkedListNode second = first.clone();
        for(int i =0 ;i<number;i++)
            second = second.next;

        if(second == null)
            return;

        while(second != null)
        {
            second = second.next;
            first = first.next;
        }
        System.out.println("Result is " + first.data);
    }

    public static void main(String[] args) {
        LinkedListNode test = AssortedMethod.randomLinkedList(10,0,10);
        System.out.println(test.printForward());
        findPostition(test);
        findPosition1(test,6);
    }
}
