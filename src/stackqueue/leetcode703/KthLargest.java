package stackqueue.leetcode703;

import java.util.PriorityQueue;

class KthLargest {

    final PriorityQueue<Integer> minHeap;

    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }
}