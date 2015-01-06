/* Question 3.2 How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
Push, pop and min should all operate in O(1) time.
 */

import MyLibrary.AssortedMethod;

public class Question {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        StackWithMin2 stack2 = new StackWithMin2();
        for (int i = 0; i < 15; i++) {
            int value = AssortedMethod.randomIntInRange(0, 100);
            stack.push(value);
            stack2.push(value);
            System.out.print(value + ", ");
        }
        System.out.println('\n');
        for (int i = 0; i < 15; i++) {
            System.out.println("Popped " + stack.pop().value + ", " + stack2.pop());
            System.out.println("New min is " + stack.min() + ", " + stack2.min());
        }
    }

}
