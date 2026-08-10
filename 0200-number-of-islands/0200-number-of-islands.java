class Solution {
    public int numIslands(char[][] grid) {

        int m = grid.length, n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];

        int c = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    dfs (i, j, vis, grid);
                    c++;
                }
            }
        }

        return c;
    }

    void dfs (int i,int j, boolean[][] vis, char[][] grid) {

        if (vis[i][j]) return;
        if (grid[i][j] == '0') return;

        vis[i][j] = true;

        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int curI = x[k] + i;
            int curJ = y[k] + j;

            if (curI < vis.length && curJ < vis[0].length &&
                curI >= 0 && curJ >= 0 &&
                !vis[curI][curJ] && grid[curI][curJ] == '1'
            ) dfs (curI, curJ, vis, grid);
        }

    }
}