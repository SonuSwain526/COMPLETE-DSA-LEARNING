class Solution {
    public int coinChange(int[] coins, int amount) {


        int[][] dp = new int[coins.length][amount + 1];
        for (int[] x: dp) Arrays.fill(x, Integer.MAX_VALUE);


        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) dp[0][i] = (i / coins[0]);
        }


        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int take = Integer.MAX_VALUE; 
                if (j >= coins[i]) {
                    if (dp[i][j - coins[i]] == Integer.MAX_VALUE) take = Integer.MAX_VALUE;
                    else take = 1 + dp[i][j - coins[i]];
                }
                int skip = dp[i - 1][j];
                dp[i][j] = Math.min(take, skip);
            }
        }


	  return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount];


        // int x = f(coins, amount, coins.length - 1, dp);


        // return x >= Integer.MAX_VALUE ? -1 : x;
    }
    int f(int[] c, int t, int i, int[][] dp) {
        if (t == 0) return 0;
        if (i == 0) {
            if (t % c[i] == 0) return t / c[i];
            return Integer.MAX_VALUE;
        }
        if (i < 0 || t < 0) return Integer.MAX_VALUE;


        if (dp[i][t] != Integer.MAX_VALUE) return dp[i][t];


        int skip = f(c, t, i - 1, dp);
        int take = Integer.MAX_VALUE;
        if (t >=  c[i]) {
            int res = f(c, t - c[i], i, dp);
            if (res != Integer.MAX_VALUE) {
                take = 1 + res;
            }
        }
        return dp[i][t] = Math.min(skip, take);
    }


}

