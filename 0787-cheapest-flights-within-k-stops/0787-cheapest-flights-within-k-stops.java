class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] cur: flights) adj.get(cur[0]).add(new int[]{cur[1], cur[2]});

        // boolean[] b = new boolean[n];
        // b[src] = true;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(src, 0));
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) cost[i] = Integer.MAX_VALUE;
        cost[src] = 0;
        // int ans = Integer.MAX_VALUE;

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair<Integer, Integer> x = q.poll();
                // if (x.getKey() == dst) ans = Math.min(ans, cost[x]);
                for (int[] cur: adj.get(x.getKey())) {
                    int c = cur[1];
                    int node = cur[0];

                    if (x.getValue() + c < cost[node] && level <= k) {
                        cost[node] = x.getValue() + c;
                        q.add(new Pair<>(node, cost[node]));
                    }
                    
                }
            }
            level++;
        }
        // while (!q.isEmpty()){
        //     if (q.poll() == dst) ans = Math.min(ans, cost[dst]);
        // }
        if (cost[dst] == Integer.MAX_VALUE) return -1;
        return cost[dst];
    }
}