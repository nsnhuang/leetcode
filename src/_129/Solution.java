package _129;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<String> res = new ArrayList<>();

    public int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }

        dfs(root, "");
        int sum = 0;
        for (String num : res) {
            sum += Integer.valueOf(num);
        }
        return sum;
    }

    public void dfs(TreeNode node, String s) {
        if (node.right == null && node.left == null) {
            res.add(s + node.val);
            return ;
        }

        if (node.left != null) {
            dfs(node.left, s + node.val);
        }
        if (node.right != null) {
            dfs(node.right, s + node.val);
        }
    }
}

/**
 * 效率高
 */
class Solution2 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return find(root, 0);
    }

    public int find(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int base = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return base;
        }

        return find(root.left, base) + find(root.right, base);
    }
}