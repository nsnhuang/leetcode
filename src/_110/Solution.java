package _110;

import node.TreeNode;

/**
 * 截断法
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private static int depth(TreeNode root){
        if(root == null) {
            return 0;
        }

        int left = depth(root.left);
        if(left==-1) {
            return -1;
        }

        int right = depth(root.right);
        if(right==-1) {
            return -1;
        }

        boolean balance = Math.abs(left - right) < 2;
        if (balance) {
            return Math.max(left,right) + 1;
        } else {
            return -1;
        }
    }
}