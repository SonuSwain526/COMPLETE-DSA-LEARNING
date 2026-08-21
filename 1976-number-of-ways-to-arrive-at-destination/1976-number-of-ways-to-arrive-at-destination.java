class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] x: roads) {
            long u = (long) x[0];
            long v = (long) x[1];
            long c = (long) x[2];

            adj.get((int)u).add(new long[]{v, c});
            adj.get((int)v).add(new long[]{u, c});
        }
        long[] ans = new long[n];
        long[] ways = new long[n];
        Arrays.fill(ans, Long.MAX_VALUE);
        ans[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair<Long, Long>> q = new PriorityQueue<>(
            (a, b) -> Long.compare(a.getValue(), b.getValue())
        );
        // Queue<Pair<Long, Long>> q = new LinkedList<>();
        q.add(new Pair<>(0L, 0L));

        long MOD =(long) 1e9 + 7;

        while (!q.isEmpty()) {
            Pair<Long, Long> cur = q.poll();
            long cost = cur.getValue();
            long node = cur.getKey();

            for (long[] in: adj.get((int)node)) {
                long curCost = cost + in[1];
                if (curCost < ans[(int)in[0]]) {
                    ans[(int)in[0]] = curCost;
                    q.add(new Pair<>(in[0], curCost));
                    ways[(int)in[0]] = ways[(int)node];
                }
                else if (curCost == ans[(int)in[0]]) ways[(int)in[0]] = (ways[(int)node] + ways[(int)in[0]] ) % MOD;
                
            }
        }
        return (int) (ways[n - 1] % MOD);
    }
}