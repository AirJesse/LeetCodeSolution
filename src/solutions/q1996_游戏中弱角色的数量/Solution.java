package solutions.q1996_游戏中弱角色的数量;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        List<int[]> collect = Arrays.stream(properties).sorted((o1, o2) -> {
            if (o1[0] < o2[0]) {
                return 1;
            } else if (o1[0] > o2[0]) {
                return -1;
            }
            return Integer.compare(o2[1], o1[1]);
        }).collect(Collectors.toList());
        int maxDefense = Integer.MIN_VALUE;
        int nowDefense = collect.get(0)[1];
        int result = 0;
        for (int i = 1; i < collect.size(); i++) {
            int[] man = collect.get(i);
            int[] pre = collect.get(i - 1);
            if (man[0] == pre[0]) {
                nowDefense = Math.max(nowDefense, man[1]);
            } else {
                maxDefense = Math.max(maxDefense, nowDefense);
                nowDefense = man[1];
            }
            if (man[1] < maxDefense) {
                result++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numberOfWeakCharacters(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}});
        System.out.println(i);
    }
}
