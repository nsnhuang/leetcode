package leetcode121;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > res) {
                res = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        if (res < 0) {
            return 0;
        }
        return res;
    }
}