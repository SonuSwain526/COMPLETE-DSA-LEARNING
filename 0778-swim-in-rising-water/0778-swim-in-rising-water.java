class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid.length;

        int[][] dist = new int[m][n];
        for (int[] cur: dist) Arrays.fill(cur, Integer.MAX_VALUE);
        dist[0][0] = grid[0][0];
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};

        PriorityQueue<Pair<int[], Integer>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.getValue(), b.getValue())
        );
        pq.add(new Pair<>(new int[]{0, 0}, dist[0][0]));

        while (!pq.isEmpty()) {
            Pair<int[], Integer> cur = pq.poll();
            int i = cur.getKey()[0];
            int j = cur.getKey()[1];
            int wt = cur.getValue();

            for (int k = 0; k < 4; k++) {
                int inI = x[k] + i;
                int inJ = y[k] + j;

                if (inI >= 0 && inI < m && inJ >= 0 && inJ < n){
                    int curw = Math.max(wt, grid[inI][inJ]);
                    // int curw = wt + grid[inI][inJ] - grid[i][j];
                    if (curw < dist[inI][inJ]) {
                        dist[inI][inJ] = curw;
                        pq.add(new Pair<>(new int[]{inI, inJ}, curw));
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}