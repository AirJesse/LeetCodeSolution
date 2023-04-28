package leetCode_75.q2215_找出两数组的不同;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> tmp = new HashSet<>(set1);
        set1.removeAll(set2);
        set2.removeAll(tmp);
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>(set1));
        result.add(new ArrayList<>(set2));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
    }
}
