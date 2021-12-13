package 剑指.q30_包含min函数的栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    /** initialize your data structure here. */
    private Deque<Integer> stack1 = new ArrayDeque<>();
    private Deque<Integer> stack2= new ArrayDeque<>();
    public MinStack() {

    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty() || stack2.peek() >= x){
            stack2.push(x);;
        }
    }

    public void pop() {
        Integer pop = stack1.pop();
        if(pop.equals(stack2.peek())){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
