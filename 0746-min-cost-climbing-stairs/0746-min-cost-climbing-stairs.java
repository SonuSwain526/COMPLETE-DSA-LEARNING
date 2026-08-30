class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(dp(cost, dp, 0), dp(cost, dp, 1) );
    }
    int dp(int[] cost, int[] dp, int i) {
        if (i >= cost.length) return 0;
        
        if (dp[i] != -1) return dp[i];
        int x = dp(cost, dp, i + 2);
        int y = dp(cost, dp, i+1);

        return dp[i] = cost[i] + Math.min(x, y);

    }
}