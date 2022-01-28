package solutions.q807_保持城市天际线;

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result = 0;
        int n = grid.length;
        int[] maxRow = new int[n];
        int[] maxCol = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxRow[i] = Math.max(grid[i][j], maxRow[i]);
                maxCol[j] = Math.max(grid[i][j], maxCol[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += Math.min(maxRow[i], maxCol[j]) - grid[i][j];
            }
        }
        return result;

    }
}
