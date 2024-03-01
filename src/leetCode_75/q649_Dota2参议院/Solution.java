package leetCode_75.q649_Dota2参议院;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public String predictPartyVictory(String senate) {
        int point = 0;
        Queue<Character> a = new LinkedList<>();
        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                if (point >= 0) {
                    a.offer(c);
                }
                point++;
            } else {
                if (point <= 0) {
                    a.offer(c);
                }
                point--;
            }
        }
        for (int i = 0; i < a.size(); i++) {
            Character peek = a.peek();
            if (peek == 'R') {
                if (point < 0) {
                    a.poll();
                }
                point++;
            } else {
                if (point > 0) {
                    a.poll();
                }
                point--;
            }
        }
        return a.peek() == 'R' ? "Radiant" : "Dire";
    }
}
