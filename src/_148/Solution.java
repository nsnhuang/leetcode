package _148;

import node.ListNode;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } // slow 在中间，或者中间两个中 靠左边的一个

        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode pre = new ListNode(-1);
        ListNode n = pre;
        while (left != null && right != null) {
            if (left.val < right.val) {
                n.next = left;
                left = left.next;
            } else {
                n.next = right;
                right = right.next;
            }
            n = n.next;
        }
        if (left != null) {
            n.next = left;
        } else {
            n.next = right;
        }
        return pre.next;
    }
}