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
    public int removeStones(int[][] stones) {
        int r = 0, c = 0;

        for (int[] cur: stones) {
            r = Math.max(r, cur[0]);
            c = Math.max(c, cur[1]);
        }

        DSU dsu = new DSU(r + c + 2);

        Set<Integer> set1 = new HashSet<>();

        for (int[] cur: stones) {
            dsu.union(cur[0], cur[1] + r+1);
            set1.add(cur[0]);
            set1.add(cur[1] + r + 1);
        }
        Set<Integer> x = new HashSet<>();
        for (int cur: set1) {
            x.add(dsu.findP(cur));
        }

        return stones.length - x.size();
    }
}