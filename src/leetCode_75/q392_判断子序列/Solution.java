package leetCode_75.q392_判断子序列;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    //暴力解-easy
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        int j = 0;
        for (int i = 0; i < t.toCharArray().length && j < sChars.length; i++) {
            char c = sChars[j];
            if (c == t.charAt(i)) {
                j++;
            }
        }
        return j == sChars.length;
    }

    public boolean isSubsequence2(String s, String t) {
        HashMap<Character, LinkedList<Integer>> map = new HashMap<>();

        for (int i = 0; i < t.toCharArray().length; i++) {
            char c = t.charAt(i);
            LinkedList<Integer> queue = map.getOrDefault(c, new LinkedList<>());
            queue.add(i);
            map.put(c, queue);
        }
        int point = -1;
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            LinkedList<Integer> queue = map.get(c);
            if (queue == null) {
                return false;
            }
            boolean changed = false;
            for (Integer idx : queue) {
                if (point < idx) {
                    point = idx;
                    changed = true;
                    break;
                }
            }
            if (!changed) return false;
        }
        return true;
    }
}
