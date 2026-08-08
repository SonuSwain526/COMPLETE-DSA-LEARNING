class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int c = 0;

        boolean[][] rotted = new boolean[m][n];
        
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    c++;
                    if (grid[i][j] == 2) {
                        q.add(new Pair<>(i, j));
                        rotted[i][j] = true;
                    }
                }
            }
        }

        int ans = 0;
        
        while (!q.isEmpty()) {

            int size = q.size();

            boolean curRot = false;

            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> cur = q.poll();
                int curI = cur.getKey();
                int curJ = cur.getValue();

                if (curI + 1 < m && !rotted[curI + 1][curJ] && grid[curI + 1][curJ] != 0) {
                    rotted[curI + 1][curJ] = true;
                    q.add (new Pair<>(curI + 1, curJ));
                    curRot = true;
                }
                if (curJ + 1 < n && !rotted[curI][curJ + 1] && grid[curI][curJ + 1] != 0) {
                    rotted[curI][curJ + 1] = true;
                    q.add (new Pair<>(curI, curJ + 1));
                    curRot = true;
                }
                if (curI - 1 >= 0 && !rotted[curI - 1][curJ] && grid[curI - 1][curJ] != 0) {
                    rotted[curI - 1][curJ] = true;
                    q.add (new Pair<>(curI - 1, curJ));
                    curRot = true;
                }
                if (curJ - 1 >= 0 && !rotted[curI][curJ - 1] && grid[curI][curJ - 1] != 0) {
                    rotted[curI][curJ - 1] = true;
                    q.add (new Pair<>(curI, curJ - 1));
                    curRot = true;
                }
            }
            if (curRot) ans++;
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && !rotted[i][j]) return -1;
            }
        }

        return ans;
    }
}