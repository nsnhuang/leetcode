package leetcode79;

import java.util.HashSet;
import java.util.Set;

class Solution {

    Set<String> res = new HashSet<>();

    public boolean exist(char[][] board, String word) {

        word = word.toLowerCase();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c >= 65 && c <= 90) {
                    board[i][j] = (char) (c + 32);
                }
            }
        }
        Trie trie = new Trie();
        trie.insert(word);


        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }
        return !res.isEmpty();
    }

    private void dfs(char[][] board, boolean[][] visited, String s, int i, int j, Trie trie) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return ;
        }
        if (visited[i][j]) {
            return ;
        }

        s += board[i][j];
        if (!trie.startsWith(s)) {
            return ;
        }

        if (trie.search(s)) {
            res.add(s);
        }
        visited[i][j] = true;

        dfs(board, visited, s, i - 1, j, trie);
        dfs(board, visited, s, i + 1, j, trie);
        dfs(board, visited, s, i, j - 1, trie);
        dfs(board, visited, s, i, j + 1, trie);
        visited[i][j] = false;
    }

}


class Trie {

    private TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
        root.val = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TreeNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null) {
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}

class TreeNode {
    public char val;
    public boolean isWord;
    public TreeNode[] children = new TreeNode[26];

    TreeNode() {}

    public TreeNode(char c) {
        TreeNode node = new TreeNode();
        node.val = c;
    }
}

