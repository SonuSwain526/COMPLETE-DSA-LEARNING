class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        PriorityQueue<Pair<int[], Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        pq.add(new Pair<>(new int[]{0, 0}, 0));
        int[][] time = new int[m][n];
        for (int[] x: time) Arrays.fill(x, Integer.MAX_VALUE);
        time[0][0] = 0;

        int[] x = {0 ,0, 1, -1};
        int[] y = {1, -1, 0, 0};

        while (!pq.isEmpty()) {
            Pair<int[], Integer> cur = pq.poll();
            int i = cur.getKey()[0];
            int j = cur.getKey()[1];
            int cost = cur.getValue();

            if (cost > time[i][j]) continue;
            if (i == m - 1 && j == n - 1) return cost;

            for (int k = 0; k < 4; k++) {
                int inI = i + x[k];
                int inJ = j + y[k];

                if (inI >= 0 && inI < m && inJ >= 0 && inJ < n) {
                    int curcost = Math.max(cost, moveTime[inI][inJ]) + 1;
                    if (curcost < time[inI][inJ]) {
                        time[inI][inJ] = curcost;
                        pq.add(new Pair<>(new int[]{inI, inJ}, curcost));
                    }
                }
            }
        }
        return -1;
    }
}