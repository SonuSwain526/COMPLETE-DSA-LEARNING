class Solution {
    public int climbStairs(int n) {
        if (n < 2) return 1; 
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dphepler(n, dp);
        return dp[n];
    }
    int dphepler(int n, int[] dp) {
        if (n < 2) return 1;
        if (dp[n] != -1) return dp[n];
        return dp[n] = dphepler(n - 1, dp) + dphepler(n-2, dp);
    }
}