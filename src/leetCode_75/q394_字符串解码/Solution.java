package leetCode_75.q394_字符串解码;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) && c != '[' && deque.isEmpty()) {
                sb.append(c);
                continue;
            }
            if (c == ']') {
                Deque<Character> deque2 = new LinkedList<>();
                while (!Character.isDigit(deque.getFirst())) {
                    Character pop = deque.pop();
                    if (pop != '[') {
                        deque2.push(pop);
                    }
                }
                int wei = 0;
                int num = 0;
                while (!deque.isEmpty() && Character.isDigit(deque.getFirst())) {
                    num += Character.digit(deque.pop(), 10) * Math.pow(10,wei++);
                }
                List<Character> list = new ArrayList<>();
                while (!deque2.isEmpty()) {
                    list.add(deque2.pop());
                }

                if (deque.isEmpty()) {
                    StringBuilder tmp = new StringBuilder();
                    list.forEach(tmp::append);
                    for (int i = 0; i < num; i++) {
                        sb.append(tmp);
                    }
                } else {
                    for (int i = 0; i < num; i++) {
                        list.forEach(deque::push);
                    }
                }
                continue;
            }
            deque.push(c);

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("100[leetcode]"));
    }
}
