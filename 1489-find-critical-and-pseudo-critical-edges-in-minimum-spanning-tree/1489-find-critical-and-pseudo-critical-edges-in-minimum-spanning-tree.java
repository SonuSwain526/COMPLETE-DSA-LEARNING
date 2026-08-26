class Solution {
    class DSU{
        int[] size;
        int[] p;
        
        DSU(int n) {
            size = new int[n];
            p = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) p[i] = i;
        }

        int findP(int u) {
            if (u == p[u]) return u; 
            return p[u] = findP(p[u]);
        }

        boolean union(int u, int v) {
            int pu = findP(u);
            int pv = findP(v);

            if (pu == pv) return false;
            if (size[pu] > size[pv]) {
                size[pu] += size[pv];
                p[pv] = pu;
            }else {
                size[pv] += size[pu];
                p[pu] = pv;
            }
            return true ;
        }
    }

    int kruskal(int[][] adj, int skip, int force, int V) {
        int wt = 0;
        int el = 0;

        DSU dsu = new DSU(V);

        if (force != -1) {
            dsu.union(adj[force][0], adj[force][1]);
            wt += adj[force][2];
            el++;
        }

        for (int i = 0; i < adj.length; i++) {
            int u = adj[i][0];
            int v = adj[i][1];
            int curw = adj[i][2];

            if (i == skip || i == force) continue;

            if (dsu.union(u, v)) {
                wt += curw;
                el++;

                if (el == V - 1) return wt;
            }
        }
        if (el != V-1) return Integer.MAX_VALUE;
        return wt;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        List<Integer> pc = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {

            edges[i] = Arrays.copyOf(edges[i], 4);

            edges[i][3] = i;
        }

        Arrays.sort(
            edges,
            (a, b) -> Integer.compare(a[2], b[2])
        );

        int owt = kruskal(edges, -1, -1, n);
for (int i = 0; i < edges.length; i++) {

    // Remove edge
    int skipWeight = kruskal(edges, i, -1, n);

    if (skipWeight > owt) {

        // Definitely critical
        c.add(edges[i][3]);

    } else {

        // Only non-critical edges can be pseudo-critical
        int forceWeight = kruskal(edges, -1, i, n);

        if (forceWeight == owt)
            pc.add(edges[i][3]);
    }
}

        return Arrays.asList(c, pc);
    }
}
















