package solutions.q5993_将找到的值乘以2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findFinalValue(int[] nums, int original) {
                Set<Integer> set = new HashSet<>();
                for (int num : nums) {
                    set.add(num);
                }
                while (set.contains(original)) {
                    original *= 2;
                }
                return original;
    }
}
