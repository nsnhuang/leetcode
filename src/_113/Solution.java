package _113;

import node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }

        path(root, sum, new ArrayList<>());

        return res;
    }

    public void path(TreeNode root, int sum, List<Integer> list) {

        if (root == null) {
            return ;
        }

        sum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(list));
            }
        }

        path(root.left, sum, list);
        path(root.right, sum, list);
        list.remove(list.size() - 1);
    }
}