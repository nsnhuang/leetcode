package _147;

import node.ListNode;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode preNode = head;
        ListNode node = head.next;
        ListNode nodeNext = node.next;
        while (node != null) {

            ListNode pre = preHead;
            ListNode curr = pre.next;
            while (curr != node) {
                if (curr.val > node.val) {
                    preNode.next = nodeNext;

                    node.next = curr;
                    pre.next = node;

                    break;
                }
                pre = pre.next;
                curr = curr.next;
            }
            node = nodeNext;
            while (preNode.next != node) {
                preNode = preNode.next;
            }
            if (node != null) {
                nodeNext = node.next;
            }
        }
        return preHead.next;
    }
}