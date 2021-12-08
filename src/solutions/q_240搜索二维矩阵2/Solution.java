package solutions.q_240搜索二维矩阵2;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = 0;
        while (true) {
            int value = matrix[row][col];
            if (value == target) {
                return true;
            }
            if (value > target) {
                if (col == 0) {
                    return false;
                }
                col--;
            } else {
                if (col == matrix[row].length - 1) {
                    if (row == matrix.length - 1) {
                        return false;
                    } else {
                        row++;
                    }
                } else if (matrix[row][col + 1] <= target) {
                    col++;
                } else {
                    if (row == matrix.length - 1) {
                        return false;
                    }
                    row++;
                }
            }

        }
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        AtomicInteger flag = new AtomicInteger();
        Arrays.stream(matrix).flatMapToInt(Arrays::stream).forEach(item -> {
            if(item == target){
                flag.set(1);
                return;
            }
        });
        return flag.get() == 1;

    }
}
