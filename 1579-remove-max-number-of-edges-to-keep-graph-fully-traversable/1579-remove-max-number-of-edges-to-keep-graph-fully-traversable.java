class Solution {
    class DSU{
        int[] size;
        int[] p;

        DSU(int n) {
            size = new int[n + 1];
            p = new int[n + 1];
            Arrays.fill(size, 1);
            for (int i = 0; i < n + 1; i++) p[i] = i;
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
                p[pv] = pu;
                size[pu] += size[pv];
            }else {
                p[pu] = pv;
                size[pv] += size[pu];
            }
            return true;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        int c = 0;
        int alel = 0; 
        int boel = 0;

        for (int[] cur: edges) {
            int u = cur[1];
            int v = cur[2];
            if (cur[0] == 1) {
                if (!alice.union(u, v)) {
                    c++;
                }else alel++;
            }else if (cur[0] == 2) {
                if (!bob.union(u, v)) {
                    c++;
                }else boel++;
            }else {
                if (!alice.union(u, v)) {
                    c++;
                }else alel++;
                if (!bob.union(u, v)) {
                    c++;
                }else boel++;
            }
        }
        if (alel != n - 1 || boel != n-1) return -1;
        return c;
    }
}











