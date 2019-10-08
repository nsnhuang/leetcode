package linkedlist.leetcode25;

/**
 * @author huang
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // 不用翻转的情况
        ListNode aHead = head;
        for (int i = 0; i < k; i++) {
            if (aHead == null) {
                return head;
            }
            aHead = aHead.next;
        }

        // pre代表翻转区间前一个节点
        ListNode pre = new ListNode(-1);
        // 使用myHead记录翻转之后的新head
        ListNode myHead = pre;
        pre.next = head;
        // end代表翻转区间最后一个节点
        ListNode end = pre;
        // curr代表翻转区间第一个节点
        ListNode curr = pre.next;
        for (int i = 0; i < k; i++) {
            end = end.next;
        }
        // next代表下一个翻转区间的第一个节点
        ListNode next = end.next;

        while (true) {
            // 区间翻转
            // after before代表curr的后一个和前一个节点
            ListNode after = curr.next;
            curr.next = next;
            while (after != next && after != null) {
                ListNode tmp = after.next;
                after.next = curr;
                curr = after;
                after = tmp;
            }
            pre.next = curr;

            // 指针调整到下一个区间
            curr = next;
            for (int i = 0; i < 2 * k - 1; i++) {
                if (end == null) {
                    break;
                }
                end = end.next;
            }
            if (end != null) {
                next = end.next;
            } else {
                break;
            }
            for (int i = 0; i < k; i++) {
                pre = pre.next;
            }
        }
        return myHead.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        Solution solution = new Solution();
        solution.reverseKGroup(head, 2);
    }

}
