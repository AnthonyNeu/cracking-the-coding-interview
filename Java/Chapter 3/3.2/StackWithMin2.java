import java.util.Stack;

public class StackWithMin2 extends Stack<Integer>{
    Stack<Integer> s;

    public StackWithMin2()
    {
        s = new Stack<Integer>();
    }

    public void push(int value) {
        if(value<=min())
            s.push(value);
        super.push(value);
    }

    public Integer pop()
    {
        int value = super.pop();
        if(value == min())
            s.pop();
        return value;
    }

    public int min() {
        if (s.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s.peek();
        }
    }
}
