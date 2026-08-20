class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair<Integer, Double>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int p = 0;
        for (int[] cur: edges) {
            adj.get(cur[0]).add(new Pair<>(cur[1], succProb[p]));
            adj.get(cur[1]).add(new Pair<>(cur[0], succProb[p]));
            p++;
        }
        // System.out.print(adj);
        double[] prob = new double[n];
        for (int i = 0; i< n; i++) prob[i] = 0;
        prob[start_node] = 1;
        // prob[start_node] = 0;
        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.getValue(), a.getValue())
        );
        pq.add(new Pair<>(start_node, 1.0));

        while (!pq.isEmpty()){
            Pair<Integer, Double> cur = pq.poll();
            int node = cur.getKey();
            double curp = cur.getValue();
            
            if (node == end_node) return curp;
            if (curp < prob[node]) continue;

            for (Pair<Integer, Double> ng: adj.get(node)) {
                double px = curp * ng.getValue();
                if (px > prob[ng.getKey()]) {
                    prob[ng.getKey()] = px;
                    pq.add(new Pair<>(ng.getKey(), px));
                }
            }
        }
        // if (prob[end_node] == -1) return 0;
        return prob[end_node];
    }
}