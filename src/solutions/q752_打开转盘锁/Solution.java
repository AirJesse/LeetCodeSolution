package solutions.q752_打开转盘锁;

import Utils.ArrayUtil;

import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();

        int num = 0;
        Collections.addAll(visited, deadends);
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (visited.contains(poll)) {
                    continue;
                } else {
                    visited.add(poll);
                }
                if (poll.equals(target)) {
                    return num;
                }
                for (int j = 0; j < 4; j++) {
                    char[] chars = poll.toCharArray();
                    int digit = Character.digit(chars[j], 10);
                    if (digit != 9) {
                        chars[j] = Character.forDigit(digit + 1, 10);
                        queue.offer(String.valueOf(chars));
                    }
                    chars[j] = Character.forDigit((digit - 1 < 0) ? 9 : (digit - 1), 10);
                    queue.offer(String.valueOf(chars));

                }
            }
            num++;
        }

        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(i);
    }
}
