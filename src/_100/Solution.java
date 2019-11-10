package _100;

import node.TreeNode;

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        return isSameTree(p.left, q.left) && p.val == q.val && isSameTree(p.right, q.right);
    }
}