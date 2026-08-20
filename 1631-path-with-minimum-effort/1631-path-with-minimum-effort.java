class Solution {
    public int minimumEffortPath(int[][] h) {
        int m = h.length;
        int n = h[0].length;
        PriorityQueue<Pair<int[], Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        int[][] arr = new int[m][n];
        for (int[] row : arr) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        arr[0][0] = 0;

        pq.add(new Pair<>(new int[]{0, 0}, 0));

        while (!pq.isEmpty()) {
            Pair<int[], Integer> cur = pq.poll();
            
            int i = cur.getKey()[0];
            int j = cur.getKey()[1];
            int max = cur.getValue();

            int[] x = {0, 0, 1, -1};
            int[] y = {1, -1, 0, 0};
            for (int k = 0; k < 4; k++) {
                int inI = i + x[k];
                int inJ = j + y[k];
                
                if (inI >= 0 && inI < m && inJ >= 0 && inJ < n) {
                    int curM = Math.max( max, Math.abs(h[i][j] - h[inI][inJ]) );
                    if (curM < arr[inI][inJ]) {
                        pq.add(new Pair<>(new int[]{inI, inJ}, curM ));
                        arr[inI][inJ] = curM;
                    }
                } 
            }
        } 
        return arr[m - 1][n - 1];  
    }
}