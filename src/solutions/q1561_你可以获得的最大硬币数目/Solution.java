package solutions.q1561_你可以获得的最大硬币数目;

import java.util.Arrays;

public class Solution {
    public int maxCoins(int[] piles) {
        int result = 0;
        Arrays.sort(piles);
        for (int i = 0, j = piles.length - 2; i < j; i++, j = j - 2) {
            result += piles[j];
        }
        return result;
    }
}
