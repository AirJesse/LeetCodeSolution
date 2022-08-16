package solutions.q76_最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        String result = null;
        Map<Character, Integer> targetMap = stringToMap(t);
        Map<Character, Integer> window = new HashMap<>();
        //符合条件计数器，可以避免每次比对window和targetMap
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (targetMap.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(targetMap.get(c))) {
                    valid++;
                }
            }
            while (valid == targetMap.size()) {
                if (result == null || right - left < result.length()) {
                    result = s.substring(left, right);
                }
                char d = s.charAt(left);
                left++;
                if (targetMap.containsKey(d)) {
                    window.put(d, window.get(d) - 1);
                    if (window.get(d)<(targetMap.get(d))) {
                        valid--;
                    }
                }
            }
        }
        return result;
    }

    private Map<Character, Integer> stringToMap(String substring) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : substring.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        return targetMap;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}
