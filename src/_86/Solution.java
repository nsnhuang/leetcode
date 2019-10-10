package _86;

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
    public ListNode partition(ListNode head, int x) {

        ListNode before = new ListNode(-1);
        ListNode beforeNode = before;
        ListNode after = new ListNode(-1);
        ListNode afterNode = after;

        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                beforeNode.next = node;
                beforeNode = beforeNode.next;
            } else {
                afterNode.next = node;
                afterNode = afterNode.next;
            }
            node = node.next;
        }
        beforeNode.next = after.next;
        afterNode.next = null;
        return before.next;
    }
}