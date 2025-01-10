package solutions.q1405_最长快乐字符串;


import java.util.*;

public class Solution {
    public String longestDiverseString(int a, int b, int c) {

        AbstractMap.SimpleEntry<Character, Integer> pairA = new AbstractMap.SimpleEntry<>('a', a);
        AbstractMap.SimpleEntry<Character, Integer> pairB = new AbstractMap.SimpleEntry<>('b', b);
        AbstractMap.SimpleEntry<Character, Integer> pairC = new AbstractMap.SimpleEntry<>('c', c);
        Queue<AbstractMap.SimpleEntry<Character, Integer>> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        if (pairA.getValue() > 0) queue.offer(pairA);
        if (pairB.getValue() > 0) queue.offer(pairB);
        if (pairC.getValue() > 0) queue.offer(pairC);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Character, Integer> pair = queue.poll();
            if (sb.length() >= 2 && sb.charAt(sb.length() - 2) == pair.getKey() && sb.charAt(sb.length() - 1) == pair.getKey()) {
                AbstractMap.SimpleEntry<Character, Integer> next = queue.poll();
                if (next == null) break;
                sb.append(next.getKey());
                if (next.getValue() - 1 != 0) queue.offer(new AbstractMap.SimpleEntry<>(next.getKey(), next.getValue() - 1));
                queue.offer(pair);
            } else {
                sb.append(pair.getKey());
                if (pair.getValue() - 1 != 0) queue.offer(new AbstractMap.SimpleEntry<>(pair.getKey(), pair.getValue() - 1));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().longestDiverseString(1, 1, 7);
    }
}
