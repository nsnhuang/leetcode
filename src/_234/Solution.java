package _234;

import node.ListNode;

import java.util.Stack;

/**
 * 描述:
 *
 * @author huang
 * @since 2019-10-09 9:00 PM
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = slow;
        ListNode node = pre.next;
        slow.next = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }

        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
}