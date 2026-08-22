class Solution {
    public int nearestExit(char[][] maze, int[] e) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int[][] d = new int[m][n];
        d[e[0]][e[1]] = Integer.MAX_VALUE;

        q.add(new Pair<>(e[0], e[1]));

        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                Pair<Integer, Integer> cur = q.poll();
                int i = cur.getKey();
                int j = cur.getValue();
                // if (i == e[0] && 0 == e[1]) continue;

                for (int k = 0; k < 4; k++) {
                    int inI = x[k] + i;
                    int inJ = y[k] + j;
                    if (inI < m && inI >= 0 && inJ < n && inJ >= 0 && maze[inI][inJ] == '.' && d[inI][inJ] == 0) {
                        d[inI][inJ] = level;
                        q.add(new Pair<>(inI, inJ));
                    }
                }
            }
            level++;
        }
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            if (!(i == e[0] && e[1] == 0) &&
                maze[i][0] == '.' && d[i][0] != 0)
                ans = Math.min(ans, d[i][0]);

            if (!(i == e[0] && e[1] == n - 1) &&
                maze[i][n - 1] == '.' && d[i][n - 1] != 0)
                ans = Math.min(ans, d[i][n - 1]);
        }

        for (int i = 0; i < n; i++) {
            if (!(e[0] == 0 && i == e[1]) &&
                maze[0][i] == '.' && d[0][i] != 0)
                ans = Math.min(ans, d[0][i]);

            if (!(e[0] == m - 1 && i == e[1]) &&
                maze[m - 1][i] == '.' && d[m - 1][i] != 0)
                ans = Math.min(ans, d[m - 1][i]);
        }
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}