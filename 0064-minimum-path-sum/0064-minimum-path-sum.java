class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] x: dp) Arrays.fill(x, -1);
        return f(grid, 0,0, dp);
    }
    int f(int[][] grid, int i, int j, int[][] dp) {
        if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = grid[i][j] + Math.min( f(grid, i + 1, j, dp), f(grid, i, j+1, dp) );
    }
    
}