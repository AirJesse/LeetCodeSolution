package leetCode_75.q2130_链表最大孪生和;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int max = 0;
        for (int i = 0; i < n / 2; i++) {
            int sum = list.get(i) + list.get(n - 1 - i);
            max = Math.max(sum, max);
        }
        return max;
    }
}
