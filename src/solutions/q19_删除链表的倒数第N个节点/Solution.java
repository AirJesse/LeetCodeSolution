package solutions.q19_删除链表的倒数第N个节点;

import common.ListNode;
import sun.awt.geom.AreaOp;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        int step = 0;
        while (p1.next != null) {
            p1 = p1.next;
            if (step >= n) {
                p2 = p2.next;
            }
            step++;
        }
        if (step < n) {
            return head.next;
        }

        if (p2.next == null) {
            return null;
        }
        p2.next = p2.next.next;
        return head;
    }
}
