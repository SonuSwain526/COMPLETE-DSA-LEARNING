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
    }public boolean[] distanceLimitedPathsExist(
        int n,
        int[][] edgeList,
        int[][] queries) {

    boolean[] ans = new boolean[queries.length];

    // Add original query index
    for (int i = 0; i < queries.length; i++) {
        queries[i] = Arrays.copyOf(queries[i], 4);
        queries[i][3] = i;
    }

    // Sort edges by weight
    Arrays.sort(
        edgeList,
        (a, b) -> Integer.compare(a[2], b[2])
    );

    // Sort queries by limit
    Arrays.sort(
        queries,
        (a, b) -> Integer.compare(a[2], b[2])
    );

    DSU dsu = new DSU(n);

    int e = 0;

    for (int i = 0; i < queries.length; i++) {

        int u = queries[i][0];
        int v = queries[i][1];
        int limit = queries[i][2];
        int originalIndex = queries[i][3];

        // Add ALL edges having weight < limit
        while (e < edgeList.length &&
               edgeList[e][2] < limit) {

            dsu.union(
                edgeList[e][0],
                edgeList[e][1]
            );

            e++;
        }

        // Check connectivity
        ans[originalIndex] =
            dsu.findP(u) == dsu.findP(v);
    }

    return ans;
}
}