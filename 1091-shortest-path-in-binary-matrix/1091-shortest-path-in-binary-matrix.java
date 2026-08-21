class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1) return -1;

        PriorityQueue<Pair<int[], Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        pq.add(new Pair<>(new int[]{0, 0}, 0));
        int[][] dist = new int[m][n];
        for (int[] row: dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        int[] x = {0, 0, 1, -1, -1, -1, 1, 1};
        int[] y = {1, -1, 0, 0, -1, 1, -1, 1};

        while (!pq.isEmpty()) {
            Pair<int[], Integer> cur = pq.poll();
            int i = cur.getKey()[0];
            int j = cur.getKey()[1];
            int cost = cur.getValue();

            if (cost > dist[i][j]) continue;
            if (i == m - 1 && j == n - 1) return cost + 1;

            for (int k = 0; k < 8; k++) {
                int inI = x[k] + i;
                int inJ = y[k] + j;

                if (inI < m && inI >= 0 &&
                    inJ < n && inJ >= 0 && grid[inI][inJ] == 0) {
                        int curCost = cost + 1;
                        if (curCost < dist[inI][inJ]) {
                            dist[inI][inJ] = curCost;
                            pq.add(new Pair<>(new int[]{inI, inJ}, curCost));
                        }
                    }
            }

        }
        return -1;
    }
}