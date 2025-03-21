package solutions.q2266_统计打字方案数;

public class Solution {
    public int countTexts(String pressedKeys) {
        long result = 1;
        int[] dpTable3 = new int[pressedKeys.length() + 3];
        int[] dpTable4 = new int[pressedKeys.length() + 3];

        dpTable3[0] = 1;
        dpTable3[1] = 1;
        dpTable3[2] = 2;
        dpTable3[3] = 4;
        dpTable4[0] = 1;
        dpTable4[1] = 1;
        dpTable4[2] = 2;
        dpTable4[3] = 4;

        char prv = 'a';
        int num = 0;

        for (int i = 0; i < pressedKeys.length(); i++) {
            char c = pressedKeys.charAt(i);
            if (c != prv) {
                if (prv == '7' || prv == '9') {
                    result *= dpTable4[num];
                } else {
                    result *= dpTable3[num];
                }
                prv = c;
                num = 1;
            } else {
                num++;
                if (prv == '7' || prv == '9') {
                    if (num > 3) {
                        dpTable4[num] = dpTable4[num - 1] + dpTable4[num - 2] + dpTable4[num - 3] + dpTable4[num - 4];
                    }
                } else {
                    if (num > 3) {
                        dpTable3[num] = dpTable3[num - 1] + dpTable3[num - 2] + dpTable3[num - 3];
                    }
                }
            }
            if (i == pressedKeys.length() - 1) {
                if (prv == '7' || prv == '9') {
                    result *= dpTable4[num];
                } else {
                    result *= dpTable3[num];
                }
            }
        }
        return (int) (result % (1000000000 + 7));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countTexts("444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664"));
    }
}
