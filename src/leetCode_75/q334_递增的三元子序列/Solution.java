package leetCode_75.q334_递增的三元子序列;


public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = nums[0];
        int sec = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > sec) {
                return true;
            }
            if (nums[i] <= sec && nums[i] > first) {
                sec = nums[i];
            } else {
                first = nums[i];
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().increasingTriplet(new int[]{1, 5, 0, 4, 1, 3}));
    }
}


