package solutions.q141_环形链表;

import common.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;

        } while (fast != slow);

        return true;
    }
}
