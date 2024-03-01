package leetCode_75.q2095_删除链表的中间节点;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        if (list.size() == 1) {
            return null;
        }
        if (list.size() == 2) {
            list.get(0).next = null;
            return head;
        }
        list.get(list.size() / 2 - 1).next = list.get(list.size() / 2 + 1);

        return head;
    }

    //快慢指针版
    public ListNode deleteMiddle2(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return head;

    }
}
