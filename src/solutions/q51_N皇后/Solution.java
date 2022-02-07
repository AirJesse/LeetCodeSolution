package solutions.q51_N皇后;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] qp = new int[n][n];
        backTrace(qp, n, 0, result);
        return result;
    }

    private void backTrace(int[][] qp, int n, int i, List<List<String>> result) {
        if (i == n) {
            List<String> list = new ArrayList<>(n);
            for (int[] ints : qp) {
                StringBuilder sb = new StringBuilder(n);
                for (int anInt : ints) {
                    sb.append(anInt == 0 ? "." : "Q");
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        int[] row = qp[i];
        for (int col = 0; col < row.length; col++) {
            if (hasQueen(qp, i, col)) {
                continue;
            }
            row[col] = 1;
            backTrace(qp, n, i + 1, result);
            row[col] = 0;
        }

    }

    private boolean hasQueen(int[][] qp, int row, int col) {
        for (int i = 1; i <= row; i++) {
            if (qp[row - i][col] == 1) {
                return true;
            }
            if (col - i >= 0 && qp[row - i][col - i] == 1) {
                return true;
            }
            if (col + i < qp.length && qp[row - i][col + i] == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(4);
        System.out.println(lists);
    }
}
