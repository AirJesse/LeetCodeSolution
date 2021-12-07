package solutions.q1816_截断句子;

public class Solution {

    public String truncateSentence(String s, int k) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k && i < split.length; i++) {
            sb.append(split[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
