package _61;

import node.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode last = head;
        int count = 0;
        while (last.next != null) {
            // 寻找最后一个节点
            last = last.next;
            count++;
        }
        count++;
        k = k % count;
        k = count - k;

        ListNode newHead = head;
        ListNode pre = head;
        for (int i = 0; i < k; i++) {
            pre = newHead;
            newHead = newHead.next;
            if (newHead == null) {
                newHead = head;
            }
        }

        last.next = head;
        pre.next = null;
        return newHead;
    }
}