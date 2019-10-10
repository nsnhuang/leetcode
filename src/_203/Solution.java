package _203;

import node.ListNode;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode node = head;
        ListNode pre = preHead;
        while (node != null) {

            if (node.val == val) {
                pre.next = node.next;
                node = node.next;
                continue;
            }
            pre = pre.next;
            node = node.next;
        }
        return preHead.next;
    }
}