package solutions.q2239_找到最接近0的数字;

public class Solution {
    public int findClosestNumber(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(result)) {
                result = num;
            } else if (Math.abs(num) == Math.abs(result)) {
                result = Math.max(result, num);
            }
        }
        return result;
    }
}
