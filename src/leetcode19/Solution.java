package leetcode19;

/**
 * 描述:
 * 删除链表倒数第n个节点
 *
 * @author huang
 * @create 2019-08-28 4:51 PM
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode before = new ListNode(-1);
        before.next = head;
        ListNode nextNode = before;
        ListNode newHead = before;
        ListNode pre = before;
        for (int i = 0; i < n; i++) {
            nextNode = nextNode.next;
        }
        while (nextNode.next != null) {
            pre = head;
            nextNode = nextNode.next;
            head = head.next;
        }
        pre.next = head.next;
        return newHead.next;
    }
}