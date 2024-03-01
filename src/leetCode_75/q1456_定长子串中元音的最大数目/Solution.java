package leetCode_75.q1456_定长子串中元音的最大数目;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int left = 0;
        int right = k - 1;
        int num = 0;
        for (int i = 0; i <= right; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                num++;
            }
        }
        int max = num;
        while (++right < s.length()) {
            if (set.contains(s.charAt(left))) {
                num--;
            }
            if (set.contains(s.charAt(right))) {
                num++;
            }
            left++;
            max = Math.max(max, num);
        }
        return max;
    }
}
