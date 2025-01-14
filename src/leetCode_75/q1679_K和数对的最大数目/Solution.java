package leetCode_75.q1679_K和数对的最大数目;

import java.util.Arrays;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (nums[i] + nums[j] == k) {
                result++;
                i++;
                j--;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
