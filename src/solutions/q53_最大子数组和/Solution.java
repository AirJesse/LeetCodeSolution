package solutions.q53_最大子数组和;

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? (nums[i] + dp[i - 1]) : nums[i];
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
