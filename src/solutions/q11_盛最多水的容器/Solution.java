package solutions.q11_盛最多水的容器;

public class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int preLeft = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] <= preLeft) {
                continue;
            }
            preLeft = height[i];
            int preRight = 0;
            for (int j = height.length - 1; j > i; j--) {
                if (height[j] <= preRight) {
                    continue;
                }
                int cap = Math.min(height[i], height[j]) * (j - i);
                result = Math.max(result, cap);
                if (height[i] <= height[j]) {
                    break;
                }
                preRight = height[j];
            }
        }
        return result;
    }
}
