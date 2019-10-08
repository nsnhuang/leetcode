package leetcode188;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxProfit(2, new int[]{3,2,6,5,0,3});
        System.out.println(i);
    }

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            //相当于无数次交易了，
            int num = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    num += prices[i + 1] - prices[i];
                }
            }
            return num;
        }
        k ++;
        int length = prices.length;
        int[][][] mp = new int[length][k][2];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            mp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < k; j++) {
                mp[i][j][0] = Math.max(mp[i - 1][j][0], mp[i - 1][j][1] + prices[i]);
                mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j - 1][0] - prices[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            if (mp[length - 1][i][0] > max) {
                max = mp[length - 1][i][0];
            }
        }
        return max;
    }

    public int maxProfit2(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            //相当于无数次交易了，
            int num = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i] < prices[i + 1]) {
                    num += prices[i + 1] - prices[i];
                }
            }
            return num;
        }
        k = k + 1;
        int max = 0;
        int n = prices.length;
        int[][][] MP = new int[n][k][2];//三维：天数，交易次数，是否持有股票
        for (int i = 0; i < k; i++) {
            MP[0][i][1] = -prices[0];//设定买入算交易一次
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k; j++) {
                MP[i][j][0] = Math.max(MP[i - 1][j][1] + prices[i], MP[i - 1][j][0]);
                MP[i][j][1] = Math.max(MP[i - 1][j - 1][0] - prices[i], MP[i - 1][j][1]);
                max = Math.max(MP[i][j][0], max);
            }
        }
        return max;

    }
}