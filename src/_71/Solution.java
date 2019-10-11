package _71;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class Solution {

    private Stack<String> stack  = new Stack<>();

    public String simplifyPath(String path) {
        String[] s = path.split("/");
        for (String a : s) {
            if ("".equals(a)) {
                continue;
            }
            if ("..".equals(a)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (".".equals(a)) {
                continue;
            } else {
                stack.add(a);
            }
        }

        StringBuilder buider = new StringBuilder();
        buider.append("/");
        for (int i = 0; i < stack.size(); i++) {
            buider.append(stack.get(i));
            buider.append("/");
        }
        if (buider.length() != 1) {
            buider.deleteCharAt(buider.length() - 1);
        }
        return buider.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().simplifyPath("/../");
        System.out.println(s);
    }
}