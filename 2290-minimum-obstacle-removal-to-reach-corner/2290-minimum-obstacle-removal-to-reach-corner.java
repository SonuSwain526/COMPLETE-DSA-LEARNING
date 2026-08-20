class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<Pair<int[], Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        pq.add(new Pair<>(new int[]{0 , 0}, 0));
        int[][] h = new int[m][n];
        for (int[] row : h) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        h[0][0] = 0;

        int[] x = {0, 0, 1, -1};
        int[] y = {1, -1, 0, 0};

        while (!pq.isEmpty()) {
            Pair<int[], Integer> cur = pq.poll();
            int i = cur.getKey()[0];
            int j = cur.getKey()[1];
            int ob = cur.getValue();

            if (ob > h[i][j]) continue;
            if (i == m - 1 && j == n - 1) return ob;

            for (int k = 0; k < 4; k++) {
                int inI = i + x[k];
                int inJ = j + y[k] ;
                if ( inI < m && inI >= 0 && inJ < n && inJ >= 0){
                    if (ob + grid[inI][inJ] < h[inI][inJ]) {
                        h[inI][inJ] = ob + grid[inI][inJ];
                        pq.add(new Pair<>(new int[]{inI, inJ}, h[inI][inJ]));
                    }
                }
            }
        }
        return -1;
    }
}