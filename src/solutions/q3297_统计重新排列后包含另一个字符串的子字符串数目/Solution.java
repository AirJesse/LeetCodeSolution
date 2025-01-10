package solutions.q3297_统计重新排列后包含另一个字符串的子字符串数目;

import java.util.*;

public class Solution {
    /*
    性能较差
     */
    public long validSubstringCount(String word1, String word2) {
        long result = 0;
        Map<Character, Integer> wordMap = new HashMap<>();
        wordMap.put(word1.charAt(0), 1);
        if (word1.length() == 1 && !word1.equals(word2)) {
            return 0;

        }
        Map<Character, Integer> word2Map = stringToMap(word2);
        for (int l = 0, r = 0; ; ) {
            if (r - l >= word2.length() - 1 && mapContains(wordMap, word2Map)) {
                result += word1.length() - r;
                wordMap.put(word1.charAt(l), wordMap.get(word1.charAt(l)) - 1);
                l++;
            } else {
                if (++r == word1.length()) {
                    break;
                }
                wordMap.put(word1.charAt(r), wordMap.getOrDefault(word1.charAt(r), 0) + 1);
            }
        }
        return result;
    }

    public long validSubstringCount2(String word1, String word2) {
        long result = 0;
        int cnt = word2.length();
        Map<Character, Integer> word2Map = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            word2Map.put(word2.charAt(i), word2Map.getOrDefault(word2.charAt(i), 0) + 1);
        }
        if (word1.length() == 1) {
            return word1.equals(word2) ? 1 : 0;
        }
        int l = 0, r = 0;
        if (word2Map.containsKey(word1.charAt(0))) {
            word2Map.put(word1.charAt(0), word2Map.get(word1.charAt(0)) - 1);
            cnt--;

        }
        while (r < word1.length()) {
            if (cnt == 0) {
                result += word1.length() - r;
                if (word2Map.containsKey(word1.charAt(l))) {
                    word2Map.put(word1.charAt(l), word2Map.get(word1.charAt(l)) + 1);
                    if (word2Map.get(word1.charAt(l)) > 0) {
                        cnt++;

                    }
                }
                l++;
                continue;
            } else {
                if (++r == word1.length()) {
                    break;
                }

            }
            if (r < l) {
                r = l + 1;
                continue;
            }

            if (word2Map.containsKey(word1.charAt(r))) {
                word2Map.put(word1.charAt(r), word2Map.get(word1.charAt(r)) - 1);
                if (word2Map.get(word1.charAt(r)) >= 0) {
                    cnt--;
                }
            }
        }
        return result;
    }

    Map<Character, Integer> stringToMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }

    boolean mapContains(Map<Character, Integer> mapSource, Map<Character, Integer> mapTarget) {
        for (Map.Entry<Character, Integer> entry : mapTarget.entrySet()) {
            if (mapSource.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validSubstringCount2("dcbdcdccb", "cdd"));
    }
}
