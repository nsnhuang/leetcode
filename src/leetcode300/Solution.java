package leetcode300;

import java.util.Arrays;

class Solution {
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        int max = 1;
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxval = Math.max(dp[j], maxval);
                }
            }
            dp[i] = maxval + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    /**
     * 动态规划 和 二分搜索
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int len = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);

            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}