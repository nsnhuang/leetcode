package leetcode142;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode myHead = head;

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != slow) {
            if(fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        while (myHead != fast) {
            myHead = myHead.next;
            fast = fast.next;
        }
        return myHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);

        ListNode node1 = new ListNode(2);
        head.next = node1;

        ListNode node2 = new ListNode(0);
        node1.next = node2;

        ListNode node3 = new ListNode(-4);
        node2.next = node3;

        node3.next = node1;

        Solution solution = new Solution();
        ListNode result = solution.detectCycle(head);
        System.out.println(result.val);
    }
}
