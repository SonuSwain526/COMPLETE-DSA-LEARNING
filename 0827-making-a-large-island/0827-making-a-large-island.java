class Solution {
    class DSU{
        int[][] size;
        Pair<Integer, Integer>[][] p;

        DSU(int m, int n, int[][] grid) {
            size = new int[m + 1][n + 1];
            p = new Pair[m + 1][n + 1];
            // for (int[] cur: size) Arrays.fill(cur, 1);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    p[i][j] = new Pair<>(i, j);
                    size[i][j] = grid[i][j] == 1 ? 1 : 0;
                }
            }
        }

        Pair<Integer, Integer> findP(int i, int j) {
            if (i == p[i][j].getKey() && j == p[i][j].getValue())
                return p[i][j];

            return p[i][j] = findP(
                p[i][j].getKey(),
                p[i][j].getValue()
            );
        }

        boolean union(Pair<Integer, Integer> u, Pair<Integer, Integer> v) {
            Pair<Integer, Integer> pu = findP(u.getKey(), u.getValue());
            Pair<Integer, Integer> pv = findP(v.getKey(), v.getValue());

            if (pu.getKey() == pv.getKey() &&
                pu.getValue() == pv.getValue())
                return false;
                
            if (size[pu.getKey()][pu.getValue()] > size[pv.getKey()][pv.getValue()]) {
                p[pv.getKey()][pv.getValue()] = pu;
                size[pu.getKey()][pu.getValue()] += size[pv.getKey()][pv.getValue()];
            }else {
                p[pu.getKey()][pu.getValue()] = pv;
                size[pv.getKey()][pv.getValue()] += size[pu.getKey()][pu.getValue()];
            }
            return true;
        }
    }
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        DSU dsu = new DSU(m, n, grid);

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1) bfs(i, j, vis, q, grid, dsu);
            }
        }

        int ans = 0;
        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int cur = 1; // flipped 0 becomes 1

                    Set<String> seen = new HashSet<>();

                    for (int k = 0; k < 4; k++) {
                        int inI = x[k] + i;
                        int inJ = y[k] + j;

                        if (inI < m && inI >= 0 && inJ >= 0 && inJ < n
                                && grid[inI][inJ] == 1) {

                            Pair<Integer, Integer> root = dsu.findP(inI, inJ);

                            String id = root.getKey() + "," + root.getValue();

                            if (!seen.contains(id)) {
                                cur += dsu.size[root.getKey()][root.getValue()];
                                seen.add(id);
                            }
                        }
                    }

                    ans = Math.max(ans, cur);
                }
            }
        }
        if (ans == 0) return n * m;
        return ans;
    }
    void bfs(int i, int j, boolean[][] vis, Queue<int[]> q, int[][] grid, DSU dsu) {
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;
        Pair<Integer, Integer> par = new Pair<>(i, j);
        q.add(new int[]{i, j});

        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int a = 0; a < size; a++) {
                int[] cure = q.poll();
                
                for (int b = 0; b < 4; b++) {
                    int inI = x[b] + cure[0];
                    int inJ = y[b] + cure[1];

                    if (inI < m && inI >= 0 && inJ >= 0 && inJ < n && grid[inI][inJ] == 1) {
                        if (!vis[inI][inJ]) {
                            vis[inI][inJ] = true;
                            dsu.union(par, new Pair<>(inI, inJ));
                            q.add(new int[]{inI, inJ});
                        }
                    }
                }
            }
        }
    }
}















