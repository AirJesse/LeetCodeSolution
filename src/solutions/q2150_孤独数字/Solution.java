package solutions.q2150_孤独数字;

import java.util.*;

public class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) > 1 || (map.containsKey(num - 1) || map.containsKey(num + 1))) {
                continue;
            }
            result.add(num);

        }
        return result;
    }
}
