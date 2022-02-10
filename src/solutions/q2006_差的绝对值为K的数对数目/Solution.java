package solutions.q2006_差的绝对值为K的数对数目;

import java.util.Arrays;

public class Solution {
    public int countKDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if(nums[i] - nums[j] < k){
                    break;
                }else if(nums[i] - nums[j] == k){
                    result++;
                }
            }
        }
        return result;
    }
}
