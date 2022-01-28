package solutions.q2144_打折购买糖果的最小开销;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int j = 0;
        int result = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (j == 2) {
                j = 0;
                continue;
            }
            result += cost[i];
            j++;
        }
        return result;
    }
}
