package solutions.q2167_移除所有载有违禁货物车厢所需的最少时间;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int minimumTime(String s) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        List<Integer> denyIndex = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int digit = Character.digit(s.charAt(i), 10);
            indexMap.put(i, digit);
            if (digit == 1) {
                denyIndex.add(i);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < denyIndex.size(); i++) {
            result = Math.min(result, remove(denyIndex.get(i), indexMap, denyIndex));
        }
        return denyIndex.isEmpty() ? 0 : result + 1;
    }

    private int remove(Integer removeIndex, Map<Integer, Integer> indexMap, List<Integer> denyIndex) {
        int left = 0;
        int mid = 0;
        int right = 0;
        //左边
        Map<Integer, Integer> curMap = new HashMap<>(indexMap);
        List<Integer> delIndex = curMap.keySet().stream().filter(x -> x <= removeIndex).collect(Collectors.toList());
        left += delIndex.size();
        delIndex.forEach(curMap::remove);

        List<Integer> newDeny = denyIndex.stream().filter(x -> x > removeIndex).collect(Collectors.toList());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < newDeny.size(); i++) {
            min = Math.min(min, remove(newDeny.get(i), curMap, newDeny));
        }
        if (!newDeny.isEmpty()) {
            left += min;
        }

        //mid
        curMap = new HashMap<>(indexMap);
        curMap.remove(removeIndex);
        mid += 2;
        newDeny = denyIndex.stream().filter(x -> !x.equals(removeIndex)).collect(Collectors.toList());
        min = Integer.MAX_VALUE;
        for (int i = 0; i < newDeny.size(); i++) {
            min = Math.min(min, remove(newDeny.get(i), curMap, newDeny));
        }
        if (!newDeny.isEmpty()) {
            mid += min;
        }

        //right
        curMap = new HashMap<>(indexMap);
        delIndex = curMap.keySet().stream().filter(x -> x > removeIndex).collect(Collectors.toList());
        right += delIndex.size();
        delIndex.forEach(curMap::remove);
        newDeny = denyIndex.stream().filter(x -> x < removeIndex).collect(Collectors.toList());
        min = Integer.MAX_VALUE;
        for (int i = 0; i < newDeny.size(); i++) {
            min = Math.min(min, remove(newDeny.get(i), curMap, newDeny));
        }
        if (!newDeny.isEmpty()) {
            right += min;
        }

        return Math.min(Math.min(left, mid), right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTime("0010"));
    }


}
