package offer.base;

/**
 * 描述:
 * 树的练习
 *
 * @author huang
 * @create 2019-09-12 1:45 PM
 */
public class TreePractice {
    /**
     * 根据前序遍历和中序遍历，构建二叉树
     */
    public TreeNode construct(int[] preorder, int[] inorder) throws Exception {
        if (preorder == null || inorder == null) {
            return null;
        }
        int preend = preorder.length - 1;
        int inend = inorder.length - 1;
        return constructCore(preorder, 0, preend, inorder, 0, inend);
    }

    private TreeNode constructCore(int[] preOrder, int preStart, int preEnd,
                                   int[] inOrder, int inStart, int inEnd) throws Exception {
        // 构建根节点
        TreeNode root = new TreeNode();
        root.value = preOrder[preStart];
        root.left = null;
        root.right = null;

        // 递归出口
        if (preStart == preEnd) {
            if (inStart == inEnd && preOrder[preStart] == inOrder[inStart]) {
                return root;
            } else {
                throw new Exception("输入非法");
            }
        }

        // 在中序遍历中找到根节点的值
        int rootIndex = inStart;
        while (rootIndex <= inEnd && inOrder[rootIndex] != root.value) {
            rootIndex ++;
        }
        if (rootIndex == inEnd && inOrder[rootIndex] != root.value) {
            throw new Exception("输入非法");
        }
        int leftLength = rootIndex - inStart;
        if (leftLength > 0) {
            // 构建左子树
            root.left = constructCore(preOrder, preStart + 1, preStart + leftLength,
                    inOrder, inStart, rootIndex - 1);
        }
        if (leftLength < preEnd - preStart) {
            // 构建右子树
            root.right = constructCore(preOrder, preStart + leftLength + 1, preEnd,
                    inOrder, rootIndex + 1, inEnd);
        }

        return root;
    }



    public static void main(String[] args) throws Exception {
        TreePractice practice = new TreePractice();
        TreeNode root = practice.construct(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        System.out.println(root.value);
    }


    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }
}
