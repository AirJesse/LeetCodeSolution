package solutions.q567_字符串的排列;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> subMap = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            subMap.put(c, subMap.getOrDefault(c, 0) + 1);
        }
        int len = 0;
        int left = 0, right = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (!subMap.containsKey(c)) {
                left = right;
                countMap.clear();
                len = 0;
                continue;
            }
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            if (countMap.get(c) <= (subMap.get(c))) {
                len++;
            }
            if (len == s1.length()) {
                return true;
            }
            while (countMap.get(c) > subMap.get(c)) {
                char d = s2.charAt(left);
                left++;
                countMap.put(d, countMap.get(d) - 1);
                if (d != c) {
                    len--;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("abcdxabcde", "abcdeabcdx"));
    }
}
