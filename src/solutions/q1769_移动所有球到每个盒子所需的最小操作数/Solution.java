package solutions.q1769_移动所有球到每个盒子所需的最小操作数;

public class Solution {
    //双循环暴力
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            for (int j = 0; j < boxes.length(); j++) {
                if (boxes.charAt(j) == '1') {
                    answer[i] += Math.abs(i - j);
                }
            }
        }
        return answer;
    }
}
