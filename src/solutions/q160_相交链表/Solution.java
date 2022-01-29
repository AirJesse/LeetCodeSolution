package solutions.q160_相交链表;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class Solution {

    /**
     * 最佳法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }

    /**
     * 任意链表循环到尾部后自动连接headB，这样就创建了一个环
     * 此题就可以变成找环起点。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode fast = headA;
        ListNode slow = headA;
        while (fast.next != null) {
            fast = fast.next;
        }
        ListNode last = fast;
        last.next = headB;
        fast = headA;

        do {
            if (fast == null || fast.next == null) {
                last.next =null;
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = headA;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        last.next =null;
        return fast;
    }


    /**
     * 我在2021年7月提交的第一版解法，hash表记录
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nextA = headA;
        ListNode nextB = headB;
        ListNode interNode = null;
        Set<ListNode> hashTable = new HashSet<>();


        while (nextA != null) {
            hashTable.add(nextA);
            nextA = nextA.next;
        }

        while (nextB != null) {
            if (hashTable.contains(nextB)) {
                interNode = nextB;
                break;
            }
            nextB = nextB.next;
        }

        return interNode;
    }
}

