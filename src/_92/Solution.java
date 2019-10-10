package _92;

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode con = pre;
        for (int i = 0; i < m - 1; i++) {
            con = con.next;
        }
        ListNode prev = con.next;
        ListNode curr = prev.next;

        ListNode next = null;
        for (int i = 0; i < n - m; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        con.next.next = curr;
        con.next = prev;

        return pre.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5};
        ListNode h = new ListNode(1);
        ListNode node = h;
        for (int i : arr) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode res = new Solution().reverseBetween(h, 2, 5);
        System.out.println(res.toString());
    }
}