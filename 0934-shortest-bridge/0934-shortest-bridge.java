class Solution {
    public int shortestBridge(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        boolean t = false;
        
        for (int i = 0; i < m && !t; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    t = true;
                    dfs(i, j, vis, grid);
                    break;
                }
            }
        }
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j]) {
                    q.add(new Pair<>(i, j));
                }
            }
            // if (t) break;
        }
        // for (boolean[] z: vis)
        //     System.out.println(Arrays.toString(z));
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Pair<Integer, Integer> cur = q.poll();
                int i = cur.getKey();
                int j = cur.getValue();
                // if (grid[i][j] == 1) {
                //     return level;
                // }

                int[] x = {0, 0, 1, -1};
                int[] y = {1, -1, 0, 0};

                for (int k = 0; k < 4; k++) {
                    int inI = i + x[k];
                    int inJ = j + y[k];
                    if (inI < grid.length && inI >= 0 && inJ < grid[0].length && inJ >= 0) {
                        if (!vis[inI][inJ]) {
                            if (grid[inI][inJ] == 1) {
                                return level;
                            }
                            vis[inI][inJ] = true;
                            q.add(new Pair<>(inI, inJ));
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
    void dfs(int i, int j, boolean[][] vis, int[][] grid) {
        vis[i][j] = true;

        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int inI = i + x[k];
            int inJ = j + y[k];
            if (inI < grid.length && inI >= 0 && inJ < grid[0].length && inJ >= 0) {
                if (!vis[inI][inJ] && grid[inI][inJ] == 1) {
                    dfs(inI, inJ, vis, grid);
                }
            }
        }
    }
}