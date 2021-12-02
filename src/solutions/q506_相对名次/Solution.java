package solutions.q506_相对名次;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    //一点都不优雅的题解，哎....
    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> scoreToOrderMap = new HashMap<>(score.length);
        List<Integer> collect = Arrays.stream(score).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            scoreToOrderMap.put(collect.get(i), i);
        }
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            Integer order = scoreToOrderMap.get(score[i]);

            if (order == 0) {
                result[i] = "Gold Medal";
            } else if (order == 1) {
                result[i] = "Silver Medal";
            } else if (order == 2) {
                result[i] = "Bronze Medal";
            } else {
                result[i] = String.valueOf(order + 1);
            }
        }
        return result;
    }
}
