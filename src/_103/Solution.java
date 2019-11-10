package _103;

import node.TreeNode;

import java.util.*;

class Solution {

    private List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {

            LinkedList<Integer> list = new LinkedList<>();

            int len = queue.size();
            for(int i = 0; i < len; ++i) {
                TreeNode node = queue.remove();

                if (reverse) {
                    list.addFirst(node.val);
                } else {
                    list.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levels.add(list);
            reverse = !reverse;
        }
        return levels;
    }
}