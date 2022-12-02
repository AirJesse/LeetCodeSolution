package solutions.q1779_找到最近的有相同x或y坐标的点;

public class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minLen = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if(point[0] == x || point[1] == y){
                int len = Math.abs(point[0] - x) + Math.abs(point[1] -y);
                if(len < minLen){
                    minLen=len;
                    index = i;
                }
            }
        }
        return index;
    }
}
