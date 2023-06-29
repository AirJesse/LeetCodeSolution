package leetCode_75.q328_奇偶链表;

import common.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        ListNode point = even.next;
        int index = 1;
        while (point != null) {
            if (index % 2 != 0) {
                odd.next = point;
                odd = point;
            } else {
                even.next = point;
                even = point;
            }
            point = point.next;
            index++;
        }
        even.next = null;
        odd.next = evenHead;
        return head;

    }
}
