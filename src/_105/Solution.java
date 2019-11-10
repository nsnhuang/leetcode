package _105;

import node.TreeNode;

import java.util.HashMap;

class Solution {

    private int preIdx;
    private int[] preorder;
    private HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int index = 0;
        for (int in : inorder) {
            indexMap.put(in, index);
            index ++;
        }

        return build(0, preorder.length);
    }

    public TreeNode build(int start, int end) {

        if (start == end) {
            return null;
        }

        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        int index = indexMap.get(rootVal);

        preIdx++;

        root.left = build(start, index);

        root.right = build(index + 1, end);

        return root;

    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9,3,15,20,7};
        new Solution().buildTree(pre, in);
    }
}