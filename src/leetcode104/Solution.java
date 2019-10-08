package leetcode104;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private Queue<TreeNode> queue = new LinkedList<>();
    private Queue<TreeNode> nowqueue = new LinkedList<>();


    private int depth = 0;

    /**
     * 层序遍历方法
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    nowqueue.add(left);
                }
                if (right != null) {
                    nowqueue.add(right);
                }
            }

            while (!nowqueue.isEmpty()) {
                queue.add(nowqueue.poll());
            }
        }
        return depth;
    }

    /**
     * 递归方法
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth2(root.left);
            int right = maxDepth2(root.right);
            return Math.max(left, right) + 1;
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode20 = new TreeNode(20);
        treeNode20.left = new TreeNode(15);
        treeNode20.right = new TreeNode(7);
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = treeNode20;

        Solution solution = new Solution();
        int i = solution.maxDepth(root);
        System.out.println(i);
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