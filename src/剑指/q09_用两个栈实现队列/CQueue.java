package 剑指.q09_用两个栈实现队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class CQueue {
    private Deque<Integer> deque = new ArrayDeque<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        deque.offer(value);
    }

    public int deleteHead() {
        Integer result = deque.pollFirst();
        return result == null ? -1 : result;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
