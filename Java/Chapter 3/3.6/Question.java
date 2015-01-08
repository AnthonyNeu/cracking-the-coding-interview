/* Question 3.6 Write a program to sort a stack in ascending order (with biggest items on top).
You may use at most one additional stack to hold items, but you may not copy the elements into any other data structure (such as an array).
The stack supports the following operations: push, pop, peek, and isEmpty.
 */

import java.util.Stack;
import MyLibrary.AssortedMethod;


public class Question {
    static int c = 0;
    public static Stack<Integer> mergesort(Stack<Integer> inStack) {
        if (inStack.size() <= 1) {
            return inStack;
        }

        Stack<Integer> left = new Stack<Integer>();
        Stack<Integer> right = new Stack<Integer>();
        int count = 0;
        while (inStack.size() != 0) {
            count++;
            c++;
            if (count % 2 == 0) {
                left.push(inStack.pop());
            } else {
                right.push(inStack.pop());
            }
        }

        left = mergesort(left);
        right = mergesort(right);

        while (left.size() > 0 || right.size() > 0) {
            if (left.size() == 0) {
                inStack.push(right.pop());
            } else if (right.size() == 0) {
                inStack.push(left.pop());
            } else if (right.peek().compareTo(left.peek()) <= 0) {
                inStack.push(left.pop());
            } else {
                inStack.push(right.pop());
            }
        }

        Stack<Integer> reverseStack = new Stack<Integer>();
        while (inStack.size() > 0) {
            c++;
            reverseStack.push(inStack.pop());
        }

        return reverseStack;
    }

    //use a stack to mimic insertion sorting.
    //Let the element a in the top of original stack compare with that stack's top element b
    //If a<b, then push b to the original stack
    //If that stack is empty, we simply push the element into that stack
    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!r.isEmpty() && r.peek() > temp)
                s.push(r.pop());
            r.push(temp);
        }
        return r;
    }


    public static void main(String[] args) {
        for (int k = 1; k < 100; k++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int i = 0; i < 10 * k; i++) {
                int r = AssortedMethod.randomIntInRange(0, 1000);
                s.push(r);
            }
            s = sort(s);
            int last = Integer.MAX_VALUE;
            while (!s.isEmpty()) {
                int curr = s.pop();
                if (curr > last) {
                    System.out.println("Error: " + last + " " + curr);
                }
                last = curr;
            }
        }
    }
}

