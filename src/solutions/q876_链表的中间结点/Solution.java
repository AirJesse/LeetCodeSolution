package solutions.q876_链表的中间结点;

import common.ListNode;

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int step = 1;
        while (fast.next != null) {
            if (step++ % 2 != 0) {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return slow;
    }
}
