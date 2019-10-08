package linkedlist.leetcode24;

/**
 * @author huang
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = new ListNode(-1);
        prev.next = head;

        ListNode self = head;
        ListNode after = head.next;

        ListNode result = head.next;

        while (prev.next != null && prev.next.next != null) {
            prev.next = after;
            self.next = after.next;
            after.next = self;

            prev = self;
            self = self.next;
            if (self != null) {
                after = self.next;
            } else {
                after = null;
            }
        }
        return result;

    }

    public ListNode swapPairs2(ListNode head) {

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode tmp = pre;

        while (tmp.next != null && tmp.next.next != null) {
            ListNode next = tmp.next;
            ListNode renext = next.next;
            next.next = renext.next;
            renext.next = next;
            tmp.next = renext;
            tmp = tmp.next.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode result = solution.swapPairs(head);
        System.out.println(result.val +
                " --> " + result.next.val +
                " --> " + result.next.next.val +
                " --> " + result.next.next.next.val +
                " --> " + result.next.next.next.next.val);
    }
}