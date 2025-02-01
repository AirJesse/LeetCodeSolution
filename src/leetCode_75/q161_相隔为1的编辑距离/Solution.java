package leetCode_75.q161_相隔为1的编辑距离;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int idx1 = 0, idx2 = 0;
        int gap = 0;
        while (idx1 < s.length() && idx2 < t.length()) {
            if (s.charAt(idx1) == t.charAt(idx2)) {
                idx1++;
                idx2++;
            } else {
                if (++gap > 1) return false;
                if (idx1 + 1 != s.length() && s.charAt(idx1 + 1) == t.charAt(idx2)) {
                    idx1++;
                }


            }
        }
    }
}
