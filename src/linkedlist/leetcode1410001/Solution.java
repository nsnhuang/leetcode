package linkedlist.leetcode1410001;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> contain = new HashSet<>();
        while (head != null) {
            if(contain.contains(head)) {
                return true;
            } else {
                contain.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
