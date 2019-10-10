package leetcode876;

/**
 * 描述:
 * 求链表的中间节点
 *
 * @author huang
 * @create 2019-08-28 5:09 PM
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}