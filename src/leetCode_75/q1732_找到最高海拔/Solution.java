package leetCode_75.q1732_找到最高海拔;

public class Solution {
    public int largestAltitude(int[] gain) {
        int ga = 0;
        int max = 0;
        for (int i : gain) {
            ga += i;
            max = Math.max(ga, max);
        }
        return max;
    }
}
