package _150;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> op = new Stack<>();
        Stack<Integer> num = new Stack<>();

        for (String token : tokens) {
            if ("+".equals(token)) {
                Integer num1 = num.pop();
                Integer num2 = num.pop();
                num.push(num2 + num1);
            } else if ("-".equals(token)) {
                Integer num1 = num.pop();
                Integer num2 = num.pop();
                num.push(num2 - num1);
            } else if ("*".equals(token)) {
                Integer num1 = num.pop();
                Integer num2 = num.pop();
                num.push(num2 * num1);
            } else if ("/".equals(token)) {
                Integer num1 = num.pop();
                Integer num2 = num.pop();
                num.push(num2 / num1);
            } else {
                num.push(Integer.valueOf(token));
            }
        }
        return num.pop();
    }
}