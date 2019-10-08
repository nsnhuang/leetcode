package leetcode111;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /**
     * 递归方法
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int right = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if (root.right != null) {
            right = minDepth(root.right);
        }
        if (root.left != null) {
            left = minDepth(root.left);
        }
        return Math.min(right, left) + 1;
    }


    /**
     * ------------------------------------------------------------------------
     */
    private Queue<TreeNode> queue = new LinkedList<>();
    private Queue<TreeNode> nowqueue = new LinkedList<>();

    /**
     * 层序遍历方法
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            count ++;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    nowqueue.add(node.left);
                }
                if (node.right != null) {
                    nowqueue.add(node.right);
                }
                if (node.left == null && node.right == null) {
                    return count;
                }
            }
            while (!nowqueue.isEmpty()) {
                queue.add(nowqueue.poll());
            }
        }
        return count;
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