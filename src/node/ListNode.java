package node;

/**
 * @author huang
 */
public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next != null) {
            return val + "," + next.toString();
        } else {
            return String.valueOf(val);
        }
    }
}