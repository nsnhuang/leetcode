package _24;

import node.ListNode;

/**
 * 描述:
 *
 * @author huang
 * @since 2019-10-08 9:15 PM
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        // 创建一个头节点, 方便代码
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        // 当前节点 和 前一个节点 后一个节点
        ListNode curr = preHead.next;
        ListNode pre = preHead;
        ListNode next  = curr.next;
        while (curr != null && curr.next != null) {

            pre.next = curr.next;
            curr.next = next.next;
            next.next = curr;

            // 更新状态
            pre = curr;
            curr = pre.next;
            if (curr != null) {
                next = curr.next;
            }
        }
        return preHead.next;
    }
}