package leetcode98;

import java.util.LinkedList;

/**
 *
 */
class Solution {

    /**
     * 递归方法
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public static boolean helper(TreeNode root, Integer lower, Integer upper) {

        if (root == null) {
            return true;
        }

        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }

        if (!helper(root.left, lower, root.val)) {
            return false;
        }
        if (!helper(root.right, root.val, upper)) {
            return false;
        }

        return true;
    }


    /**
     * -------------------------------------------------------------------------
     */
    private LinkedList<TreeNode> stack = new LinkedList<>();
    private LinkedList<Integer> lowers = new LinkedList<>();
    private LinkedList<Integer> uppers = new LinkedList<>();

    private void update(TreeNode root, Integer lower, Integer upper) {
        this.stack.add(root);
        this.lowers.add(lower);
        this.uppers.add(upper);
    }

    /**
     * 非递归方法，栈实现
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        update(root, null, null);

        while(!stack.isEmpty()) {
            TreeNode node = stack.poll();
            Integer lower = lowers.poll();
            Integer upper = uppers.poll();

            if (node == null) {
                continue;
            }

            if (lower != null && node.val <= lower) {
                return false;
            }
            if (upper != null && node.val >= upper) {
                return false;
            }
            update(node.left, lower, node.val);
            update(node.right, node.val, upper);

        }
        return true;
    }


    /**
     * --------------------------------------------------------------
     */
//    private LinkedList<TreeNode> stack = new LinkedList<>();

    private double inorder = - Double.MAX_VALUE;

    /**
     * 中序遍历方法
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}

