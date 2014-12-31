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
}
