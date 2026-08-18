class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i= 0; i <= n; i++) adj.add(new ArrayList<>());
        
        for (int[] x: times) {
            adj.get(x[0]).add(new int[]{x[1], x[2]});
        }
        int[] dist = new int[n+1];
        for (int i = 0; i <= n; i++) dist[i] = Integer.MAX_VALUE;
        dist[k] = 0;
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] x = pq.poll();

            if (dist[x[0]] < x[1]) continue;

            for (int[] cur: adj.get(x[0])) {
                int node = cur[0];
                int distt = cur[1];
                if (dist[x[0]] + distt < dist[node]) {
                    dist[node] = dist[x[0]] + distt;
                    pq.add(new int[]{node, dist[node]});
                }
            }
        }
        // System.out.println(Arrays.toString(dist));
        int ans = -1;
        int c = 0;
        for (int i: dist) {
            if (c != 0 && i == Integer.MAX_VALUE) return -1;
            if(i != Integer.MAX_VALUE) ans = Math.max(i, ans);
            c++;
        }

        return ans;
    }

    // void topo(boolean[] vis, List<List<int[]>> adj, int src, Stack<Integer> st) {
    //     vis[src] = true;

    //     for (int[] cur: adj.get(src)) {
    //         if (!vis[cur[0]]) {
    //             topo(vis, adj, cur[0], st);
    //         }
    //     }
    //     st.push(src);
    // }
}