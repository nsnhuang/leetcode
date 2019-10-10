package _160;

import node.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author huang
 * 使用set进行判重
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        while (headA != null || headB != null) {
            if (headA != null) {
                if (!set.contains(headA)) {
                    set.add(headA);
                    headA = headA.next;
                } else {
                    return headA;
                }
            }

            if (headB != null) {
                if (!set.contains(headB)) {
                    set.add(headB);
                    headB = headB.next;
                } else {
                    return headB;
                }
            }

        }
        return null;
    }
}