/*Question 3.1 Describe how you could use a single array to implement three stacks.
*/

import java.util.EmptyStackException;


//this is the method 1 for the stack, in this method, we simply create a array to store the elements of the stack
//and each stack start from a certain place of the array
public class Question {
    static int stackSize = 10;
    static int [] buffer = new int [stackSize * 3];

    // 3 stack pointers to keep track of the index of the top element
    static int [] stackPointer = {-1, -1, -1};
    public static void main(String [] args) throws Exception  {
        push(2, 4);
        System.out.println("Peek 2: " + peek(2));
        push(0, 3);
        push(0, 7);
        push(0, 5);
        System.out.println("Peek 0: " + peek(0));
        pop(0);
        System.out.println("Peek 0: " + peek(0));
        pop(0);
        System.out.println("Peek 0: " + peek(0));
    }

    static void push(int stackNum, int value) throws Exception {
		/* Check that we have space for the next element */
        if(stackPointer[stackNum] + 1 > stackSize)
            throw new FullStackException();
        else
        {
            stackPointer[stackNum]++;
            buffer[absTopOfStack(stackNum)] = value;
        }
    }

    static int pop(int stackNum) throws Exception {
        if(isEmpty(stackNum))
            throw new EmptyStackException();
        else
        {
            int value = buffer[absTopOfStack(stackNum)];
            buffer[absTopOfStack(stackNum)] = 0;
            stackPointer[stackNum]--;
            return value;
        }
    }

    static int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return buffer[absTopOfStack(stackNum)];
    }

    static boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    /* returns index of the top of the stack "stackNum", in absolute terms */
    static int absTopOfStack(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }
}
