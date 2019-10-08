package leetcode322;

import java.util.Arrays;

class Solution {
    /**
     * 没通过。。。。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount];
        for (int i = 0; i < amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i == coin) {
                    dp[i] = 1;
                }else if (i - coin > 0) {
                    dp[i] = Math.min(min, dp[i - coin]);
                }
            }
            dp[i] += 1;
        }
        return dp[amount - 1];
    }


    /**
     * 官方题解
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}