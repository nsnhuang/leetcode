package _144;


import node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        dfs(root);
        return res;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return ;
        }

        res.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}

class Solution2 {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
}

class Solution3 {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                res.add(node.val);
                node = node.right;
            } else {
                TreeNode pre = node.left;
                while (pre.right != null && pre.right != node) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    res.add(node.val);
                    pre.right = node;
                    node = node.left;

                } else {
                    pre.right = null;
                    node = node.right;

                }
            }
        }
        return res;
    }
}