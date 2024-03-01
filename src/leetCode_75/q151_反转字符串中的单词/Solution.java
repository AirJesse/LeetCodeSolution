package leetCode_75.q151_反转字符串中的单词;

public class Solution {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!s1[i].equals("")) {
                sb.append(s1[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();

    }
}
