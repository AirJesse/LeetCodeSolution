package leetCode_75.q2352_相等行列对;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> hang = new HashMap<>();
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j]);
                sb.append(" ");
            }
            String s = sb.toString();
            hang.put(s, hang.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[j][i]);
                sb.append(" ");
            }
            result+=hang.getOrDefault(sb.toString(),0);
        }
        return result;

    }
}
