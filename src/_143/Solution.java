package _143;

import node.ListNode;

class Solution {
    public void reorderList(ListNode head) {

        if (head == null) {
            return ;
        }
        ListNode fast = head;
        ListNode slow = head;

        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = slow.next;
        slow.next = null;
        ListNode node = pre.next;
        pre.next = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }

        ListNode preNode = preHead.next;
        ListNode nextNode = pre;
        node = preHead;
        while (preNode != null && nextNode != null) {
            node.next = preNode;
            node = node.next;
            preNode = preNode.next;

            node.next = nextNode;
            node = node.next;
            nextNode = nextNode.next;
        }

        node.next = preNode;
        head = preHead.next;
    }
}