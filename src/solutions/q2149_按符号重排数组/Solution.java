package solutions.q2149_按符号重排数组;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] zheng = new int[nums.length / 2];
        int zhengIndex = 0;
        int[] fu = new int[nums.length / 2];
        int fuIndex = 0;
        for (int num : nums) {
            if (num >= 0) {
                zheng[zhengIndex++] = num;
            } else {
                fu[fuIndex++] = num;
            }
        }
        int[] result = new int[nums.length];
        zhengIndex = 0;
        fuIndex = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result[i] = zheng[zhengIndex++];
            result[i + 1] = fu[fuIndex++];
        }
        return result;
    }
}
