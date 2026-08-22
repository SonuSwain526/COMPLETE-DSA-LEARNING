class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair<Integer,Integer>> s = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) s.add(new Pair<>(i, j));
            }
        }
        if (s.isEmpty()) return -1;
        if (s.size() == n * m) return -1;

        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};

        int level = 1;

        while (!s.isEmpty()) {
            int size = s.size();

            while(size-- > 0) {
                Pair<Integer, Integer> cur = s.poll();
                int i = cur.getKey();
                int j = cur.getValue();

                for (int k = 0; k < 4; k++) {
                    int inI = x[k] + i;
                    int inJ = y[k] + j;
                    if (inI < m && inI >= 0 && inJ < n && inJ >= 0 && grid[inI][inJ] == 0) {
                        grid[inI][inJ] = level;
                        s.add(new Pair<>(inI, inJ));
                    }
                }
            }
            level++;
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, grid[i][j]);
            }
        }
        // if (ans == 0) return -1;
        return ans;
    }
}