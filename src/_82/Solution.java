package _82;

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode node = head;
        ListNode pre = newHead;
        int deleteValue = -1;

        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                deleteValue = node.val;
                while (node != null && node.val == deleteValue) {
                    node = node.next;
                }
                pre.next = node;
            } else {
                pre = node;
                node = node.next;
            }
        }
        return newHead.next;
    }
}