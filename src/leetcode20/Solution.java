package leetcode20;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author huang
 */
public class Solution {

    private HashMap<Character, Character> mappings;

    public Solution() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // 遍历每一个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 如果是右括号，弹出栈顶元素进行比较
            if (this.mappings.containsKey(c)) {
                // 如果栈空 或者 弹出的栈顶元素不匹配，返回false
                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // 如果是左括号，压栈
                stack.push(c);
            }
        }
        // 栈空返回true
        return stack.isEmpty();
    }
}
