package leetCode_75.q1004_最大连续1的个数3;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int result = 0;
        Queue<Integer> zeroPosition = new LinkedList<>();
        int left = 0, right = 0;
        for (; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroPosition.add(right);
                if (zeroPosition.size() > k) {
                    result = Math.max(result, right - left);
                    left = zeroPosition.poll() + 1;
                }
            }
        }
        return Math.max(result, right - left);
    }
}
