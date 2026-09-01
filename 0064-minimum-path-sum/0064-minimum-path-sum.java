class Solution {
    public int minPathSum(int[][] grid) {
        // int[][] dp = new int[grid.length][grid[0].length];
        // for (int[] x: dp) Arrays.fill(x, -1);
        // return f(grid, 0,0, dp);

        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for (int[] x: dist) Arrays.fill(x, Integer.MAX_VALUE);
        dist[0][0] = grid[0][0];

        PriorityQueue<Pair<int[], Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        pq.add(new Pair<>(new int[]{0, 0}, grid[0][0]));

        while (!pq.isEmpty()) {
            Pair<int[], Integer> cur = pq.poll();
            int i = cur.getKey()[0];
            int j = cur.getKey()[1];
            int wt = cur.getValue();
            if (wt > dist[i][j]) continue;
            
            if (i + 1 < m) {
                int curwt = wt + grid[i+1][j];
                if (curwt < dist[i+1][j]) {
                    dist[i+1][j] = curwt;
                    pq.add(new Pair<>(new int[]{i+1, j}, curwt));
                }
            }
            if (j + 1 < n) {
                int curwt = wt + grid[i][j + 1];
                if (curwt < dist[i][j + 1]) {
                    dist[i][j + 1] = curwt;
                    pq.add(new Pair<>(new int[]{i, j + 1}, curwt));
                }
            }
        }
        return dist[m - 1][n - 1];
    }
    int f(int[][] grid, int i, int j, int[][] dp) {
        if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = grid[i][j] + Math.min( f(grid, i + 1, j, dp), f(grid, i, j+1, dp) );
    }
    
}