package stackqueue.leetcode2390001;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 大顶堆
 */
class Solution {

    private Queue<Integer> maxHeap;

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        if (nums == null || n < 2) {
            return nums;
        }

        int[] result  = new int[n - k + 1];
        maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);

        int count = 0;
        for (int i = 0; i < n; i++) {

            maxHeap.offer(nums[i]);
            if (i >= k - 1 && i <= n -1) {
                result[count ++] = maxHeap.peek();
                maxHeap.remove(nums[i - k + 1]);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}