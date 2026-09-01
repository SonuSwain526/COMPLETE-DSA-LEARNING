class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] x: dp) Arrays.fill(x, -1);
        return helper(obstacleGrid, 0, 0, dp);
    }
    int helper(int[][] x, int i, int j, int[][] dp) {
        if (i >= x.length || j >= x[0].length) return 0;
        if (x[i][j] == 1) return 0;
        if (i == x.length - 1 && j == x[0].length - 1) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = helper(x, i + 1, j, dp) + helper(x, i, j+1, dp);
    }
}