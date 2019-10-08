package leetcode22;

import java.util.*;

class Solution {

    private List<String> list = new LinkedList<>();

    public void generate(int left, int right, int n, String result) {
        if (left == n && right == n) {
            list.add(result);
        }

        if (left < n) {
            generate(left + 1, right, n, result + "(");
        }
        if (left > right && right < n) {
            generate(left, right + 1, n, result + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return list;
    }
}