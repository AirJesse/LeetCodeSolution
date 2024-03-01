package leetCode_75.q1207_独一无二的出现次数;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (Integer val : map.values()) {
            if (set.contains(val)) {
                return false;
            }
            set.add(val);
        }
        return true;
    }
}
