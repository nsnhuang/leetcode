package offer.base;

/**
 * 描述:
 * 二叉树练习2
 *
 * @author huang
 * @create 2019-09-12 3:28 PM
 */
public class TreePractice2 {

    public TreeNode getNext(TreeNode node) {
        // 安全检查
        if (node == null) {
            return null;
        }

        TreeNode next = null;
        // 先看节点有没有右子树
        if (node.right != null) {
            // 有右子树，找右子树的最左节点
            next = node.right;
            while (next.left != null) {
                next = next.left;
            }
        } else if (node.parent != null) {
            // 没有右子树，找parent，直到当前节点是他父节点的左子节点
            TreeNode current = node;
            TreeNode parent = node.parent;
            while (current.parent != null && current == parent.right) {
                current = parent;
                parent = parent.parent;
            }
            next = parent;
        }
        return next;
    }


    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }
}

