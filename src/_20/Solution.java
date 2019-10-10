package _20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 描述:
 * 匹配字符串
 * @author huang
 * @since 2019-10-08 8:49 PM
 */
public class Solution {

    private Map<Character, Character> map;
    public Solution() {
        map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 如果是右括号，出栈验证
            if (map.containsKey(c)) {
                // 如果栈空，或者 出栈不匹配, 返回false
                if (stack.empty() || !stack.pop().equals(map.get(c))) {
                    return false;
                }
            } else {
                // 如果是左括号，入栈
                stack.push(c);
            }
        }
        return stack.empty();
    }

}