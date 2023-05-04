package leetCode_75.q2390_从字符串中移除星号;


import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String removeStars(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if(c == '*'){
                deque.pollFirst();
            }else{
                deque.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(deque.size());
        while (!deque.isEmpty()){
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }
}
