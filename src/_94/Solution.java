package _94;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        doInroderTraversal(list, root);
        return list;
    }

    private void doInroderTraversal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        doInroderTraversal(list, node.left);
        list.add(node.val);
        doInroderTraversal(list, node.right);
    }
}

class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
