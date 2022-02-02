package solutions.q1736_最长的美好子字符串;

import java.util.Arrays;

public class Solution {
    public String longestNiceSubstring(String s) {
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = s.length(); j > i; j--) {
                String substring = s.substring(i, j);
                if (isNice(substring) && substring.length() > result.length()) {
                    result = substring;
                }
            }
        }
        return result;
    }

    private boolean isNice(String substring) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (char c : substring.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower[c - 'a'] = 1;
            } else {
                upper[c - 'A'] = 1;
            }
        }
        return Arrays.equals(lower, upper);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String yazaAay = s.longestNiceSubstring("YazaAay");
        System.out.println(yazaAay);
    }
}
