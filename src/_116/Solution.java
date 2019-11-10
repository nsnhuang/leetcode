package _116;


import node.Node;

class Solution {
    public Node connect(Node root) {
        Node node = root;

        while (node.left != null) {
            Node levelFirst = node.left;
            while (node.left != null) {
                node.left.next = node.right;
                if (node.next != null) {
                    node.right.next = node.next.left;
                } else {
                    node.right.next = null;
                }
                node = node.next;
            }
            node = levelFirst;
        }

        return root;
    }
}

