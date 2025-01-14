package solutions.q2270_分割数组的方案数;

public class Solution {
    public int waysToSplitArray(int[] nums) {
        int result = 0;
        long left = nums[0];
        long right = 0;
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        if (left >= right) {
            result++;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            left += nums[i];
            right -= nums[i];
            if (left >= right) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToSplitArray(new int[]{
                2, 3, 1, 0
        }));
    }
}
