package zhou161._3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> delList = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    delList.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (stack.contains(i)) {
                continue;
            }
            if (delList.contains(i)) {
                continue;
            }
            builder.append(chars[i]);
        }
        return builder.toString();
    }
}