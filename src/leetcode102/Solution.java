package leetcode102;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 */
class Solution {

    private Queue<TreeNode> nowqueue = new LinkedList<>();

    private Queue<TreeNode> queue = new LinkedList<>();

    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new LinkedList<>();
        }

        queue.add(root);

        while(!queue.isEmpty()) {

            LinkedList<Integer> res = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    nowqueue.add(node.left);
                }
                if (node.right != null) {
                    nowqueue.add(node.right);
                }
                res.add(node.val);
            }
            result.add(res);

            while (!nowqueue.isEmpty()) {
                queue.add(nowqueue.poll());
            }
        }
        return result;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int x) {
        val = x;
    }
}