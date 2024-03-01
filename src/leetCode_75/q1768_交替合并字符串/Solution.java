package leetCode_75.q1768_交替合并字符串;

public class Solution {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len = Math.min(word1.length(), word2.length());
        for (int i = 0; i < len; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(word1.length()>len){
            sb.append(word1.substring(len));
        }
        if(word2.length()>len){
            sb.append(word2.substring(len));
        }
        return sb.toString();

    }
}
