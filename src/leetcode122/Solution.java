package leetcode122;

class Solution {
    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        return 0;
    }
}