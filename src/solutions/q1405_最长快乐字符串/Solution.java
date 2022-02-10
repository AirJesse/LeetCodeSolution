package solutions.q1405_最长快乐字符串;


import javafx.util.Pair;
import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;
import sun.nio.cs.SingleByte;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Pair<Character,Integer> pairA = new Pair<>('a',a);
        Pair<Character,Integer> pairB = new Pair<>('b',b);
        Pair<Character,Integer> pairC = new Pair<>('c',c);
        Queue<Pair<Character,Integer>> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.getValue(),o1.getValue()));
        if (pairA.getValue()>0) queue.offer(pairA);
        if (pairB.getValue()>0) queue.offer(pairB);
        if (pairC.getValue()>0) queue.offer(pairC);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            Pair<Character, Integer> pair = queue.poll();
            if(sb.length()>=2 && sb.charAt(sb.length()-2) == pair.getKey() && sb.charAt(sb.length()-1) == pair.getKey()){
                Pair<Character, Integer> next = queue.poll();
                if(next == null) break;
                sb.append(next.getKey());
                if(next.getValue() -1 != 0) queue.offer(new Pair<>(next.getKey(),next.getValue()-1));
                queue.offer(pair);
            }else{
                sb.append(pair.getKey());
                if(pair.getValue()-1 != 0) queue.offer(new Pair<>(pair.getKey(),pair.getValue()-1));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().longestDiverseString(1, 1, 7);
    }
}
