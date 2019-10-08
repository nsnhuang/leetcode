package linkedlist.leetcode21;


/**
 * 描述:
 * 合并两个有序链表
 *
 * @author huang
 * @create 2019-08-28 4:36 PM
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode result = pre;
        while(l1 != null || l2 != null) {
            if (l1 == null) {
                pre.next = l2;
                break;
            }
            if (l2 == null) {
                pre.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        return result.next;
    }
}