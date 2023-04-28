package solutions.q202_快乐数;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true) {
            int next = 0;
            for (char c : String.valueOf(n).toCharArray()) {
                next += Math.pow(Character.digit(c, 10), 2);
            }
            if (next == 1) {
                return true;
            }
            if (set.contains(next)) {
                return false;
            }
            set.add(next);
            n = next;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
    }
}
