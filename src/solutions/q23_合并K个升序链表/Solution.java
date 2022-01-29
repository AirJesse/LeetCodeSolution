package solutions.q23_合并K个升序链表;

import common.ListNode;

import java.util.Arrays;


public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        return mergeTwoLists(mergeKLists(Arrays.copyOfRange(lists, 0, lists.length / 2)), mergeKLists(Arrays.copyOfRange(lists, lists.length / 2 , lists.length)));
    }

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode node = root;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 != null) {
            node.next = list1;
        }
        if (list2 != null) {
            node.next = list2;
        }
        return root.next;

    }
}
