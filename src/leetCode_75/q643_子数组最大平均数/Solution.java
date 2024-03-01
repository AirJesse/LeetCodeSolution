package leetCode_75.q643_子数组最大平均数;

import java.awt.font.NumericShaper;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max;
        int sum = 0;
        int left = 0;
        int right = k - 1;
        for (int i = 0; i <= right; i++) {
            sum += nums[i];
        }
        max = sum;
        while (++right < nums.length) {
            sum -= nums[left];
            sum += nums[right];
            if (sum > max) max = sum;
            left++;
        }
        return max/(double)k;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3},4));
    }
}
