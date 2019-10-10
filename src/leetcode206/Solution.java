package leetcode206;

/**
 * @author huang
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode result = solution.reverseList(head);
        System.out.println(result.val +
                " --> " + result.next.val +
                " --> " + result.next.next.val +
                " --> " + result.next.next.next.val +
                " --> " + result.next.next.next.next.val);
    }
}


