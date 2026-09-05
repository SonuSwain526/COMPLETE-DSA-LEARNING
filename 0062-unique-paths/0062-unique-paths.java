class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i- 1 >= 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j - 1 >= 0) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[m - 1][n-1];
        // for (int[] dpp: dp) Arrays.fill(dpp, -1);
        // return helper(m, n, m - 1, n - 1, dp);
    }
    int helper(int m, int n, int i, int j, int[][] dp) {
        // if (i >= m || j >= n) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        if (i - 1 >= 0) {
            ans =  helper(m, n, i - 1, j, dp);
        }
        if ( j - 1 >= 0) {
            ans +=  helper(m, n, i, j - 1, dp);
        }
        return dp[i][j] = ans;
    }
}