package solutions.q3065_超过阈值的最少操作数2;


import java.util.*;

public class Solution {
    public int minOperations(int[] nums, int k) {
        int result = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(Long.valueOf(num));
        }
        while (true) {
            if(pq.size()<=1){
                return result;
            }
            long x = pq.poll();
            long y = pq.poll();
            if (x >= k) {
                return result;
            }
            result++;
            pq.add(x * 2 + y);
        }
    }
}
