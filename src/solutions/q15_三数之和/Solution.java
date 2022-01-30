package solutions.q15_三数之和;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int sum = nums[i];
            if (sum > 0) {
                return result;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                if (nums[left] + nums[right] + sum == 0) {
                    String s = sum + String.valueOf(nums[left]) + nums[right];
                    if (!set.contains(s)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(sum);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        set.add(s);
                    }
                    left++;
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] + sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
