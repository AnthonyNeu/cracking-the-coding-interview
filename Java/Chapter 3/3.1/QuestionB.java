import MyLibrary.AssortedMethod;

import java.util.EmptyStackException;
import java.util.Stack;

public class QuestionB {
    static int number_of_stacks = 3;
    static int default_size = 4;
    static int total_size = default_size * number_of_stacks;
    static StackData [] stacks = {new StackData(0, default_size),
            new StackData(default_size, default_size),
            new StackData(default_size * 2, default_size)};
    static int [] buffer = new int [total_size];

    public static void main(String [] args) throws Exception  {
        push(0, 10);
        push(1, 20);
        push(2, 30);

        push(1, 21);
        push(0, 11);
        push(0, 12);

        pop(0);

        push(2, 31);

        push(0, 13);
        push(1, 22);

        push(2, 31);
        push(2, 32);
        push(2, 33);
        push(2, 34);

        System.out.println("Final Stack: " + AssortedMethod.arrayToString(buffer));

        pop(1);
        push(2, 35);

        System.out.println("Final Stack: " + AssortedMethod.arrayToString(buffer));
    }

    public static int numberOfElements() {
        return stacks[0].size + stacks[1].size + stacks[2].size;
    }

    public static int nextElement(int index) {
        if (index + 1 == total_size) {
            return 0;
        } else {
            return index + 1;
        }
    }

    public static int previousElement(int index) {
        if (index == 0) {
            return total_size - 1;
        } else {
            return index - 1;
        }
    }

    public static void shift(int stackNum) {
        StackData tempStack = stacks[stackNum];
        if(tempStack.size >= tempStack.capacity)
        {
            int next = (stackNum + 1) % number_of_stacks;
            shift(next);
            tempStack.capacity++;
        }
        for(int i = (tempStack.start+tempStack.size-1)%total_size;tempStack.isWithinStack(i,total_size);i--)
            buffer[i] = buffer[previousElement(i)];
        buffer[tempStack.start] = 0;
        tempStack.start = nextElement(tempStack.start);
        tempStack.pointer = nextElement(tempStack.pointer);
        tempStack.capacity--;
    }

    /* Expand stack by shifting over other stacks */
    public static void expand(int stackNum) {
        shift((stackNum + 1) % number_of_stacks);
        stacks[stackNum].capacity++;
    }

    static void push(int stackNum, int value) throws Exception {
        if(stacks[stackNum].size + 1 > stacks[stackNum].capacity )
        {
            if(numberOfElements() >= total_size)
            {
                throw  new FullStackException();
            }
            else
                expand(stackNum);
        }
        else
        {
            stacks[stackNum].size++;
            stacks[stackNum].pointer = nextElement(stacks[stackNum].pointer);
            buffer[stacks[stackNum].pointer] = value;
        }
    }

    static int pop(int stackNum) throws Exception {
        if(stacks[stackNum].size == 0)
            throw new EmptyStackException();
        else
        {
            int value = buffer[stacks[stackNum].pointer];
            buffer[stacks[stackNum].pointer] = 0;
            stacks[stackNum].size--;
            stacks[stackNum].pointer = previousElement(stacks[stackNum].pointer);
            return value;
        }
    }

    static int peek(int stackNum) {
        StackData stack = stacks[stackNum];
        return buffer[stack.pointer];
    }

    static boolean isEmpty(int stackNum) {
        StackData stack = stacks[stackNum];
        return stack.size == 0;
    }
}