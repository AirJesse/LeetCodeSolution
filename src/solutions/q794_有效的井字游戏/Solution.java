package solutions.q794_有效的井字游戏;

public class Solution {
    public boolean validTicTacToe(String[] board) {
        //允许 O X相等或X多1
        //O = 1  X =2  空 =0
        boolean win = false;
        int[] row = new int[3];
        int[] col = new int[3];
        int x1 = 0;
        int x2 = 0;
        int xNum = 0;
        int oNum = 0;
        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            for (int j = 0; j < 3; j++) {
                int value = getValue(s.charAt(j));
                row[i] += value;
                col[j] += value;
                if (value == 1) {
                    oNum++;
                }
                if (value == 2) {
                    xNum++;
                }
                if (i == j) {
                    x1 += value;
                }
                if ((2 - j) == i) {
                    x2 += value;
                }
            }
        }


        if (oNum > xNum || xNum - oNum > 1) {
            return false;
        }
        if (x1 == 3 || x1 == 6) {
            win = true;
        }
        if (x2 == 3 || x2 == 6) {
            if (win) {
                return false;
            }
            win = true;
        }
        for (int i : row) {
            if (i == 3 || i == 6) {
                if (win) {
                    return false;
                }
                win = true;
            }
        }
        for (int i : col) {
            if (i == 3 || i == 6) {
                if (win) {
                    return false;
                }
                win = true;
            }
        }

        return true;

    }

    private int getValue(char charAt) {
        if (charAt == 'X') {
            return 2;
        }
        if (charAt == 'O') {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        new Solution().validTicTacToe(new String[]{"XXX", "OOX", "OOX"});
    }
}
