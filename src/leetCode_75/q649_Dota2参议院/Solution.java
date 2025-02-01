package leetCode_75.q649_Dota2参议院;

import java.util.*;

public class Solution {
    /*
    2023年解答的错误解法
     */
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

    public String predictPartyVictory2(String senate) {
        List<String> list = new ArrayList<>(senate.length());
        int rNum = 0;
        int dNum = 0;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rNum++;
                list.add("Radiant");
            } else {
                dNum++;
                list.add("Dire");
            }
        }
        //正记R,负记D
        int balance = 0;
        while (rNum > 0 && dNum > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (Objects.equals(list.get(i), "Radiant")) {
                    if (balance < 0) {
                        rNum--;
                        list.set(i, null);
                    }
                    balance++;
                } else if (Objects.equals(list.get(i), "Dire")) {
                    if (balance > 0) {
                        dNum--;
                        list.set(i, null);
                    }
                    balance--;
                }
            }
        }
        return dNum == 0 ? "Radiant" : "Dire";


    }

    public static void main(String[] args) {
        System.out.println(new Solution().predictPartyVictory2("DRRDRDRDRDDRDRDR"));
    }
}
