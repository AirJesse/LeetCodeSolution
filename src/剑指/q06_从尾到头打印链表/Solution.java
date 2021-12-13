package 剑指.q06_从尾到头打印链表;

public class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode nextNode = null;
        ListNode preNode = null;
        int num = 0;
        while (head != null) {
            num++;
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        int[] result = new int[num];
        int index = 0;
        while (preNode !=null){
            result[index++] = preNode.val;
            preNode = preNode.next;
        }
        return result;

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
