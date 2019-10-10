package _328;

import node.ListNode;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;

        // 初始化快慢指针位置，preFast指针方便节点交换，指向fast指针的前一个节点
        ListNode slow = pre;
        ListNode fast = pre.next;
        ListNode preFast = pre.next;
        while (fast.next != null && fast.next.next != null) {
            // 移动指针
            slow = slow.next;
            preFast = fast.next;
            fast = fast.next.next;

            // 交换节点位置
            preFast.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            fast = preFast;
        }

        return pre.next;
    }
}