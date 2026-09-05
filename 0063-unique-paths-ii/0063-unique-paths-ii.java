class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0; 
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && obstacleGrid[i-1][j] != 1) dp[i][j] = dp[i-1][j];
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] != 1) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
        // for (int[] x: dp) Arrays.fill(x, -1);
        // return helper(obstacleGrid, 0, 0, dp);
    }
    int helper(int[][] x, int i, int j, int[][] dp) {
        if (i >= x.length || j >= x[0].length) return 0;
        if (x[i][j] == 1) return 0;
        if (i == x.length - 1 && j == x[0].length - 1) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = helper(x, i + 1, j, dp) + helper(x, i, j+1, dp);
    }
}