package leetcode2390002;

import java.util.ArrayDeque;

/**
 * 双端队列
 */
class Solution {

    private ArrayDeque<Integer> deq = new ArrayDeque<>();
    private int[] nums;

    private void cleanDeque(int i, int k) {
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }

        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        // 非法检查
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        this.nums = nums;
        int maxIdx = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(i, k);
            deq.addLast(i);
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int[] output = new int[n - k + 1];
        output[0] = nums[maxIdx];

        for (int i = k; i < n; i++) {
            cleanDeque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }

        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}