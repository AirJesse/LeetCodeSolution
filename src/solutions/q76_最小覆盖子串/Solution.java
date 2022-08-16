package solutions.q76_最小覆盖子串;

import java.util.*;


/**
 * 循环次数太多，不正确
 */
public class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        String result = "";
        Map<Character, Integer> targetMap = stringToMap(t);
        while (right <= s.length()) {
            if (left > right || right - left < t.length()) {
                right++;
                continue;
            }
            String sub = s.substring(left, right);
            if (hasTargets(stringToMap(sub), targetMap)) {
                if (result.equals("") || result.length() > sub.length()) {
                    result = sub;
                }
                left++;
            }else{
                right++;
            }
        }


        return result;
    }

    private boolean hasTargets(Map<Character, Integer> map, Map<Character, Integer> targetMap) {
        for (Character character : targetMap.keySet()) {
            if (map.getOrDefault(character, 0) < targetMap.get(character)) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> stringToMap(String substring) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : substring.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        return targetMap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

}
