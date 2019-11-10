package _106;

import node.TreeNode;

import java.util.HashMap;

class Solution {

    private int postIdx;
    private HashMap<Integer, Integer> indexMap = new HashMap<>();
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        int index = 0;
        for (int in : inorder) {
            indexMap.put(in, index);
            index ++;
        }
        postIdx = postorder.length - 1;
        return build(0, postorder.length);
    }

    public TreeNode build(int start, int end) {

        if (start == end) {
            return null;
        }

        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);
        int index = indexMap.get(rootVal);

        postIdx--;

        root.right = build(index + 1, end);

        root.left = build(start, index);

        return root;

    }
}