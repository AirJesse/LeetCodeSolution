package leetCode_75.q238_除自身以外数组的乘积;


import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] after = new int[nums.length];
        pre[0] = 1;
        after[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i-1];
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            after[j] = after[j + 1] * nums[j+1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length ; i++) {
            result[i] = pre[i] * after[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
