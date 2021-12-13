package solutions.q748_最短补全词;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Solution {

    public String shortestCompletingWord(String licensePlate, String[] words) {

        List<String> cList = new ArrayList<>();
        String result = null;

        for (char c : licensePlate.toCharArray()) {
            if (c >= 'A' && c <= 'z') {
                cList.add(String.valueOf(Character.toLowerCase(c)));
            }
        }
        for (String word : words) {
            String[] split = word.split("");
            List<String> strings = new ArrayList<>(Arrays.asList(split));
            if (containsAllRepeat(strings, cList)) {
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }
        return result;
    }

    public String shortestCompletingWord2(String licensePlate, String[] words) {
        Map<Character, Integer> charNumMap = new HashMap<>();
        String result = null;
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                char c1 = Character.toLowerCase(c);
                charNumMap.put(c1, charNumMap.getOrDefault(c1, 0) + 1);
            }
        }
        for (String word : words) {
            Map<Character, Integer> wordNumMap = new HashMap<>();
            for (char c : word.toCharArray()) {
                wordNumMap.put(c, wordNumMap.getOrDefault(c, 0) + 1);
            }
            boolean flag = true;
            for (Character character : charNumMap.keySet()) {
                if (wordNumMap.get(character) == null || wordNumMap.get(character) - (charNumMap.get(character)) < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (result == null || result.length() > word.length()) {
                    result = word;
                }
            }
        }
        return result;
    }

    private boolean containsAllRepeat(List<String> A, List<String> B) {
        for (String s : B) {
            int index = A.indexOf(s);
            if (index == -1) {
                return false;
            }
            A.remove(index);
        }
        return true;
    }


    public static void main(String[] args) {
        String s = new Solution().shortestCompletingWord2("GrC8950", new String[]{"measure", "other", "every", "base", "according", "level", "meeting", "none", "marriage", "rest"});
        System.out.println(s);
    }
}
