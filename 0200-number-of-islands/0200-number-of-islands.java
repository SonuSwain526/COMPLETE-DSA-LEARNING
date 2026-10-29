class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;

        boolean[][] b = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!b[i][j] && grid[i][j] == '1') {
                    ans++;
                    // System.out.println("hi");
                    bfs(grid, i, j, b);
                }
            }
        }
        return ans;
    }
    void bfs(char[][] grid, int si, int sj, boolean[][] b) {
        int m = grid.length;
        int n = grid[0].length;
        Stack<Pair<Integer, Integer>> st = new Stack<>();
        st.push(new Pair<>(si, sj));
        b[si][sj] = true;
        // System.out.println("hi");
        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};

        while (!st.isEmpty()) {
            int size = st.size();
            while (size-- > 0) {
                Pair<Integer, Integer> cur = st.pop();
                int curi = cur.getKey();
                int curj = cur.getValue();
                for (int i = 0; i < 4; i++) {
                    int inI = curi + x[i];
                    int inJ = curj + y[i];

                    if (inI > -1 && inI < m && inJ > -1 && inJ < n && grid[inI][inJ] == '1' && !b[inI][inJ]) {
                        b[inI][inJ] = true;
                        st.push(new Pair<>(inI, inJ));
                    }
                }
            }
        }
    }
}