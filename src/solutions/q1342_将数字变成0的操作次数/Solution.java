package solutions.q1342_将数字变成0的操作次数;

public class Solution {
    public int numberOfSteps(int num) {
        int result = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num -= 1;
            }
            result++;
        }

        return result;
    }
}
