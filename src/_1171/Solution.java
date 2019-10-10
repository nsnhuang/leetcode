package _1171;

import node.ListNode;

import java.util.HashMap;

class Solution {

    HashMap<Integer, ListNode> map = new HashMap<>();

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int sum = 0;
        ListNode node = head;
        while (node != null) {
            sum += node.val;
            if (sum == 0) {
                head = node.next;
                node = node.next;
                map.clear();
            } else {
                if (map.containsKey(sum)) {
                    map.get(sum).next = node.next;

                    node = head;
                    map.clear();
                    sum = 0;
                } else {
                    map.put(sum, node);
                    node = node.next;
                }
            }
        }
        return head;
    }
}