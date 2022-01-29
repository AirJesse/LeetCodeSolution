package solutions.q2148_元素计数;

import java.util.Arrays;

public class Solution {
    public int countElements(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];
        int result = 0;
        for (int num : nums) {
            if(num>min && num<max){
                result++;
            }
        }
        return result;

    }
}
