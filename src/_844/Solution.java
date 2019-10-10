package _844;

import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String S, String T) {

        if (S.equals(T)) {
            return true;
        }

        Stack<Character> stackT = process(T);
        Stack<Character> stackS = process(S);

        if (stackS.size() != stackT.size()) {
            return false;
        } else {
            for (int i = 0; i < stackS.size(); i++) {
                Character s = stackS.pop();
                Character t = stackT.pop();
                if (!s.equals(t)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Stack<Character> process(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }
}