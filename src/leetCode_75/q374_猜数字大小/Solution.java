package leetCode_75.q374_猜数字大小;

public class Solution {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int pick = (left + right) / 2;
        int result = guess(pick);
        while (result != 0) {
            if (result == 1) {
                left = pick + 1;
            } else {
                right = pick - 1;
            }
            pick = (left + right) / 2;
            result = guess(pick);
        }
        return pick;
    }

    public int guessNumber2(int n) {
        int left = 1;
        int right = n;

        long pick =  (long) (left + right) / 2;
        while (true) {
            int result = guess((int) pick);
            if (result == 0) return (int) pick;
            if (result == 1) {
                left = (int) pick;
                pick = (pick + right + 1) / 2;
            } else {
                right = (int) pick;
                pick = (pick + left - 1) / 2;
            }
        }
    }


    private int guess(int pick) {
        if (pick == 6) {
            return 0;
        }
        if (pick < 6) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        new Solution().guessNumber(10);
    }
}
