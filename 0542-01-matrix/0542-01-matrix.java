class Solution {

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] dist = new int[n][m];

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        // Initialize distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.add(new Pair<>(i, j));
                } 
                else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // Multi-source BFS
        while (!q.isEmpty()) {

            Pair<Integer, Integer> cur = q.poll();

            int i = cur.getKey();
            int j = cur.getValue();

            for (int[] dir : directions) {

                int ni = i + dir[0];
                int nj = j + dir[1];

                // Out of bounds
                if (ni < 0 || ni >= n || nj < 0 || nj >= m)
                    continue;

                // Found a shorter distance
                if (dist[ni][nj] > dist[i][j] + 1) {

                    dist[ni][nj] = dist[i][j] + 1;

                    q.add(new Pair<>(ni, nj));
                }
            }
        }

        return dist;
    }
}