package solutions.q17_电话号码的字母组合;

import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backTrace(digits, phoneMap, 0, new StringBuilder(digits.length()), result);
        return result;
    }

    private void backTrace(String digits, Map<Character, String> phoneMap, int i, StringBuilder sb, List<String> result) {

        if (i >= digits.length()) {
            result.add(sb.toString());
            return;
        }
        String phoneS = phoneMap.get(digits.charAt(i));
        for (char c : phoneS.toCharArray()) {
            sb.append(c);
            backTrace(digits, phoneMap, i + 1, sb, result);
            sb.deleteCharAt(i);
        }

    }


}
