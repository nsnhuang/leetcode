package _160;

import node.ListNode;


/**
 * @author huang
 * 使用双指针
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            if (nodeA == null) {
                nodeA = headB;
            } else {
                nodeA = nodeA.next;
            }

            if (nodeB == null) {
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }
        }
        return nodeA;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,8,4,5};
        int[] arrB = new int[]{5,0,1,8,4,5};
        ListNode headA = new ListNode(arr[0]);
        ListNode headB = new ListNode(arrB[0]);

        ListNode nodeA = headA;
        for (int i = 1; i < arr.length; i++) {
            nodeA.next = new ListNode(arr[i]);
            nodeA = nodeA.next;
        }

        ListNode nodeB = headB;
        for (int i = 1; i < arr.length; i++) {
            nodeB.next = new ListNode(arrB[i]);
            nodeB = nodeB.next;
        }

        new Solution2().getIntersectionNode(headA, headB);
    }
}