package _324;

import java.util.Arrays;

class Solution {

    public void wiggleSort(int[] nums) {

        // 排序
        Arrays.sort(nums);
        int len = nums.length;
        int[] smaller = new int[len / 2 + len % 2];
        int[] bigger = new int[len / 2];

        // 复制
        System.arraycopy(nums, 0, smaller, 0, smaller.length);
        System.arraycopy(nums, smaller.length, bigger, 0, bigger.length);

        // 穿插
        int i = 0;
        for (; i < len / 2; i++) {
            nums[2 * i] = smaller[smaller.length - 1 - i];
            nums[2 * i + 1] = bigger[bigger.length - 1 - i];
        }
        if (len % 2 != 0) {
            nums[2 * i] = smaller[smaller.length - 1 - i];
        }
    }
}