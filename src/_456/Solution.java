package _456;

import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {

        if (nums.length <= 2) {
            return false;
        }
        // 栈中保存的是最大值
        Stack<Integer> stack = new Stack<>();
        // second为第二大的值
        int second = Integer.MIN_VALUE;
        stack.push(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i++) {

            // 如果有比second小的数出现，说明符合要求，返回true
            if (nums[i] < second) {
                return true;
            } else {
                // 否则，说明当前的值比第二的大，也就是当前值是最大值。
                // 应该把当前值放到栈中，但是在这之前要更新second，把比当前值小的最大值（第二大的值）给second
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    second = Math.max(second, stack.pop());
                }
                stack.push(nums[i]);
            }
        }
        // 遍历整个数组，也没有发现当前值小于第二大的值，返回false
        return false;
    }
}