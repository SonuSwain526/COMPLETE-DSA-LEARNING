class Solution {
    public int numEnclaves(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) dfs (grid, vis, i, 0);
            if (grid[i][m - 1] == 1) dfs (grid, vis, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) dfs (grid, vis, 0, i);
            if (grid[n - 1][i] == 1) dfs (grid, vis, n - 1, i);
        }

        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) c++;
            }
        }
        return c;
    }

    void dfs (int[][] grid, boolean[][] vis, int i, int j) {

        if (vis[i][j]) return;
        if (grid[i][j] == 0) return;

        vis[i][j] = true;

        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};

        for (int k = 0; k < 4; k++) {
            int curI = x[k] + i;
            int curJ = y[k] + j;

            if (curI < vis.length && curI >= 0 &&
                curJ < vis[0].length && curJ >= 0 &&
                grid[curI][curJ] == 1
            ){
                dfs (grid, vis, curI, curJ);
            }
        }

    }
}