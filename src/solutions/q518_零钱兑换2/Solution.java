package solutions.q518_零钱兑换2;

import java.util.Arrays;

public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int pre_amount = i - coin;
                if (pre_amount < 0) {
                    continue;
                }
                dp[i] += dp[pre_amount];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().change(5, new int[]{1, 2, 5}));
    }
}
