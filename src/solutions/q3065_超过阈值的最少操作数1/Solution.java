package solutions.q3065_超过阈值的最少操作数1;

public class Solution {
    public int minOperations(int[] nums, int k) {
        int result = 0;
        for (int num : nums) {
            if(num < k){
                result++;
            }
        }
        return result;
    }
}
