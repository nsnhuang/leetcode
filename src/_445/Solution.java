package _445;

import node.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pre1 = reverse(l1);
        ListNode pre2 = reverse(l2);

        ListNode newHead = new ListNode(-1);
        ListNode node = newHead;
        while (pre1 != null && pre2 != null) {
            pre1.val = pre1.val + pre2.val;
            node.next = pre1;
            node = node.next;

            pre1 = pre1.next;
            pre2 = pre2.next;
        }
        if (pre1 != null) {
            node.next = pre1;
        } else {
            node.next = pre2;
        }

        ListNode preNode = newHead;
        ListNode curr = preNode.next;
        while (curr != null) {
            ListNode tmp = curr.next;
            int carry = curr.val / 10;

            if (carry > 0) {
                if (curr.next != null) {
                    curr.next.val += carry;
                    curr.val = curr.val % 10;
                } else {
                    curr.next = new ListNode(carry);
                    curr.val = curr.val % 10;
                    tmp = curr.next;
                }
            }

            curr.next = preNode;
            preNode = curr;
            curr = tmp;
        }
        newHead.next.next = null;
        newHead.next = preNode;

        return newHead.next;
    }

    public ListNode reverse(ListNode l) {
        ListNode pre = l;
        ListNode node = l.next;
        pre.next = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        return pre;
    }

    public  static void main(String[] args) {
        new Solution().addTwoNumbers(new ListNode(5), new ListNode(5));
    }
}